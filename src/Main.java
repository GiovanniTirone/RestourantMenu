import calendar.Calendar;
import menu.Menu;
import restaurant.Restaurant;
import restaurant.TimeTable;
import tables.MyTables;
import user.User;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    //create the menu:
    static Menu menu = Menu.getMenu();

    //create restaurant and the calendar
    static Restaurant restaurant = Restaurant.getRestaurant();
    static Calendar calendar = Calendar.getCalendar();

    static TimeTable ordinaryTimeTable = new TimeTable ();

    public static void main(String[] args) {


        //create the drinks:
        menu.addDrink("Acqua");
        menu.addDrink("Vino","Uva della Valtellina");
        menu.addDrink("Birra",new ArrayList<>(Arrays.asList("Acqua","Malto d'Orzo","Luppolo","Lievito")));
        menu.addDrink("Caffe'",new ArrayList<>(Arrays.asList("Acqua","Caffè")));
        menu.addDrink("The",new ArrayList<>(Arrays.asList("Acqua","The")));
        menu.addDrink("Aranciata",new ArrayList<>(Arrays.asList("Arance","Acqua","Zucchero")));

        //print the menu
        System.out.println(menu.toString());

        //create some users
        User user1 = new User("Giovanni");
        User user2 = new User( "Fabio");
        User user3 = new User("Francesco");
        User user4 = new User("Pietro");


        bookTable(user1,4,15,10,2022,20,00);
        bookTable(user2,4,15,10,2022,20,00);
        bookTable(user3,2,15,10,2022,13,15);
        bookTable(user4,3,16,10,2022,13,50);
        bookTable(user2,6,16,10,2022,12,15);
        bookTable(user3,3,10,11,2022,21,00);
        bookTable(user1,5,11,11,2022,20,00);


        MyTables.visualizeTable(calendar.createTable());
        //MyTables.visualizeTable(calendar.createTableOfDate(LocalDate.of(2022,10,15)));
        //MyTables.visualizeTable(Calendar.searchDayBookings(LocalDate.of(2022,10,15)).dinnerBookings.createTable("DINNER"));
    }

    public static boolean bookTable (User user,int persons,int day,int month,int year,int hour,int min){
        return user.bookTable(persons,LocalDate.of(year,month,day),LocalTime.of(hour,min),calendar,ordinaryTimeTable);
    }



}