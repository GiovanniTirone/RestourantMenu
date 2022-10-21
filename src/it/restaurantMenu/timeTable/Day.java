package it.restaurantMenu.timeTable;
import it.restaurantMenu.menu.Menu;

public class Day {
    DayOfWeek name;
    Menu menu;
    TimeTable timeTable;

    public Day (DayOfWeek name){
        this.name = name;
    }

    public DayOfWeek getName() {
        return name;
    }

    public void setName(DayOfWeek name) {
        this.name = name;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public TimeTable getTimeTable() {
        return timeTable;
    }

    public void setTimeTable(TimeTable timeTable) {
        this.timeTable = timeTable;
    }


    public String print () {
        String strTT = timeTable == null ? " null" : "\n " + timeTable.print();
        return "Day: " + name.print() +
                "\n TimeTable: " +  strTT;
    }
}
