package calendar;

import restaurant.Restaurant;

import java.time.LocalDate;
import java.time.LocalTime;

public class DayBookings {
    LocalDate date;
    MealBookings lunchBookings;
    MealBookings dinnerBookings;

    public DayBookings (LocalDate date){
        this.date = date;
        this.lunchBookings = new MealBookings();
        this.dinnerBookings = new MealBookings();
    }

    public DayBookings(LocalDate date ,LocalTime time ,int tableNumber,String name){
        this.date = date;
        this.lunchBookings = new MealBookings();
        this.dinnerBookings = new MealBookings();
        this.addPrenotation(tableNumber,time,name);
    }

    public  void addPrenotation (int tableNumber , LocalTime time, String name) {
        if (Restaurant.timeIsInLunchRange(time)) {
            this.lunchBookings.add(new Prenotation(tableNumber,date,time,name));
        }else{
            this.dinnerBookings.add(new Prenotation(tableNumber,date,time,name));
        }
    }

}
