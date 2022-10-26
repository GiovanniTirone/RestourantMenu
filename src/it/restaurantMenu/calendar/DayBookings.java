package it.restaurantMenu.calendar;
import it.restaurantTimeTable.timeTable.TimeTable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class DayBookings {

    LocalDate date;
    MealsBooking breakfastBookings;
    MealsBooking lunchBookings;
    MealsBooking aperitifBookings;
    MealsBooking dinnerBookings;

    public DayBookings(LocalDate date){
        this.date = date;
        this.breakfastBookings = new MealsBooking();
        this.lunchBookings = new MealsBooking();
        this.aperitifBookings = new MealsBooking();
        this.dinnerBookings = new MealsBooking();
    }


    public void addBooking(String name, int tableNumber, LocalDate date, LocalTime time, TimeTable timeTable){


    }











}
