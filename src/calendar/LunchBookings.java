package calendar;

import restaurant.Restaurant;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class LunchBookings extends LunchOrDinnerBookings  {

    public LunchBookings ( ){ }
    public int getFreeTableAtTime (LocalTime time){
        if(!Restaurant.timeIsInLunchRange(time)) return -1;
        this.sortBookings();

        for(Prenotation prenotation : this){
            if(Math.abs(ChronoUnit.MINUTES.between(time, prenotation.time))>60){
                return prenotation.numberTable;
            }
        }
        return -1;
    }

}
