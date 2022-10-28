package it.calendar;
import it.restaurant.Restaurant;
import it.restaurantTimeTable.timeTable.Week;
import it.calendar.jtabs.MyTables;
import it.user.User;
import java.time.LocalDate;
import java.time.LocalTime;

public class TestBooking {
    public static void main(String[] args) throws Exception {
        Week week = new Week();
        week.setStandardWeekdaysTimeTable();
        week.setStandardWeekendTimeTable();
        week.setStandardTimeTableForAllDays();
        System.out.println(week.printDetails());
        Restaurant restaurant = new Restaurant("Team-1");
        Calendar calendar = Calendar.getCalendar();
        User user1 = new User("Fabio");
        User user2 = new User("Francesco");
        User user3 = new User("Pietro");
        User user4 = new User("Gio");

        try {
            user1.bookTable(4, LocalDate.of(2022, 11, 01), LocalTime.of(13, 00), calendar, week, restaurant);
            user2.bookTable(3, LocalDate.of(2022, 11, 02), LocalTime.of(20, 00), calendar, week, restaurant);
            user3.bookTable(2, LocalDate.of(2022, 11, 01), LocalTime.of(13, 30), calendar, week, restaurant);
            user4.bookTable(4, LocalDate.of(2022, 11, 01), LocalTime.of(14, 00), calendar, week, restaurant);
            user1.bookTable(6, LocalDate.of(2022, 11, 01), LocalTime.of(15, 00), calendar, week, restaurant);
            user2.bookTable(3, LocalDate.of(2022, 11, 01), LocalTime.of(21, 00), calendar, week, restaurant);
            user3.bookTable(2, LocalDate.of(2022, 11, 01), LocalTime.of(22, 00), calendar, week, restaurant);
            user4.bookTable(8, LocalDate.of(2022, 11, 01), LocalTime.of(12, 00), calendar, week, restaurant);
        } catch (Exception e){
            e.printStackTrace();
        }

        MyTables.visualizeTable(calendar.createTable());

    }


}
