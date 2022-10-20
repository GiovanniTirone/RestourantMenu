package it.restaurantMenu.timeTable;

import java.time.LocalTime;

public class TimeTable {
    LocalTime lunchOpeningTime;
    LocalTime lunchClosureTime;
    LocalTime dinnerOpeningTime;
    LocalTime dinnerClosureTime;

    public TimeTable () {};

    public TimeTable (LocalTime lunchOpeningTime,LocalTime lunchClosureTime,LocalTime dinnerOpeningTime,LocalTime dinnerClosureTime){
        this.lunchOpeningTime = lunchOpeningTime;
        this.lunchClosureTime = lunchClosureTime;
        this.dinnerOpeningTime = dinnerOpeningTime;
        this.dinnerClosureTime = dinnerClosureTime;
    }


    public LocalTime getLunchOpeningTime() {
        return lunchOpeningTime;
    }

    public void setLunchOpeningTime(LocalTime lunchOpeningTime) {
        this.lunchOpeningTime = lunchOpeningTime;
    }

    public void setLunchOpeningTime(int hour, int min){
         this.lunchOpeningTime = LocalTime.of(hour,min);
    }

    public LocalTime getLunchClosureTime() {
        return lunchClosureTime;
    }

    public void setLunchClosureTime(LocalTime lunchClosureTime) {
        this.lunchClosureTime = lunchClosureTime;
    }

    public void setLunchClosureTime(int hour, int min){
        this.lunchClosureTime = LocalTime.of(hour,min);
    }

    public LocalTime getDinnerOpeningTime() {
        return dinnerOpeningTime;
    }

    public void setDinnerOpeningTime(LocalTime dinnerOpeningTime) {
        this.dinnerOpeningTime = dinnerOpeningTime;
    }

    public void setDinnerOpeningTime(int hour, int min){
        this.dinnerOpeningTime =  LocalTime.of(hour,min);
    }

    public LocalTime getDinnerClosureTime() {
        return dinnerClosureTime;
    }

    public void setDinnerClosureTime(LocalTime dinnerClosureTime) {
        this.dinnerClosureTime = dinnerClosureTime;
    }

    public void setDinnerClosureTime(int hour, int min){
        this.dinnerClosureTime = LocalTime.of(hour,min);
    }




    public String print () {
        return  "lunchOpeningTime: " + lunchOpeningTime +
                "\nlunchClosureTime: " + lunchClosureTime +
                "\ndinnerOpeningTime: " + dinnerOpeningTime +
                "\ndinnerClosureTime: " + dinnerClosureTime  ;
    }
}
