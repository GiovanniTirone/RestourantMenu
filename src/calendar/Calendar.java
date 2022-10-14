package calendar;

import restaurant.Restaurant;
import restaurant.Table;
import tables.MyTables;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.time.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Calendar {
        public static List<DayBookings> bookings;

        private Calendar () {
              this.bookings =  new ArrayList<DayBookings>();
        }
        private static Calendar calendar = new Calendar();

        public static Calendar getCalendar ( ) {return calendar;}

        //Returns the number of a free table, if it doesn't exist returns a negative number
        public static int checkFreeTable (LocalDate date, LocalTime time, int peopleNumber) {

                if(bookings.size() == 0) {
                        return Restaurant.getTableForPeopleNumbers(peopleNumber);
                }

                for(DayBookings dayBookings : bookings){
                        if(!dayBookings.date.isEqual(date)){
                                return Restaurant.getTableForPeopleNumbers(peopleNumber);
                        }
                        if(dayBookings.date.isEqual(date)) {
                                if (Restaurant.timeIsInLunchRange(time)) {
                                        int freeTable = dayBookings.lunchBookings.getFreeTableAtTime(time,peopleNumber);
                                        if (freeTable>0) {
                                                return freeTable;
                                        }
                                }
                                if (Restaurant.timeIsInDinnerRange(time)) {
                                        int freeTable = dayBookings.dinnerBookings.getFreeTableAtTime(time,peopleNumber);
                                        if (freeTable>0) {
                                                return freeTable;
                                        }
                                }
                                break;
                        }
                }
                return -1;
        }


        public static DayBookings searchDayBookings (LocalDate date) {
                for(DayBookings dayBookings : bookings){
                        if(dayBookings.date.isEqual(date)) return dayBookings;
                }
                return null;
        }

        public static int bookTable (LocalDate date, LocalTime time, int peopleNumber, String name){
                if(date.isBefore(LocalDate.now())) return -1;
                int freeTable = checkFreeTable(date,time,peopleNumber);
                if(freeTable>0){
                        DayBookings dayBookings = searchDayBookings(date);
                        if(dayBookings!=null) {
                                dayBookings.addPrenotation(freeTable,time,name);
                        } else{
                                bookings.add(new DayBookings(date,time,freeTable,name));
                        }
                        return freeTable;
                } else {
                        return -1;
                }
        }


        public void sortBookings () {
                bookings.sort(new Comparator<DayBookings>() {
                        @Override
                        public int compare(DayBookings db1, DayBookings db2) {
                                return db1.date.compareTo(db2.date);
                        }
                });
        }
        public JTable createTable ( ){
                String col[] = {"Meal","Date","Time","Name", "Number Table"};
                DefaultTableModel tableModel = new DefaultTableModel(col, 0); // The 0 argument is number rows.
                JTable table = new JTable(tableModel);
                sortBookings();
                for(DayBookings db : bookings){
                        table = MyTables.concat(table,db.createTable(),col);
                }
                return table;
        }

        public JTable createTableOfDate (LocalDate date) {
                for(DayBookings db : bookings){
                        if(db.date.isEqual(date)) return db.createTable();
                }
                return null;
        }

                /*
        public String printBookingDates() {
                for(restaurant.Table table : tables ){

                }
        }*/
}


 /* DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
                LocalDate date = LocalDate.parse(dateTime.format(formatter),formatter);
                LocalTime time = LocalTime.parse(dateTime.format(formatter),formatter);*/