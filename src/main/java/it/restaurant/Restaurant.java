package it.restaurant;
import java.util.*;

public class Restaurant {

    private String name;

    Map <Integer,Table> tablesMap;

    public Restaurant(String name){
        this.name = name;
        this.tablesMap = new HashMap<>();
        tablesMap.put(1,new Table(1,3));
        tablesMap.put(2,new Table(2,4));
        tablesMap.put(3,new Table(3,4));
        tablesMap.put(4,new Table(4,5));
        tablesMap.put(5,new Table(5,8));
    }


    public void addTable (int number, int seating) throws Exception{
        if(tablesMap.keySet().stream().anyMatch(numberTable -> numberTable == number)) {
            throw  new Exception("A table with this number already exists");
        }
        tablesMap.put(number,new Table(number,seating));
    }

    /**
     * This method returns the number of the free table of the number of seats that comes closest to peopleNumber. If there
     * aren't free tables, it returns a negative integer. The method iterates over the tables, after check if the
     * number of the current iterating table is contained in the freeTablesNumbers, there is a check on the number of seating,
     * they must be greater or equal the peopleNumber. If the check is passed, if exists, the method returns the number of
     * the first table with its seating number exactly equals to the peopleNumber. If that table doesn't exist, the method
     * checks if the number of seating of the current table is less than the assignedTableSeats, in that case the method reassigns
     * that variable.
     * @param peopleNumber Number of minimum seating required on the table
     * @param freeTablesNumbers The numbers of free it.calendar.tables
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

    /**
     * Return a free table assuming that all the tables are free.
     * @param peopleNumber Number of minimun seating of the table
     * @return The number of a free table using the method getFreeTableFromFreeTables
     */
    public  int getTableFromAllTables (int peopleNumber) {
        Set<Integer>tablesNumbers = new HashSet<>();
        tablesMap.values().forEach(t -> tablesNumbers.add(t.number));
        return getTableFromFreeTables(peopleNumber,tablesNumbers);
    }

    /**
     * It returns a set with the numbers of free tables, knowing the taken tables numbers
     * @param takenTables A set of numbers of taken tables
     * @return   A set with the numbers of free tables
     */
    public Set<Integer> getFreeTables (Set<Integer> takenTables) {
        Set<Integer> freeTables = new HashSet<>();
        for(Table table : tablesMap.values()){
            if(takenTables.contains(table.number)) continue;
            else freeTables.add(table.number);
        }
        return freeTables;
    }

    /**
     * This method returns a number of a free table using the method getFreeTableFromFreeTables. If the free table doesn't
     * exist, it returns a negative integer.
     * @param peopleNumber Number of minimun seating of the table
     * @param takenTables  A set that contains the numbers of the taken tables
     * @return The number of a free table using the method getFreeTableFromFreeTables
     */
    public int getFreeTable(int peopleNumber, Set<Integer>takenTables){
        Set<Integer> freeTables = getFreeTables(takenTables);
        if(freeTables.size()>0) return getTableFromFreeTables(peopleNumber,freeTables);
        else{
            return -1;
        }
    }

}
