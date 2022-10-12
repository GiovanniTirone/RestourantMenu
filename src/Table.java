import java.time.*;

public class Table {
    int number;
    int seats;

    TableBookings bookings;


    Table (int number, int seats){
        this.number = number;
        this.seats = seats;
    }

    @Override
    public String toString() {
        return "\nTable number: " + number + "\n  Seats: " + seats +"\n Bookings: " + bookings.toString();
    }



}
