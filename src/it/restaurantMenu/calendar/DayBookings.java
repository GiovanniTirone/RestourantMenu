package it.restaurantMenu.calendar;
import calendar.Prenotation;
import it.restaurantTimeTable.timeTable.TimeTable;
import tables.MyTables;

import javax.swing.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

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

    public void addBooking(String name, int tableNumber, int peopleNumber, LocalDate date, LocalTime time, TimeTable timeTable){
        TypeMeals typeMeals = timeTable.getTypeMealsByTime(time);
        mealBookingsMap.get(typeMeals).add(new Booking(name,peopleNumber,tableNumber,date,time));
    }



    //JTABLE

    public JTable createTable () {
        for()
        return MyTables.concat( lunchBookings.createTable("LUNCH"),
                dinnerBookings.createTable("DINNER"),
                new String[]{"","Date","Time","Name", "Number Table"});
    }


}
