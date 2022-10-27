package it.calendar;
import it.timeTable.TimeTable;
import it.utilities.tables.MyTables;
import javax.swing.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public class DayBookings {

    protected LocalDate date;
    protected Map <TypeMeals,MealBookings> mealBookingsMap ;


    public DayBookings(LocalDate date){
        this.date = date;
        this.mealBookingsMap = new HashMap<>();
        for(TypeMeals typeMeals : TypeMeals.values()){
            mealBookingsMap.put(typeMeals,new MealBookings(typeMeals));
        }
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Map<TypeMeals, MealBookings> getMealBookingsMap() {
        return mealBookingsMap;
    }

    public void setMealBookingsMap(Map<TypeMeals, MealBookings> mealBookingsMap) {
        this.mealBookingsMap = mealBookingsMap;
    }

    public void addBooking(String name, int tableNumber, int peopleNumber, LocalDate date, LocalTime time, TimeTable timeTable) throws Exception {
        TypeMeals typeMeals = timeTable.getTypeMealsByTime(time);
        mealBookingsMap.get(typeMeals).add(new Booking(name,peopleNumber,tableNumber,date,time));
    }


    public JTable createTable () {
        JTable mealBookingsArrayTables [] =  Arrays.stream(mealBookingsMap.values().toArray(new MealBookings[0]))
                                                .map(mealBookings -> mealBookings.createTable())
                                                .toArray(JTable[]::new);
        return MyTables.concatArray(mealBookingsArrayTables, new String[]{"","Date","Time","Name", "Number Table"});
    }


}
