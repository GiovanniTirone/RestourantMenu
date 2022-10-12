import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Calendar {
        public List<DayBookings> bookings = new ArrayList<>();

        public static String checkIfHourIsLunchOrDinner (LocalTime time){
                if(time.isAfter(Restaurant.lunchOpeningHour)&&time.isBefore(Restaurant.lunchClosureHour)){
                        return "lunch";
                }else if(time.isAfter(Restaurant.dinnerOpeningHour)&&time.isBefore(Restaurant.dinnerClosureHour)){
                        return "dinner";
                }else{
                        return "not valid hour";
                }
        }

        public int checkFreeTable (LocalDate date, LocalTime time) {

               /* DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
                LocalDate date = LocalDate.parse(dateTime.format(formatter),formatter);
                LocalTime time = LocalTime.parse(dateTime.format(formatter),formatter);*/

                for(DayBookings dayBookings : bookings){

                        if(dayBookings.date != date) continue;

                        if(checkIfHourIsLunchOrDinner(time).equals("lunch")){
                                for(Prenotation prenotation : dayBookings.lunchPrenotations){

                                }
                        }
                }
        }




                /*
        public String printBookingDates() {
                for(Table table : tables ){

                }
        }*/
}
