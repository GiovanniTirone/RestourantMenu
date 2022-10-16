package restaurant;

import calendar.MealBookings;
import calendar.Prenotation;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Restaurant {
    public  Table tables [] = new Table []  { new Table(1, 3),
                                                    new Table(2, 4),
                                                    new Table(3, 4),
                                                    new Table(4, 6),
                                                    new Table(5, 3) };

    public  int totalSeats;


    private Restaurant () {
        for(Table table : this.tables) {
            this.totalSeats += table.seats;
        }

    }

    private static Restaurant restaurant = new Restaurant();
    public static Restaurant getRestaurant () {return restaurant;};


    public  int getTableSeatsByNumberTable (int number){
        for(Table table : tables){
            if(table.number == number) return table.seats;
        }
        return -1;
    }

    public  int getTableFromFreeTables(int peopleNumber, Set<Integer>freeTablesNumbers){
        int assignedTable =-1;
        int assignedTableSeats = -1;
        for(Table t : tables){
            if(freeTablesNumbers.contains(t.number)) {
                if (t.seats >= peopleNumber) {
                    if (t.seats == peopleNumber) {
                        assignedTable = t.number;
                        break;
                    }
                    if (t.seats < assignedTableSeats) {
                        assignedTable = t.number;
                        assignedTableSeats = t.seats;
                        continue;
                    }
                    if (assignedTable < 0) {
                        assignedTable = t.number;
                        assignedTableSeats = t.seats;
                    }
                }
            }
        }
        return assignedTable;
    }

    public  int getTableFromAllTables (int peopleNumber) {
        Set<Integer>tablesNumbers = new HashSet<>();
        Arrays.stream(tables).forEach(t -> tablesNumbers.add(t.number));
        return getTableFromFreeTables(peopleNumber,tablesNumbers);
    }

    public Set<Integer> getFreeTables (Set<Integer> takenTables) {
        Set<Integer> freeTables = new HashSet<>();
        for(Table table : restaurant.tables){
            if(takenTables.contains(table.number)) continue;
            else freeTables.add(table.number);
        }
        return freeTables;
    }

    public int getFreeTable(int peopleNumber, Set<Integer>takenTables){
        Set<Integer> freeTables = getFreeTables(takenTables);
        if(freeTables.size()>0) return getTableFromFreeTables(peopleNumber,freeTables);
        else{
            return -1;
        }
    }

    public Table getTableByNumber(int number) {
        for (Table t : tables) {if(t.number == number) return t;}
        return null;
    }

    public int returnFirstFreeTableAtTime (LocalTime time, int peopleNumber, MealBookings mealBookings,TimeTable timeTable) {
        List <Long> distances = new ArrayList<>();
        List <Integer> distancesNumberTables = new ArrayList<>();
        long maxDistance = Long.MIN_VALUE;
        int maxDistanceTable;
        for(Prenotation p : mealBookings){
            if(getTableByNumber(p.numberTable).seats<peopleNumber)continue;
            long dist = ChronoUnit.MINUTES.between(time,p.time);
            if(dist<0){if(time.minusMinutes(Math.abs(dist)))}
            distances.add(dist);
            distancesNumberTables.add(p.numberTable);
            if (Math.abs(dist) > Math.abs(maxDistance)) {
                maxDistance = dist;
                maxDistanceTable = p.numberTable;
            }

        }

    }
}
