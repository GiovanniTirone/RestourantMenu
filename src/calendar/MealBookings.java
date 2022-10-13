package calendar;

import restaurant.Restaurant;
import restaurant.Table;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class MealBookings extends ArrayList <Prenotation> {

    public MealBookings () {};
    public void sortBookings () {
        this.sort(new Comparator<Prenotation>() {
            @Override
            public int compare(Prenotation p1, Prenotation p2) {
                return p1.time.compareTo(p2.time);
            }
        });
    }

    public JTable createTable (String meal) {
        String col[] = {"Meal","Date","Time","Name", "Number Table"};
        DefaultTableModel tableModel = new DefaultTableModel(col, 0); // The 0 argument is number rows.
        JTable table = new JTable(tableModel);
        sortBookings();
        for(Prenotation p : this){
            tableModel.addRow(new Object[]{meal,p.date,p.time,p.name,p.numberTable});
        }
        return table;
    }

    public Set<Integer> getFreeTablesAtTime (LocalTime time) {
        Set<Integer> takenTables = new HashSet<>();
        Set<Integer> freeTables = new HashSet<>();
        for(Prenotation prenotation : this){
            if(Math.abs(ChronoUnit.MINUTES.between(time, prenotation.time))<60){
                takenTables.add(prenotation.numberTable);
            }
        }
        for(int i=1; i<=Restaurant.tables.length; i++){
            if(takenTables.contains(i)) continue;
            else freeTables.add(i);
        }
        return freeTables;
    }


    public int getFreeTableAtTime (LocalTime time,int peopleNumber){
        Set<Integer> freeTables = getFreeTablesAtTime(time);
        for(Table table : Restaurant.tables){
            if(freeTables.contains(table.number)&&table.seats>=peopleNumber){
                return table.number;
            }
        }
        return -1;
    }
}
