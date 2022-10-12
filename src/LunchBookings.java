import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LunchBookings extends LunchOrDinnerBookings  {

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
