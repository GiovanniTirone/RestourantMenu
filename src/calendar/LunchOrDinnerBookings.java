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
        for(int i=1; i<=Restaurant.tables.length; i++){
            if(takenTables.contains(i)) continue;
            else freeTables.add(i);
        }
        return freeTables;
    }


    public int getFreeTableAtTime (LocalTime time,int peopleNumber){
        Set<Integer> freeTables = getFreeTablesAtTime(time);
        for(Prenotation prenotation : this){
            int tableNum = prenotation.numberTable;
            if(freeTables.contains(tableNum) && Restaurant.tables[tableNum].seats>=peopleNumber){
                return tableNum;
            }
        }
        return -1;
    }
}
