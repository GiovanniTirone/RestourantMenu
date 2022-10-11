import java.time.*;
import java.time.chrono.ChronoLocalDate;

public class Restaurant {
    public static Table tables [] ={  new Table(1,3),
                        new Table(2,4),
                        new Table(3,4),
                        new Table(4,6),
                        new Table(5,3)
                                                    };

    public int totalSeats;

    public static LocalTime lunchOpeningHour;
    public static LocalTime lunchClosureHour;
    public static LocalTime dinnerOpeningHour;
    public static LocalTime dinnerClosureHour;

    private static Restaurant restaurant = new Restaurant();
    public static Restaurant getRestaurant () {return restaurant;};


    private Restaurant () {
        for(Table table : this.tables) {
            this.totalSeats += table.seats;
        }
    }

    public static int checkFreeTable (int persons , LocalDate date, LocalTime hour) {
        if(hour.isBefore((lunchOpeningHour))||(hour.isAfter(lunchClosureHour)&&hour.isBefore(dinnerOpeningHour))||hour.isAfter(dinnerClosureHour)){
            return -1;
        }
        for(Table table : tables){
            if(!(date.isEqual(table.bookedDate) && hour.equals(table.bookedTime)) && persons<=table.seats){
                return table.number;
            }
        }
        return -1;
    }


    /*
    public static boolean checkOldBooking (Table table){
        LocalDate currentDate = LocalDate.now();
        if(table.bookedDate.isBefore(currentDate)){
            t
        }
    }

    public static String printBookings () {
        String str = "";
        for(Table table : tables){
            str += "\n Table number: " + table.number + " - Booked day: "
        }
    }

    */

}
