package it.restaurantMenu.calendar;
import calendar.Prenotation;
import it.restaurantTimeTable.timeTable.TimeTable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public class DayBookings {

    LocalDate date;

    Map <TypeMeals,MealBookings> mealBookingsMap ;
    MealBookings breakfastBookings;
    MealBookings lunchBookings;
    MealBookings aperitifBookings;
    MealBookings dinnerBookings;

    public DayBookings(LocalDate date){
        this.date = date;
        this.mealBookingsMap = new HashMap<>();
        this.breakfastBookings = new MealBookings(TypeMeals.BREAKFAST);
        this.lunchBookings = new MealBookings(TypeMeals.LUNCH);
        this.aperitifBookings = new MealBookings(TypeMeals.APERITIF);
        this.dinnerBookings = new MealBookings(TypeMeals.DINNER);
        this.mealBookingsMap.put(TypeMeals.BREAKFAST,breakfastBookings);
        this.mealBookingsMap.put(TypeMeals.LUNCH,lunchBookings);
        this.mealBookingsMap.put(TypeMeals.APERITIF,aperitifBookings);
        this.mealBookingsMap.put(TypeMeals.DINNER,dinnerBookings);
    }


    public void addBooking(String name, int tableNumber, LocalDate date, LocalTime time, TimeTable timeTable){
        if (timeTable.timeIsInLunchRange(time)) {
            this.lunchBookings.add(new Prenotation(tableNumber,date,time,name));
        }else{
            this.dinnerBookings.add(new Prenotation(tableNumber,date,time,name));
        }
    }











}
