import calendar.Calendar;
import menu.DishList;
import menu.Drink;
import menu.Menu;
import restaurant.Restaurant;
import user.User;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //create the menu:
        Menu menu = Menu.getMenu();

        //create the drinks:
        menu.addDrink("Acqua");
        menu.addDrink("Vino","Uva della Valtellina");
        menu.addDrink("Birra",new ArrayList<>(Arrays.asList("Acqua","Malto d'Orzo","Luppolo","Lievito")));
        menu.addDrink("Caffe'",new ArrayList<>(Arrays.asList("Acqua","Caffè")));
        menu.addDrink("The",new ArrayList<>(Arrays.asList("Acqua","The")));
        menu.addDrink("Aranciata",new ArrayList<>(Arrays.asList("Arance","Acqua","Zucchero")));

        //print the menu
        System.out.println(menu.toString());

        //create restaurant and the calendar
        Restaurant restaurant = Restaurant.getRestaurant();
        Calendar calendar = Calendar.getCalendar();

        //create some users
        User user1 = new User("Giovanni");
        User user2 = new User( "Fabio");
        User user3 = new User("Francesco");
        User user4 = new User("Pietro");

        user1.bookTable(4,LocalDate.of(2022,10,15),LocalTime.of(20,00));
        user2.bookTable(4,LocalDate.of(2022,10,15),LocalTime.of(20,00));


    }

}