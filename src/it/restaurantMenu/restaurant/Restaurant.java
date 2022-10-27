package it.restaurantMenu.restaurant;

import calendar.MealBookings;
import calendar.Prenotation;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Restaurant {

    private String name;

    Map <Integer,Table> tablesMap;

    public Restaurant(String name){
        this.name = name;
        this.tablesMap = new HashMap<>();
    }

    public void addTable (int number, int seating) throws Exception{
        if(tablesMap.keySet().stream().anyMatch(numberTable -> numberTable == number)) {
            throw  new Exception("A table with this number already exists");
        }
        tablesMap.put(number,new Table(number,seating));
    }

    /**
     * This method returns the number of the free table of the number of seats that comes closest to peopleNumber. If there
     * aren't free tables, it return a negative integer.
     * @param peopleNumber Number of minimum seating required on the table
     * @param freeTablesNumbers The numbers of free tables
     * @return  The number of the free table of the number of seats that comes closest to peopleNumber.
     */
    public int getTableFromFreeTables(int peopleNumber, Set<Integer> freeTablesNumbers){
        int assignedTable =-1;
        int assignedTableSeats = -1;
        for(Table t : tablesMap.values()){
            if(freeTablesNumbers.contains(t.number)) {
                if (t.seating >= peopleNumber) {
                    if (t.seating == peopleNumber) {
                        assignedTable = t.number;
                        break;
                    }
                    if (t.seating < assignedTableSeats) {
                        assignedTable = t.number;
                        assignedTableSeats = t.seating;
                        continue;
                    }
                    if (assignedTable < 0) {
                        assignedTable = t.number;
                        assignedTableSeats = t.seating;
                    }
                }
            }
        }
        return assignedTable;
    }

    public  int getTableFromAllTables (int peopleNumber) {
        Set<Integer>tablesNumbers = new HashSet<>();
        tablesMap.values().forEach(t -> tablesNumbers.add(t.number));
        return getTableFromFreeTables(peopleNumber,tablesNumbers);
    }

    public Set<Integer> getFreeTables (Set<Integer> takenTables) {
        Set<Integer> freeTables = new HashSet<>();
        for(Table table : tablesMap.values()){
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



    /*
    public Map<String,Object> getFirstFreeTableAtTime (LocalTime time, int peopleNumber, MealBookings mealBookings, TimeTable timeTable) {
        List <Long> distances = new ArrayList<>();
        List <Integer> distancesNumberTables = new ArrayList<>();
        long maxDistance = Long.MIN_VALUE;
        int maxDistanceTable = -1;
        LocalTime newTime = time;
        for(Prenotation p : mealBookings){
            if(getTableByNumber(p.numberTable).seats<peopleNumber) continue;
            long dist = ChronoUnit.MINUTES.between(time,p.time);
            newTime = time.plusMinutes(dist);
            if(!timeTable.timeIsInOpeningRange(newTime)) continue;
            distances.add(dist);
            distancesNumberTables.add(p.numberTable);
            if (Math.abs(dist) > Math.abs(maxDistance)) {
                maxDistance = dist;
                maxDistanceTable = p.numberTable;
            }
        }
        if(maxDistanceTable<0) return null;
        Map<String,Object> NumberAndTime = new HashMap<>();
        NumberAndTime.put("numberOfFreeTable",maxDistanceTable);
        NumberAndTime.put("timeOfFreeTable",newTime);
        return NumberAndTime;
    }

     */
}
