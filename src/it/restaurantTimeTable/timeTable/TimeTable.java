package it.restaurantTimeTable.timeTable;
import it.restaurantMenu.calendar.TypeMeals;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

public class TimeTable {

    private Map <TypeMeals, Map<OpenClosure,LocalTime>> openClosureTimesMap;
    private LocalTime breakfastOpeningTime;
    private LocalTime breakfastClosureTime;
    private LocalTime lunchOpeningTime;
    private LocalTime lunchClosureTime;
    private LocalTime aperitifOpeningTime;
    private LocalTime aperitifClosureTime;
    private LocalTime dinnerOpeningTime;
    private LocalTime dinnerClosureTime;

    public TimeTable () {};

    public TimeTable (LocalTime breakfastOpeningTime,LocalTime breakfastClosureTime,LocalTime lunchOpeningTime,LocalTime lunchClosureTime,
                      LocalTime aperitifOpeningTime, LocalTime aperitifClosureTime, LocalTime dinnerOpeningTime,LocalTime dinnerClosureTime){
        this.breakfastOpeningTime = breakfastOpeningTime;
        this.breakfastClosureTime = breakfastClosureTime;
        this.lunchOpeningTime = lunchOpeningTime;
        this.lunchClosureTime = lunchClosureTime;
        this.aperitifOpeningTime = aperitifOpeningTime;
        this.aperitifClosureTime = aperitifClosureTime;
        this.dinnerOpeningTime = dinnerOpeningTime;
        this.dinnerClosureTime = dinnerClosureTime;

        openClosureTimesMap.put(TypeMeals.BREAKFAST, Map.of(OpenClosure.OPEN,breakfastOpeningTime,OpenClosure.CLOSURE,breakfastClosureTime));
        openClosureTimesMap.put(TypeMeals.LUNCH,Map.of(OpenClosure.OPEN,lunchOpeningTime,OpenClosure,))
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








    public TypeMeals getTypeMealsByTime(LocalTime time){

        if (time.isAfter(lunchOpeningTime) && time.isBefore(lunchClosureTime)) return TypeMeals.LUNCH;
        if (time.isAfter(dinnerOpeningTime) && time.isBefore(dinnerClosureTime)) return TypeMeals.DINNER;
        return null;
        }




    public String print () {
        return  "\ndinnerClosureTime: " + breakfastOpeningTime + //aggiungere
                "\ndinnerClosureTime: " + breakfastClosureTime + //aggiungere
                "lunchOpeningTime: " + lunchOpeningTime +
                "\nlunchClosureTime: " + lunchClosureTime +
                "\ndinnerOpeningTime: " + dinnerOpeningTime +
                "\ndinnerClosureTime: " + dinnerClosureTime

                ;
    }
}
