import java.util.ArrayList;
import java.util.List;

public class Menu {
    public String restaurantName = "Ristorante Team-1" ;
    public String type = "Vegano";
    public DishList <Drink> drinks;
    public DishList <First> firsts;

    //public DishList <Second> seconds;

    public DishList<Sweet> sweets;

    private Menu  () {
        this.drinks = new DishList<>();
        this.firsts = new DishList<>();
        this.sweets = new DishList<>();
    };
    private static Menu menu = new Menu ();

    public static Menu getMenu() {
        return menu;
    }

    public void addDrink (String name){
        this.drinks.add(new Drink(name));
    }

    public void addDrink (String name,String ingredient){
        this.drinks.add(new Drink(name,ingredient));
    }

    public void addDrink (String name,List<String>ingredients){
        this.drinks.add(new Drink(name,ingredients));
    }


    public void addFirst (String name,String ingredient){this.firsts.add(new First(name,ingredient));}

    public void addFirst (String name,List<String>ingredients){this.firsts.add(new First(name,ingredients));}

    public void addSweet (String name){
        this.sweets.add(new Sweet(name));
    }

    public void addSweet (String name, String ingredient){
        this.sweets.add(new Sweet(name, ingredient));
    }

    public void addSweet (String name, List<String>ingredients){
        this.sweets.add(new Sweet(name, ingredients));
    }

    @Override
    public String toString () {
        return    "Restaurant name: " + restaurantName
                + "\nType: " + type
                + "\nDrinks: " +drinks.toString()
                + "\nFirsts: " + firsts.toString()
                //+ "\nSeconds: " + seconds.toString()
                + "\nSweets: " + sweets.toString();
    }
}
