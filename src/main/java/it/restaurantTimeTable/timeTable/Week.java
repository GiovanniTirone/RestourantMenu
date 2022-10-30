package it.restaurantTimeTable.timeTable;
import it.calendar.TypeMeals;

import java.time.LocalDate;
import java.util.Arrays;

public class Week  {
    private Day days [];
    private TimeTable weekdaysTimeTable;
    private TimeTable weekendTimeTable;

    public Week () {
        this.days = Arrays.stream(DayOfWeek.values())
                          .map(dayOfWeek -> new Day(dayOfWeek))
                          .toArray(Day[]::new);
        this.weekendTimeTable = new TimeTable();
        this.weekdaysTimeTable = new TimeTable();
    }

    public Day[] getDays() {
        return days;
    }

    public void setDays(Day[] days) {
        this.days = days;
    }

    public TimeTable getTimeTableOfDate (LocalDate date){
        java.time.DayOfWeek dayOfWeek = date.getDayOfWeek();
        return days[dayOfWeek.getValue()%7].getTimeTable();
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
        this.weekdaysTimeTable.setMealTime(TypeMeals.LUNCH,OpenClosure.OPEN,12,00);
        this.weekdaysTimeTable.setMealTime(TypeMeals.LUNCH,OpenClosure.CLOSURE,14,30);
        this.weekdaysTimeTable.setMealTime(TypeMeals.DINNER,OpenClosure.OPEN,19,00);
        this.weekdaysTimeTable.setMealTime(TypeMeals.DINNER,OpenClosure.CLOSURE,22,00);
    }

    public TimeTable getWeekendTimeTable() {
        return weekendTimeTable;
    }

    public void setWeekendTimeTable(TimeTable weekendTimeTable) {
        this.weekendTimeTable = weekendTimeTable;
    }

    public void setStandardWeekendTimeTable() {
        this.weekendTimeTable.setMealTime(TypeMeals.LUNCH,OpenClosure.OPEN,11,30);
        this.weekendTimeTable.setMealTime(TypeMeals.LUNCH,OpenClosure.CLOSURE,15,00);
        this.weekendTimeTable.setMealTime(TypeMeals.DINNER,OpenClosure.OPEN,19,00);
        this.weekendTimeTable.setMealTime(TypeMeals.DINNER,OpenClosure.CLOSURE,23,00);
    }

    public String printDetails() {
        String daysStr =  "";
        String weekdaysTT = weekdaysTimeTable == null ? "null" :  weekdaysTimeTable.printDetails();
        String weekendTT = weekendTimeTable == null ? "null" :  weekendTimeTable.printDetails();
        for(Day day: days){daysStr += "\n" + day.printDetails();}
        return "  WEEK : " +
                "\ndays: " + daysStr +
                "\nweekdaysTimeTable:\n" +   weekdaysTT +
                "\nweekendTimeTable:\n" + weekendTT ;
    }

}
