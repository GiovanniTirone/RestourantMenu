package it.calendar;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.*;


/**
 * This class is an extension of the ArrayList class and is used to save the bookings of a specific TypeMeals, that is
 * indicated in the variable typeMeals.
 */
public class MealBookings extends ArrayList <Booking>{

    TypeMeals typeMeals;

    public MealBookings(TypeMeals typeMeal) {
        this.typeMeals = typeMeal;
    }

    /**
     * This method is used to get a set of taken tables, within the tables of this MealBookings object. A table is considered
     * taken if it is booked in a range of 60 minutes from the time given in input.
     * @param time  The time when you want to know the taken tables
     * @return A set containing the numbers of taken tables in the range of 60 minutes from the input time.
     */
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
        sortBookings();
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
