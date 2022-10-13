package menu;

import calendar.DayBookings;

import java.util.List;

public class Menu {
    public String restaurantName = "Ristorante Team-1" ;
    public String type = "Vegano";
    public DishList<Drink> drinks;
   /* public menu.DishList <menu.First> firsts;
    public menu.DishList <menu.Second> seconds;
    public menu.DishList sweets;*/

    private Menu  () {
        this.drinks = new DishList<>();
    };
    private static Menu menu = new Menu ();

    public static Menu getMenu() {
        return menu;
    }

    public void addDrink (String name, List<String>ingredients){
        this.drinks.add(new Drink(name,ingredients));
    }

    public void addDrink (String name) {
        this.drinks.add(new Drink(name,name));
    }

    public void addDrink (String name, String ingredient){
        this.drinks.add(new Drink(name,ingredient));
    }

    @Override
    public String toString () {
        return    "Restaurant name: " + restaurantName
                + "\nType: " + type
                + "\nDrinks: " +drinks.toString();
                //+ "\nFirsts: " + seconds.toString()
                //+ "\nSeconds: " + seconds.toString()
                //+ "\nSweets: " + sweets.toString();
    }
}
