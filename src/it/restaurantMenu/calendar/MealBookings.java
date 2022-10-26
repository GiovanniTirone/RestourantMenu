package it.restaurantMenu.calendar;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class MealBookings extends ArrayList <Booking>{

    TypeMeals typeMeals;

    public MealBookings(TypeMeals typeMeal) {
        this.typeMeals = typeMeal;
    }

    public int checkFreeTables(LocalTime time, int numberOfPeople){

        List<Integer> numberOfFreeTable = new ArrayList<>();

        for(Booking booking : this){
            if (Math.abs(ChronoUnit.MINUTES.between(time, booking.getTime())) <60) continue;
            numberOfFreeTable.add(booking.getTableNumber());
        }
        return numberOfFreeTable.get(0);
    }

}
