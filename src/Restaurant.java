import java.time.*;
import java.time.chrono.ChronoLocalDate;
import java.util.Arrays;
import java.util.Comparator;

public class Restaurant {
    public static Table tables [] ={  new Table(1,3),
                        new Table(2,4),
                        new Table(3,4),
                        new Table(4,6),
                        new Table(5,3)
                                                    };

    public static int totalSeats;

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
        lunchOpeningHour = LocalTime.of(12,00);
        lunchClosureHour = LocalTime.of(14,00) ;
        dinnerOpeningHour = LocalTime.of(19,00);
        dinnerClosureHour = LocalTime.of(22,00);
    }

    public static int checkFreeTable (int persons , LocalDate date, LocalTime hour) {
        if(hour.isBefore((lunchOpeningHour))||(hour.isAfter(lunchClosureHour)&&hour.isBefore(dinnerOpeningHour))||hour.isAfter(dinnerClosureHour)){
            return -1;
        }
        LocalDateTime dateTime = date.atTime(hour);
        for(Table table : tables){
            if(table.bookings == null) {
                return table.number;
            }
            else if(table.bookings.isTableFreeAtDateTime(dateTime) && persons<=table.seats){
                return table.number;
            }
        }
        return -1;
    }

    public 

    /*
    public void orderTablesByDates () {
        Arrays.sort(tables, new Comparator<Table>() {
            public int compare(Table t1, Table t2) {
                if(t1.bookings==null && t2.bookings==null){
                    return 0;
                }
                else if(t1.bookings==null) {
                    return 1;
                }
                else if(t2.bookings==null) {
                    return -1;
                }
                else{
                    return t1..compareTo(t2.bookedDateTime);
                }
            }
        });
    }
    */
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
