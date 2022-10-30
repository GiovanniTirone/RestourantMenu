package it.calendar;
import it.restaurantTimeTable.timeTable.TimeTable;
import it.restaurantTimeTable.timeTable.Week;
import it.calendar.jtabs.MyTables;
import javax.swing.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;


/**
 * This class is used to save all the bookings of a specific day. The day is specified by the LocalDate date, while the
 * bookings are saved in a MelaBookings object, according to their time (the time determinate the TypeMeal). All the
 * MealBookings objects are saved in the map mealBookingsMap, using the TypeMeals as key.
 */
public class DayBookings {

    protected LocalDate date;
    protected Map <TypeMeals,MealBookings> mealBookingsMap ;


    public DayBookings(LocalDate date){
        this.date = date;
        this.mealBookingsMap = new HashMap<>();
        for(TypeMeals typeMeals : TypeMeals.values()){
            mealBookingsMap.put(typeMeals,new MealBookings(typeMeals));
        }
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Map<TypeMeals, MealBookings> getMealBookingsMap() {
        return mealBookingsMap;
    }

    public void setMealBookingsMap(Map<TypeMeals, MealBookings> mealBookingsMap) {
        this.mealBookingsMap = mealBookingsMap;
    }

    /**
     * This method adds a booking in the corresponding MelBookings object, using the method getTypeMealsByTime of the class
     * TimeTable to determinate the TypeMeals from the time.
     * @param name The name of the person who has booked
     * @param tableNumber The number of the table booked
     * @param peopleNumber The number of the people that are supposed to use the table
     * @param date The date of the booking
     * @param time The time of the booking
     * @param week The week of the restaurant, containing the timetables of all days
     * @throws Exception There is an exception if the time doesn't fit in the timetable of the day.
     */
    public void addBooking(String name, int tableNumber, int peopleNumber, LocalDate date, LocalTime time, Week week) throws Exception {
        TimeTable timeTable = week.getTimeTableOfDate(date);
        TypeMeals typeMeals = timeTable.getTypeMealsByTime(time);
        mealBookingsMap.get(typeMeals).add(new Booking(name,peopleNumber,tableNumber,date,time));
    }


    public JTable createTable () {
        JTable mealBookingsArrayTables [] =  Arrays.stream(mealBookingsMap.values().toArray(new MealBookings[0]))
                                                .map(mealBookings -> mealBookings.createTable())
                                                .toArray(JTable[]::new);
        return MyTables.concatArray(mealBookingsArrayTables, new String[]{"","Date","Time","Name", "Number Table"});
    }


}
