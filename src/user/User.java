package user;

import calendar.Calendar;
import restaurant.Restaurant;
import restaurant.TimeTable;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Map;

public class User {
    String name;

    public User(String name){
        this.name = name;
    }

    @Override
    public String toString(){
        return "Username: " + name;
    }


    public boolean bookTable (int persons, LocalDate date, LocalTime time, Calendar calendar, TimeTable timeTable , Restaurant restaurant) {

            int bookTable = calendar.bookTable(date, time, persons,this.name, timeTable,restaurant);
            if(bookTable == -3) {
                Map<String,Object> numberAndTime = calendar.bookTableAtDifferentTime(date, time, name, persons, restaurant, timeTable );
                if(numberAndTime != null) {System.out.println("La prenotazione per " + name + " e' stata effettuata con successo, al tavolo"
                        +" numero " + numberAndTime.get("numberOfFreeTable") +", il giorno "+ date + " alle ore " + numberAndTime.get("timeOfFreeTable"));
                    return true;
                }else return false;
            }
            if(bookTable>0) { System.out.println("La prenotazione per " + name + " e' stata effettuata con successo, al tavolo"
                                    +" numero " + bookTable +", il giorno "+ date + " alle ore " + time);
                              return true;
            } else {
                System.out.println("Non è stato possibile effettuare la prenotazione");
                return false;
            }

    }


}
