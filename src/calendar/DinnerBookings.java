package calendar;

import restaurant.Restaurant;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class DinnerBookings extends LunchOrDinnerBookings {

    public int getFreeTableAtTime (LocalTime time, int peopleNum){
        if(!Restaurant.timeIsInDinnerRange(time)) return -1;
        return super.getFreeTableAtTime(time, peopleNum);
    }
}
