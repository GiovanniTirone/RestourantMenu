

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class DayBookings {
    LocalDate date;
    LunchBookings lunchPrenotations;
    DinnerBookings dinnerPrenotations;


    public void getNumbersOfFreeTables (LocalTime time) {
        for(Prenotation prenotation : lunchPrenotations){
            if(prenotation.numberTable )
        }
    }

    private List<Table> getFreeTables (String lunchOrDinner) {

        if(lunchOrDinner.equals("lunch")){
            lunchPrenotations.stream().filter(prenotation -> {
                if(prenotation.numberTable)
            });
        }
    }

    public int checkFreeTable (LocalTime time) {
        if(Calendar.checkIfHourIsLunchOrDinner(time).equals("lunch")){
            for(Prenotation prenotation : lunchPrenotations){
                if(prenotation.)
            }
        }else if(Calendar.checkIfHourIsLunchOrDinner(time).equals("dinner")){

        }else {
            return -1;
        };
    }
}
