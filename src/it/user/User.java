package it.user;
import it.calendar.Calendar;
import it.restaurant.Restaurant;
import it.timeTable.Week;
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


    public boolean bookTable (int persons, LocalDate date, LocalTime time, Calendar calendar, Week week , Restaurant restaurant) throws Exception {

            int bookTable = calendar.bookTable(name,persons, date, time, week,restaurant);
           /* if(bookTable == -3) {
                Map<String,Object> numberAndTime = calendar.bookTableAtDifferentTime(date, time, name, persons, restaurant, timeTable );
                if(numberAndTime != null) {System.out.println("La prenotazione per " + name + " e' stata effettuata con successo, al tavolo"
                        +" numero " + numberAndTime.get("numberOfFreeTable") +", il giorno "+ date + " alle ore " + numberAndTime.get("timeOfFreeTable"));
                    return true;
                }else return false;
            }*/
            if(bookTable>0) { System.out.println("La prenotazione per " + name + " e' stata effettuata con successo, al tavolo"
                                    +" numero " + bookTable +", il giorno "+ date + " alle ore " + time);
                              return true;
            } else {
                System.out.println("Non è stato possibile effettuare la prenotazione");
                return false;
            }

    }


}
