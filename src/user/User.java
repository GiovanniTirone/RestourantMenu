package user;

import calendar.Calendar;
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


    public void bookTable (int persons, LocalDate date, LocalTime time,Calendar calendar) {

            int bookTable = Calendar.bookTable(date, time, persons,this.name, calendar );
            if(bookTable>0) System.out.println("La prenotazione per " + name + " e' stata effettuata con successo, al tavolo"
                                    +" numero " + bookTable +", il giorno "+ date + " alle ore " + time);
            else System.out.println("Non è stato possibile effettuare la prenotazione");

    }


}
