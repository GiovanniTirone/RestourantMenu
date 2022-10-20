package it.restaurantMenu.timeTable;
import it.restaurantMenu.menu.*;

public class TestWeek {
    public static void main (String ...args){
        Week week = new Week();
        week.setStandardWeekdaysTimeTable();
        week.setStandardWeekendTimeTable();
        week.setStandardTimeTableForAllDays();
        System.out.println(week.print());
    }
}
