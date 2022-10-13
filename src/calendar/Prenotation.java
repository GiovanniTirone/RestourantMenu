package calendar;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Prenotation {

    public String name;
    public int numberTable;
    public LocalDate date;
    public LocalTime time;

    public Prenotation (int numberTable, LocalDate date, LocalTime time, String name){
        this.numberTable = numberTable;
        this.date = date;
        this.time = time;
        this.name =name;
    }

}
