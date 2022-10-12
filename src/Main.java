import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //create the menu:
        Menu menu = Menu.getMenu();

        //create the drinks:
        Drink water = new Drink("Acqua");
        Drink wine = new Drink ("Vino","Uva della Valtellina");
        Drink beer = new Drink ("Birra",new ArrayList<>(Arrays.asList("Acqua","Malto d'Orzo","Luppolo","Lievito")));
        Drink coffee = new Drink("Caffe'",new ArrayList<>(Arrays.asList("Acqua","Caffè")));
        Drink the = new Drink("The",new ArrayList<>(Arrays.asList("Acqua","The")));
        Drink orangeJuice = new Drink("Aranciata",new ArrayList<>(Arrays.asList("Arance","Acqua","Zucchero")));

        //create the menu drinks List and add the drinks to it:
        menu.drinks = new DishList<>();
        menu.drinks.add(water);
        menu.drinks.add(wine);
        menu.drinks.add(beer);
        menu.drinks.add(coffee);
        menu.drinks.add(the);
        menu.drinks.add(orangeJuice);

        //print the menu
        System.out.println(menu.toString());


        //create restaurant
        Restaurant restaurant = Restaurant.getRestaurant();
        User user1 = new User("Giovanni");
        User user2 = new User( "Fabio");


       /*
       Restaurant.tables[0].bookedDateTime = LocalDateTime.of(2022,10,12,12,00);
       Restaurant.tables[1].bookedDateTime = LocalDateTime.of(2022,10,12,20,00);
       Restaurant.tables[2].bookedDateTime = LocalDateTime.of(2022,10,15,11,30);
       Restaurant.tables[3].bookedDateTime = LocalDateTime.of(2022,12,19,21,00);
       Restaurant.tables[4].bookedDateTime = LocalDateTime.of(2022,11,20,23,22);
    */

       user1.bookTable(4, LocalDate.of(2022,10,15),LocalTime.of(13,00));
       user2.bookTable

       System.out.println(Arrays.toString(Restaurant.tables));

       restaurant.orderTablesByDates();

       System.out.println(Arrays.toString(Restaurant.tables));
    }
}