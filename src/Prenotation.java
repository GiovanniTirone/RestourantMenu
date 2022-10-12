import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Prenotation {

    int numberTable;
    LocalDate date;
    LocalTime time;

    public Prenotation (int numberTable, LocalDate date, LocalTime time){
        this.numberTable = numberTable;
        this.date = date;
        this.time = time;
    }

}
