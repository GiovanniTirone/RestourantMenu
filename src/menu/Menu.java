package menu;

public class Menu {
    public String restaurantName = "Ristorante Team-1" ;
    public String type = "Vegano";
    public DishList<Drink> drinks;
   /* public menu.DishList <menu.First> firsts;
    public menu.DishList <menu.Second> seconds;
    public menu.DishList sweets;*/

    private Menu  () {};
    private static Menu menu = new Menu ();

    public static Menu getMenu() {
        return menu;
    }


    @Override
    public String toString () {
        return    "restaurant.Restaurant name: " + restaurantName
                + "\nType: " + type
                + "\nDrinks: " +drinks.toString();
                //+ "\nFirsts: " + seconds.toString()
                //+ "\nSeconds: " + seconds.toString()
                //+ "\nSweets: " + sweets.toString();
    }
}
