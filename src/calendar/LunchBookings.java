package calendar;

import restaurant.Restaurant;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class LunchBookings extends LunchOrDinnerBookings  {

    public LunchBookings ( ){ }
    public int getFreeTableAtTime (LocalTime time){
        if(!Restaurant.timeIsInLunchRange(time)) return -1;
        return super.getFreeTableAtTime(time);
    }

}
