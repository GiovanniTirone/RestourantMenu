package it.restaurantTimeTable.timeTable;

public class TestWeek {
    public static void main (String ...args){
        Week week = new Week();
        week.setStandardWeekdaysTimeTable();
        week.setStandardWeekendTimeTable();
        week.setStandardTimeTableForAllDays();
        System.out.println(week.printDetails());
    }

}
