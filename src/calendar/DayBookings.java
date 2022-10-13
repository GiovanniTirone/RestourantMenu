package calendar;

import restaurant.Restaurant;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class DayBookings {
    LocalDate date;
    LunchBookings lunchPrenotations;
    DinnerBookings dinnerPrenotations;

    public DayBookings (LocalDate date){
        this.date = date;
        this.lunchPrenotations = new LunchBookings();
        this.dinnerPrenotations = new DinnerBookings();
    }

    public DayBookings(LocalDate date ,LocalTime time ,int tableNumber,String name){
        this.date = date;
        this.lunchPrenotations = new LunchBookings();
        this.dinnerPrenotations = new DinnerBookings();
        this.addPrenotation(tableNumber,time,name);
    }

    public  void addPrenotation (int tableNumber , LocalTime time, String name) {
        if (Restaurant.timeIsInLunchRange(time)) {
            this.lunchPrenotations.add(new Prenotation(tableNumber,date,time,name));
        }else{
            this.dinnerPrenotations.add(new Prenotation(tableNumber,date,time,name));
        }
    }

}
