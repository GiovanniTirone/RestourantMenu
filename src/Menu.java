import java.util.List;

public class Menu {
    public String restaurantName = "Ristorante Team-1" ;
    public String type = "Vegano";
    public DishList <Drink> drinks;
   /* public DishList <First> firsts;
    public DishList <Second> seconds;
    public DishList sweets;*/

    private Menu  () {};
    private static Menu menu = new Menu ();

    public static Menu getMenu() {
        return menu;
    }


    @Override
    public String toString () {
        return    "Restaurant name: " + restaurantName
                + "\nType: " + type
                + "\nDrinks: " + "\n " +drinks.toString();
                //+ "\nFirsts: " + seconds.toString()
                //+ "\nSeconds: " + seconds.toString()
                //+ "\nSweets: " + sweets.toString();
    }
}
