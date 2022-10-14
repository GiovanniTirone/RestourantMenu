package restaurant;

import calendar.DayBookings;

import java.time.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Restaurant {
    public static Table tables [] = new Table []  { new Table(1, 3),
                                                    new Table(2, 4),
                                                    new Table(3, 4),
                                                    new Table(4, 6),
                                                    new Table(5, 3) };

    public static int totalSeats;

    public static LocalTime lunchOpeningHour;
    public static LocalTime lunchClosureHour;
    public static LocalTime dinnerOpeningHour;
    public static LocalTime dinnerClosureHour;

    private Restaurant () {
        for(Table table : this.tables) {
            this.totalSeats += table.seats;
        }

        lunchOpeningHour = LocalTime.of(12,00);
        lunchClosureHour = LocalTime.of(14,00) ;
        dinnerOpeningHour = LocalTime.of(19,00);
        dinnerClosureHour = LocalTime.of(22,00);
    }

    private static Restaurant restaurant = new Restaurant();
    public static Restaurant getRestaurant () {return restaurant;};


    public static boolean timeIsInLunchRange (LocalTime time){
        if(time.isAfter(lunchOpeningHour)&&time.isBefore(lunchClosureHour))return true;
        else return false;
    }

    public static boolean timeIsInDinnerRange (LocalTime time){
        if(time.isAfter(dinnerOpeningHour)&&time.isBefore(dinnerClosureHour))return true;
        else return false;
    }

    public static boolean timeIsInOpeningRange (LocalTime time){
        if(timeIsInDinnerRange(time)||timeIsInLunchRange(time))return true;
        else return false;
    }

    public static int getTableSeatsByNumberTable (int number){
        for(Table table : tables){
            if(table.number == number) return table.seats;
        }
        return -1;
    }

    public static int getTableForPeopleNumbers (int peopleNumber){
        int minNumberSeats = peopleNumber;
        int minNumberTable = -1;
        for(Table t : tables){
            if(t.seats==peopleNumber) {
                minNumberTable = t.number;
                break;
            }else if(t.seats<peopleNumber){
                continue;
            }else if(t.seats<minNumberSeats){
                minNumberSeats = t.seats;
                minNumberTable = t.number;
            }
        }
        return minNumberTable;
    }


}
