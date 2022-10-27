package it.restaurantMenu.calendar;
import it.restaurantMenu.restaurant.Restaurant;
import it.restaurantTimeTable.timeTable.TimeTable;
import tables.MyTables;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public class Calendar {

    public  List<DayBookings> dayBookingsList;

    private Calendar () {
        this.dayBookingsList =  new ArrayList<DayBookings>();
    }
    private static Calendar calendar = new Calendar();

    public static Calendar getCalendar ( ) {return calendar;}

    //Returns the number of a free table, if it doesn't exist returns a negative number
    public int checkFreeTable (DayBookings targetDayBookings, LocalTime time, int peopleNumber, TypeMeals typeMeal, Restaurant restaurant) {

        if(dayBookingsList.size() == 0) {
            return restaurant.getTableFromAllTables(peopleNumber);
        }

        if(targetDayBookings == null) {
            return restaurant.getTableFromAllTables(peopleNumber);}
        else {
            Set<Integer> takenTables = targetDayBookings.mealBookingsMap.get(typeMeal).getTakenTablesAtTime(time);
            return restaurant.getFreeTable(peopleNumber,takenTables);
        }
    }


    public DayBookings searchDayBookings (LocalDate date) {
        for(DayBookings dayBookings : dayBookingsList){
            if(dayBookings.date.isEqual(date)) return dayBookings;
        }
        return null;
    }

    public  int bookTable (LocalDate date, LocalTime time, int peopleNumber, String name, TimeTable timetable, Restaurant restaurant){
        if(date.isBefore(LocalDate.now())) return -1;
        TypeMeals typeMeals = timetable.getTypeMealsByTime(time);
        if(typeMeals == null) return -2;
        DayBookings targetDayBookings = searchDayBookings(date);
        int freeTable = checkFreeTable(targetDayBookings,time,peopleNumber,typeMeals,restaurant);

        if(freeTable<0){
            return -3;
        }
        if(freeTable>0){
            if(targetDayBookings!=null) {
                targetDayBookings.addBooking(name,freeTable,peopleNumber,date,time,timetable);
            } else{
                DayBookings newDayBookings = new DayBookings(date);
                newDayBookings.addBooking(name,freeTable,peopleNumber,date,time,timetable);
                dayBookingsList.add(newDayBookings);
            }
            return freeTable;
        } else {
            return -1;
        }
    }

    public JTable createTable (){
        String col[] = {"Meal","Date","Time","Name", "Number Table"};
        DefaultTableModel tableModel = new DefaultTableModel(col, 0); // The 0 argument is number rows.
        JTable table = new JTable(tableModel);
        sortBookings();
        for(DayBookings db : dayBookingsList){
            table = MyTables.concat(table,db.createTable(),col);
        }
        return table;
    }

    public JTable createTableOfDate (LocalDate date) {
        for(DayBookings db : dayBookingsList){
            if(db.date.isEqual(date)) return db.createTable();
        }
        return null;
    }

    public void sortBookings () {
        dayBookingsList.sort(new Comparator<DayBookings>() {
            @Override
            public int compare(DayBookings db1, DayBookings db2) {
                return db1.date.compareTo(db2.date);
            }
        });
    }

    /*

    public Map<String,Object> bookTableAtDifferentTime (LocalDate date, LocalTime time, String name, int peopleNumber, Restaurant restaurant, TimeTable timeTable) {
        calendar.DayBookings dayBookings = searchDayBookings(date);
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

     */

    /*
    public  boolean removePrenotation (LocalDate date, LocalTime time, int tableNumber,TimeTable timeTable) {
        calendar.DayBookings db = searchDayBookings(date);
        if(db != null) return db.removePrenotation(tableNumber,time,timeTable);
        return false;
    }

    public void removeAllBookingsBefore (LocalDate date) {
        dayBookingsList.stream().filter(db -> !db.date.isBefore(date));
    }

    public  void removeOldBookings(){
        removeAllBookingsBefore(LocalDate.now());
    }



    */




}
