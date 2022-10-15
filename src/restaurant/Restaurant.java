package restaurant;

import java.time.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Restaurant {
    public static Table tables [] = new Table []  { new Table(1, 3),
                                                    new Table(2, 4),
                                                    new Table(3, 4),
                                                    new Table(4, 6),
                                                    new Table(5, 3) };

    public static int totalSeats;


    private Restaurant () {
        for(Table table : this.tables) {
            this.totalSeats += table.seats;
        }

    }

    private static Restaurant restaurant = new Restaurant();
    public static Restaurant getRestaurant () {return restaurant;};


    public static int getTableSeatsByNumberTable (int number){
        for(Table table : tables){
            if(table.number == number) return table.seats;
        }
        return -1;
    }

    public static int getTableFromFreeTables(int peopleNumber, Set<Integer>freeTablesNumbers){
        int assignedTable =-1;
        int assignedTableSeats = -1;
        for(Table t : tables){
            if(freeTablesNumbers.contains(t.number)) {
                if (t.seats >= peopleNumber) {
                    if (t.seats == peopleNumber) {
                        assignedTable = t.seats;
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

    public static int getTableFromAllTables (int peopleNumber) {
        Set<Integer>tablesNumbers = new HashSet<>();
        Arrays.stream(tables).forEach(t -> tablesNumbers.add(t.number));
        return getTableFromFreeTables(peopleNumber,tablesNumbers);
    }

}
