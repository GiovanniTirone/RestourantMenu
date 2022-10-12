package calendar;

import restaurant.Restaurant;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class DinnerBookings extends LunchOrDinnerBookings {

    public int getFreeTableAtTime (LocalTime time){
        if(!Restaurant.timeIsInDinnerRange(time)) return -1;
        this.sortBookings();

        for(Prenotation prenotation : this){
            if(Math.abs(ChronoUnit.MINUTES.between(time, prenotation.time))>60){
                return prenotation.numberTable;
            }
        }
        return -1;
    }
}
