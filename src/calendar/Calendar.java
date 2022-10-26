package calendar;

import it.restaurantMenu.calendar.TypeMeals;
import restaurant.Restaurant;
import restaurant.TimeTable;
import tables.MyTables;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.time.*;
import java.util.*;

public class Calendar {
        public  List<DayBookings> bookings;

        private Calendar () {
              this.bookings =  new ArrayList<DayBookings>();
        }
        private static Calendar calendar = new Calendar();

        public static Calendar getCalendar ( ) {return calendar;}

        //Returns the number of a free table, if it doesn't exist returns a negative number
        public int checkFreeTable (LocalDate date, LocalTime time, int peopleNumber, TypeMeals typeMeal , Restaurant restaurant) {

                if(bookings.size() == 0) {
                        return restaurant.getTableFromAllTables(peopleNumber);
                }

                DayBookings targetDayBooking = searchDayBookings(date);

                if(targetDayBooking == null) {
                        return restaurant.getTableFromAllTables(peopleNumber);}
                else if(){
                        Set<Integer> takenTables = targetDayBooking.lunchBookings.getTakenTablesAtTime(time);
                        return restaurant.getFreeTable(peopleNumber,takenTables);
                } else {
                        Set<Integer> takenTables = targetDayBooking.dinnerBookings.getTakenTablesAtTime(time);
                        return restaurant.getFreeTable(peopleNumber,takenTables);
                 }
        }


        public DayBookings searchDayBookings (LocalDate date) {
                for(DayBookings dayBookings : bookings){
                        if(dayBookings.date.isEqual(date)) return dayBookings;
                }
                return null;
        }

        public  int bookTable (LocalDate date, LocalTime time, int peopleNumber, String name, TimeTable timetable, Restaurant restaurant){
                if(date.isBefore(LocalDate.now())) return -1;
                String lunchOrDinner = timetable.timeIsInLunchOrDinnerRange(time);
                if(lunchOrDinner.equals("no")) return -2;
                int freeTable = checkFreeTable(date,time,peopleNumber,lunchOrDinner,restaurant);
                DayBookings dayBookings = searchDayBookings(date);
                if(freeTable<0){
                      return -3;
                }
                if(freeTable>0){
                        if(dayBookings!=null) {
                                dayBookings.addPrenotation(freeTable,time,name,timetable);
                        } else{
                                bookings.add(new DayBookings(date,time,freeTable,name,timetable));
                        }
                        return freeTable;
                } else {
                        return -1;
                }
        }

        public Map<String,Object> bookTableAtDifferentTime (LocalDate date, LocalTime time, String name, int peopleNumber, Restaurant restaurant,TimeTable timeTable) {
                DayBookings dayBookings = searchDayBookings(date);
                String lunchOrDinner = timeTable.timeIsInLunchOrDinnerRange(time);
                if (lunchOrDinner.equals("lunch")) {
                        Map<String, Object> numberAndTime = restaurant.getFirstFreeTableAtTime(time, peopleNumber, dayBookings.lunchBookings, timeTable);
                        if (askForFreeTable((LocalTime) numberAndTime.get("timeOfFreeTable"))) {
                                dayBookings.addPrenotation((int) numberAndTime.get("numberOfFreeTable"), (LocalTime) numberAndTime.get("timeOfFreeTable"), name, timeTable);
                                return numberAndTime;
                        } else return null;
                } else {
                        Map<String, Object> numberAndTime = restaurant.getFirstFreeTableAtTime(time, peopleNumber, dayBookings.dinnerBookings, timeTable);
                        if (askForFreeTable((LocalTime) numberAndTime.get("timeOfFreeTable"))) {
                                dayBookings.addPrenotation((int) numberAndTime.get("numberOfFreeTable"), (LocalTime) numberAndTime.get("timeOfFreeTable"), name, timeTable);
                                return  numberAndTime;
                        } else return null;
                }
        }

        public boolean askForFreeTable (LocalTime time) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("There is a free table at time " + time.toString());
                System.out.println("Please insert yes if you want to book at this time, otherwise insert no");
                String command = scanner.nextLine();
                while(true) {
                        if(command.equals("yes")) return true;
                        else if(command.equals("no")) return false;
                        System.out.println("Please insert yes if you want to book at this time, otherwise insert no");
                        command = scanner.nextLine();
                }
        }


        public  boolean removePrenotation (LocalDate date, LocalTime time, int tableNumber,TimeTable timeTable) {
                DayBookings db = searchDayBookings(date);
                if(db != null) return db.removePrenotation(tableNumber,time,timeTable);
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