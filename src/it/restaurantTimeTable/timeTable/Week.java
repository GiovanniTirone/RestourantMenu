package it.restaurantTimeTable.timeTable;
import java.util.Arrays;

public class Week  {
    private Day days [];
    private TimeTable weekdaysTimeTable;
    private TimeTable weekendTimeTable;

    public Week () {
        this.days = Arrays.stream(DayOfWeek.values())
                          .map(dayOfWeek -> new Day(dayOfWeek))
                          .toArray(Day[]::new);
    }

    public Day[] getDays() {
        return days;
    }

    public void setDays(Day[] days) {
        this.days = days;
    }

    public void setStandardTimeTableForAllDays () {
        Arrays.stream(days).forEach(day -> {
            if(day.name.isWorkingDay()){
                if(day.name.isWeekendDay()) {
                    day.setTimeTable(weekendTimeTable);
                }
                else day.setTimeTable(weekdaysTimeTable);
            }
        });
    }

    public TimeTable getWeekdaysTimeTable() {
        return weekdaysTimeTable;
    }

    public void setWeekdaysTimeTable(TimeTable weekdaysTimeTable) {
        this.weekdaysTimeTable = weekdaysTimeTable;
    }

    public void setStandardWeekdaysTimeTable(){
        this.weekdaysTimeTable = new TimeTable();
        this.weekdaysTimeTable.setLunchOpeningTime(12,00);
        this.weekdaysTimeTable.setLunchClosureTime(14,30);
        this.weekdaysTimeTable.setDinnerOpeningTime(19,00);
        this.weekdaysTimeTable.setDinnerClosureTime(22,00);
    }

    public TimeTable getWeekendTimeTable() {
        return weekendTimeTable;
    }

    public void setWeekendTimeTable(TimeTable weekendTimeTable) {
        this.weekendTimeTable = weekendTimeTable;
    }

    public void setStandardWeekendTimeTable() {
        this.weekendTimeTable = new TimeTable();
        this.weekendTimeTable.setLunchOpeningTime(11,30);
        this.weekendTimeTable.setLunchClosureTime(15,00);
        this.weekendTimeTable.setDinnerOpeningTime(19,00);
        this.weekendTimeTable.setDinnerClosureTime(23,00);
    }

    public String print () {
        String daysStr =  "";
        String weekdaysTT = weekdaysTimeTable == null ? "null" :  weekdaysTimeTable.print();
        String weekendTT = weekendTimeTable == null ? "null" :  weekendTimeTable.print();
        for(Day day: days){daysStr += "\n" + day.print();}
        return "  WEEK : " +
                "\ndays: " + daysStr +
                "\nweekdaysTimeTable:\n" +   weekdaysTT +
                "\nweekendTimeTable:\n" + weekendTT ;
    }

}
