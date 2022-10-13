package user;

import calendar.Calendar;
import org.xml.sax.helpers.AttributesImpl;
import restaurant.Restaurant;

import java.time.LocalDate;
import java.time.LocalTime;

public class User {
    String name;

    public User(String name){
        this.name = name;
    }

    @Override
    public String toString(){
        return "Username: " + name;
    }


    public String bookTable (int persons, LocalDate date, LocalTime time) {

            boolean bookTable = Calendar.bookTable(date, time, persons,this.name );
            if(bookTable) return "La prenotazione è stata effettuata con successo!";
            else return "Non è stato possibile effettuare la prenotazione";

    }


}
