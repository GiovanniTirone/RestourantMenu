package user;

import restaurant.Restaurant;

import java.time.LocalDate;
import java.time.LocalTime;

public class User {
    String name;

    public User(String name){
        this.name = name;
    }

    @Override
    public String toString(){
        return "Username: " + name;
    }

    public void bookTable (int persons, LocalDate date, LocalTime hour) {
        int freeTableNumber = Restaurant.checkFreeTable(persons,date,hour);
        if(freeTableNumber>0){
            Restaurant.tables[freeTableNumber].bookings.add(date.atTime(hour));
        }
    }

}
