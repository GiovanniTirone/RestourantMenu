import java.util.ArrayList;
import java.util.List;

public class Menu {
    public String restaurantName = "Ristorante Team-1" ;
    public String type = "Vegano";
    public DishList <Drink> drinks;
    public DishList <First> firsts;
    public DishList <Second> seconds;
    //public DishList sweets;

    private Menu  () {
        this.drinks = new DishList<>();
        this.firsts = new DishList<>();
        this.seconds = new DishList<>();
    };
    private static Menu menu = new Menu ();

    public static Menu getMenu() {
        return menu;
    }

    public void addDrink (String name, double price){
        this.drinks.add(new Drink(name, price));
    }

    public void addDrink (String name,String ingredient, double price){
        this.drinks.add(new Drink(name,ingredient, price));
    }

    public void addDrink (String name,List<String>ingredients, double price){
        this.drinks.add(new Drink(name,ingredients, price));
    }


    public void addFirst (String name,String ingredient, double price){this.firsts.add(new First(name,ingredient,price));}

    public void addFirst (String name,List<String>ingredients, double price){this.firsts.add(new First(name,ingredients,price));}

    public void addSeconds (String name,String ingredient, double price){this.seconds.add(new Second(name,ingredient,price));}

    public void addSeconds (String name,List<String>ingredients, double price){this.seconds.add(new Second(name,ingredients,price));}


    @Override
    public String toString () {
        return    "Restaurant name: " + restaurantName
                + "\nType: " + type
                + "\nDrinks: " +drinks.toString()
                + "\n--------------------------------------"
                + "\nFirsts: " + firsts.toString()
                + "\n--------------------------------------"
                + "\nSeconds: " + seconds.toString()
                + "\n--------------------------------------";
                //+ "\nDesserts: " + dessert.toString();
    }
}
