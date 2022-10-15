package calendar;

import restaurant.Restaurant;
import tables.MyTables;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.time.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Calendar {
        public  List<DayBookings> bookings;

        private Calendar () {
              this.bookings =  new ArrayList<DayBookings>();
        }
        private static Calendar calendar = new Calendar();

        public static Calendar getCalendar ( ) {return calendar;}

        //Returns the number of a free table, if it doesn't exist returns a negative number
        public int checkFreeTable (LocalDate date, LocalTime time, int peopleNumber, String lunchOrDinner) {

                if(bookings.size() == 0) {
                        return Restaurant.getTableFromAllTables(peopleNumber);
                }

                DayBookings targetDayBooking = searchDayBookings(date);

                if(targetDayBooking == null) {
                        return Restaurant.getTableFromAllTables(peopleNumber);}
                else{
                        return lunchOrDinner.equals("lunch") ?
                                targetDayBooking.lunchBookings.getFreeTableAtTime(time, peopleNumber) :
                                targetDayBooking.dinnerBookings.getFreeTableAtTime(time, peopleNumber);
                }
        }


        public DayBookings searchDayBookings (LocalDate date) {
                for(DayBookings dayBookings : bookings){
                        if(dayBookings.date.isEqual(date)) return dayBookings;
                }
                return null;
        }

        public  int bookTable (LocalDate date, LocalTime time, int peopleNumber, String name){
                if(date.isBefore(LocalDate.now())) return -1;
                String lunchOrDinner = Restaurant.timeIsInLunchOrDinnerRange(time);
                if(lunchOrDinner.equals("no")) return -2;
                int freeTable = checkFreeTable(date,time,peopleNumber,lunchOrDinner);
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

        public  boolean removePrenotation (LocalDate date, LocalTime time, int tableNumber) {
                DayBookings db = searchDayBookings(date);
                if(db != null) return db.removePrenotation(tableNumber,time);
                return false;
        }

        public void removeAllBookingsBefore (LocalDate date) {
                bookings.stream().filter(db -> !db.date.isBefore(date));
        }

        public  void removeOldBookings(){
                removeAllBookingsBefore(LocalDate.now());
        }

        public void sortBookings () {
                bookings.sort(new Comparator<DayBookings>() {
                        @Override
                        public int compare(DayBookings db1, DayBookings db2) {
                                return db1.date.compareTo(db2.date);
                        }
                });
        }
        public JTable createTable (){
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