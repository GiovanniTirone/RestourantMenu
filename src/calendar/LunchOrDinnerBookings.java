package calendar;

import restaurant.Restaurant;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class LunchOrDinnerBookings extends ArrayList <Prenotation> {
    public void sortBookings () {
        this.sort(new Comparator<Prenotation>() {
            @Override
            public int compare(Prenotation p1, Prenotation p2) {
                return p1.time.compareTo(p2.time);
            }
        });
    }

    public Set<Integer> getFreeTablesAtTime (LocalTime time) {
        Set<Integer> takenTables = new HashSet<>();
        Set<Integer> freeTables = new HashSet<>();
        for(Prenotation prenotation : this){
            if(Math.abs(ChronoUnit.MINUTES.between(time, prenotation.time))<60){
                takenTables.add(prenotation.numberTable);
            }
        }
        for(int i=1; i<Restaurant.tables.length; i++){
            if(takenTables.contains(i)) continue;
            else freeTables.add(i);
        }
        return freeTables;
    }


    public int getFreeTableAtTime (LocalTime time){



        for(Prenotation prenotation : this){
            if(Math.abs(ChronoUnit.MINUTES.between(time, prenotation.time))>60){
                if(this.stream().allMatch(prenotation1 ->
                        prenotation1.numberTable == prenotation.numberTable
                                && Math.abs(ChronoUnit.MINUTES.between(time, prenotation1.time))>60)){
                    return prenotation.numberTable;
                }

            }
        }
        return -1;
    }
}
