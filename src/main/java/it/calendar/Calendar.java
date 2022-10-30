package it.calendar;
import it.restaurant.Restaurant;
import it.restaurantTimeTable.timeTable.TimeTable;
import it.restaurantTimeTable.timeTable.Week;
import it.calendar.jtabs.MyTables;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;


/**
 * This class is used to save the dayBookings in the list dayBookingsList. For add a new booking the class uses the method
 * bookTable, which in turn uses searchFreeTable to search for a free table in a particular date and time.
 */
public class Calendar {

    public  List<DayBookings> dayBookingsList;

    private Calendar () {
        this.dayBookingsList =  new ArrayList<DayBookings>();
    }
    private static Calendar calendar = new Calendar();

    public static Calendar getCalendar ( ) {return calendar;}

    /**This method searches into the dayBookingList from a free table. If there aren't dayBookings in the list or if the
     * targetDayBookings is null, the method searches for a free table invoking the method getTableFromALlTables of
     * the class Restaurant. Otherwise, the method creates a set of taken tables invoking the method getTakenTablesAtTime
     * of the class MealBookings and then pass this value to the method getFreeTable of the class Restaurant. In this way
     * the return is the number of a free table, if exists, and a negative integer, if not.
     *
     * @param targetDayBookings The dayBookings corresponding to the date of the booking to add
     * @param time The time of the booking
     * @param peopleNumber The minimun number of seating of the table
     * @param typeMeal This is in reality not necessary, because it depends on the time
     * @param restaurant The restaurant with the tables
     * @return The number of a free table, if exists, and a negative integer, if not.
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
            targetDayBookings.addBooking(name,freeTable,peopleNumber,date,time,week);
        } else {
            DayBookings newDayBookings = new DayBookings(date);
            newDayBookings.addBooking(name,freeTable,peopleNumber,date,time,week);
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

}
