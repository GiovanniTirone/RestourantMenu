package restaurant;

import java.time.*;

public class Table {
    int number;
    int seats;


    Table (int number, int seats){
        this.number = number;
        this.seats = seats;
    }

    @Override
    public String toString() {
        return "\nrestaurant.Table number: " + number + "\n  Seats: " + seats +"\n Bookings: " + bookings.toString();
    }

    public LocalTime getTimeOfLunch

}
