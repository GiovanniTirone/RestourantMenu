package calendar;

import restaurant.Restaurant;
import restaurant.TimeTable;
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

    public DayBookings(LocalDate date ,LocalTime time ,int tableNumber,String name,TimeTable timeTable){
        this.date = date;
        this.lunchBookings = new MealBookings();
        this.dinnerBookings = new MealBookings();
        this.addPrenotation(tableNumber,time,name,timeTable);
    }

    public void addPrenotation (int tableNumber , LocalTime time, String name, TimeTable timeTable) {
        if (timeTable.timeIsInLunchRange(time)) {
            this.lunchBookings.add(new Prenotation(tableNumber,date,time,name));
        }else{
            this.dinnerBookings.add(new Prenotation(tableNumber,date,time,name));
        }
    }

    public boolean removePrenotation (int tableNumber, LocalTime time, TimeTable timeTable){
        if(timeTable.timeIsInLunchRange(time)){
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
    }

}
