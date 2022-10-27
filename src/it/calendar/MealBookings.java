package it.calendar;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.*;

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

    public Set<Integer> getTakenTablesAtTime (LocalTime time) {
        Set<Integer> takenTables = new HashSet<>();
        for(Booking booking: this){
            if(Math.abs(ChronoUnit.MINUTES.between(time, booking.time))<60){
                takenTables.add(booking.tableNumber);
            }
        }
        return takenTables;
    }

    public JTable createTable () {
        String col[] = {"Meal","Date","Time","Name", "Number Table"};
        DefaultTableModel tableModel = new DefaultTableModel(col, 0); // The 0 argument is number rows.
        JTable table = new JTable(tableModel);
        //sortBookings(); agigungere
        for(Booking b : this){
            tableModel.addRow(new Object[]{typeMeals.getName(),b.date,b.time,b.name,b.tableNumber});
        }
        return table;
    }

    public void sortBookings () {
        this.sort(new Comparator<Booking>() {
            @Override
            public int compare(Booking b1,Booking b2) {
                return b1.date.compareTo(b2.date);
            }
        });
    }

}
