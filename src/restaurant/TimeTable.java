package restaurant;

import java.time.LocalTime;

public class TimeTable {

    public  LocalTime lunchOpeningHour;
    public  LocalTime lunchClosureHour;
    public  LocalTime dinnerOpeningHour;
    public  LocalTime dinnerClosureHour;

    public TimeTable() {
        lunchOpeningHour = LocalTime.of(12,00);
        lunchClosureHour = LocalTime.of(14,00) ;
        dinnerOpeningHour = LocalTime.of(19,00);
        dinnerClosureHour = LocalTime.of(22,00);
    }

    public TimeTable(LocalTime lunchOpeningHour, LocalTime lunchClosureHour, LocalTime  dinnerOpeningHour, LocalTime dinnerClosureHour) {
        this.lunchOpeningHour = lunchOpeningHour;
        this.lunchClosureHour = lunchClosureHour;
        this.dinnerOpeningHour = dinnerOpeningHour;
        this.dinnerClosureHour = dinnerClosureHour;
    }

    public  boolean timeIsInLunchRange (LocalTime time){
        if(time.isAfter(lunchOpeningHour)&&time.isBefore(lunchClosureHour))return true;
        else return false;
    }

    public  boolean timeIsInDinnerRange (LocalTime time){
        if(time.isAfter(dinnerOpeningHour)&&time.isBefore(dinnerClosureHour))return true;
        else return false;
    }

    public  boolean timeIsInOpeningRange (LocalTime time){
        if(timeIsInDinnerRange(time)||timeIsInLunchRange(time))return true;
        else return false;
    }

    public  String timeIsInLunchOrDinnerRange (LocalTime time){
        if(timeIsInLunchRange(time)) return "lunch";
        if(timeIsInDinnerRange(time)) return "dinner";
        else return "no";
    }


}
