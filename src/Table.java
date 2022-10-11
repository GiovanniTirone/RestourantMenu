import java.time.*;

public class Table {
    int number;
    int seats;

    LocalDateTime bookedDateTime;


    Table (int number, int seats){
        this.number = number;
        this.seats = seats;
        //this.bookedDate = LocalDate.of(0000,00,00);
        //this.bookedTime = LocalTime.of(00,00,00);
    }

    @Override
    public String toString() {
        return "\nTable number: " + number + " -- Seats: " + seats +"day " + bookedDateTime;
    }

}
