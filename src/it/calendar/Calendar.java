package it.calendar;
import it.restaurant.Restaurant;
import it.timeTable.TimeTable;
import it.timeTable.Week;
import it.utilities.tables.MyTables;
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

    /**This method searches into the dayBookingList from a free table.
     *
     * @param targetDayBookings
     * @param time
     * @param peopleNumber
     * @param typeMeal
     * @param restaurant
     * @return
     */
    public int searchFreeTable(DayBookings targetDayBookings, LocalTime time, int peopleNumber, TypeMeals typeMeal, Restaurant restaurant) {

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

    /**
     * This method is used to add a new booking to the dayBookingList. The booking cannot happen
     * if the date is before the current date or if the time doesn't fit in the timetable of the day of the week. In
     * these cases the method returns a negative integer. If these cases do not arise, the method search from
     * a free table with the method searchFreeTable. If the return is negative, the booking fails,
     * otherwise the method add a new booking to the dayBookings of the corresponding date, if already exists,
     * if not, the method creates a new DayBookings with the new booking. Finally, the method returns the number of the booked table.
     * @param name  Name of the person who is booking the table
     * @param peopleNumber Number of minimun seating of the table
     * @param date The date of booking
     * @param time The time of booking
     * @param week The week of the restaurant, where is set the timetable for each day
     * @param restaurant A restaurant object, that contains all the tables
     * @return The number of a free table, if exists, if not, it returns a negative integer.
     * @throws Exception There is an exception if the time required doesn't fit in the timetable of the restaurant
     */
    public  int bookTable (String name, int peopleNumber, LocalDate date, LocalTime time, Week week, Restaurant restaurant) throws Exception {
        if(date.isBefore(LocalDate.now())) return -1;
        TimeTable timeTable = week.getTimeTableOfDate(date);
        TypeMeals typeMeals = timeTable.getTypeMealsByTime(time);
        if(typeMeals == null) return -2;
        DayBookings targetDayBookings = searchDayBookings(date);
        int freeTable = searchFreeTable(targetDayBookings,time,peopleNumber,typeMeals,restaurant);
        if(freeTable<0) return -3 ;
        if(targetDayBookings!=null) {
            targetDayBookings.addBooking(name,freeTable,peopleNumber,date,time,timeTable);
        } else {
            DayBookings newDayBookings = new DayBookings(date);
            newDayBookings.addBooking(name,freeTable,peopleNumber,date,time,timeTable);
            dayBookingsList.add(newDayBookings);
        }
        return freeTable;
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
