package calendar;

import restaurant.Restaurant;
import tables.MyTables;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.time.LocalDate;
import java.time.LocalTime;

public class DayBookings {
    public LocalDate date;
    public MealBookings lunchBookings;
    public MealBookings dinnerBookings;

    public DayBookings (LocalDate date){
        this.date = date;
        this.lunchBookings = new MealBookings();
        this.dinnerBookings = new MealBookings();
    }

    public DayBookings(LocalDate date ,LocalTime time ,int tableNumber,String name){
        this.date = date;
        this.lunchBookings = new MealBookings();
        this.dinnerBookings = new MealBookings();
        this.addPrenotation(tableNumber,time,name);
    }

    public void addPrenotation (int tableNumber , LocalTime time, String name) {
        if (Restaurant.timeIsInLunchRange(time)) {
            this.lunchBookings.add(new Prenotation(tableNumber,date,time,name));
        }else{
            this.dinnerBookings.add(new Prenotation(tableNumber,date,time,name));
        }
    }

    public boolean removePrenotation (int tableNumber, LocalTime time){
        if(Restaurant.timeIsInLunchRange(time)){
            for(Prenotation prenotation : this.lunchBookings){
                if(prenotation.numberTable == tableNumber && prenotation.time==time){
                    lunchBookings.remove(prenotation);
                    return true;
                }
            }
        }else {
            for(Prenotation prenotation : this.dinnerBookings){
                if(prenotation.numberTable == tableNumber && prenotation.time==time){
                    dinnerBookings.remove(prenotation);
                    return true;
                }
            }
        }
        return false;
    }

    public JTable createTable () {
        return MyTables.concat( lunchBookings.createTable("LUNCH"),
                                dinnerBookings.createTable("DINNER"),
                                new String[]{"","Date","Time","Name", "Number Table"});

        /*JTable lunch_tab = lunchBookings.createTable("LUNCH");
        JTable dinner_tab = dinnerBookings.createTable("DINNER");
        String col[] = {"","Date","Time","Name", "Number Table"};
        DefaultTableModel tableModel = new DefaultTableModel(col, 0); // The 0 argument is number rows.
        JTable table = new JTable(tableModel);
        for(int i=1; i<lunch_tab.getRowCount(); i++){
            Object row [] = new Object[col.length];
            for(int j=0; j<col.length; j++){
                 row[j] = (lunch_tab.getValueAt(i,j));
            }
            tableModel.addRow(row);
        }
        for(int i=1; i<dinner_tab.getRowCount(); i++){
            Object row [] = new Object[col.length];
            for(int j=0; j<col.length; j++){
                row[j] = (dinner_tab.getValueAt(i,j));
            }
            tableModel.addRow(row);
        }
        return table;*/
    }

}
