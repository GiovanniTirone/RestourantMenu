package it.restaurantMenu.menu;

import java.util.List;

public class Menu {
    public String restaurantName = "Ristorante Team-1" ;
    public String type = "Vegano";

    public DishList <Drink> drinks;
    public DishList <First> firsts;
    public DishList <Second> seconds;
    public DishList<Dessert> desserts;


    private Menu () {
        this.drinks = new DishList<>();
        this.firsts = new DishList<>();
        this.seconds = new DishList<>();
        this.desserts = new DishList<>();

    };
    private static Menu menu = new Menu ();

    public static Menu getIstanceMenu() {
        return menu;
    }


    public void addDrink (String name,Ingredients ingredient, double price){this.drinks.add(new Drink(name, ingredient, price));}
    public void addDrink (String name,List<Ingredients>ingredients, double price){this.drinks.add(new Drink(name,ingredients, price));}

    public void addFirst (String name,Ingredients ingredient, double price){this.firsts.add(new First(name,ingredient,price));}
    public void addFirst (String name,List<Ingredients>ingredients, double price){this.firsts.add(new First(name,ingredients,price));}

    public void addSeconds (String name,Ingredients ingredient, double price){this.seconds.add(new Second(name,ingredient,price));}
    public void addSeconds (String name,List<Ingredients>ingredients, double price){this.seconds.add(new Second(name,ingredients,price));}

    public void addDessert (String name, Ingredients ingredient, double price){ this.desserts.add(new Dessert(name, ingredient, price));}
    public void addDessert (String name, List<Ingredients>ingredients, double price){ this.desserts.add(new Dessert(name, ingredients, price));}


    public String print () {
        return    "Restaurant name: " + restaurantName
                + "\nType: " + type
                + "\nDrinks: " +drinks.print()
                + "\n--------------------------------------"
                + "\nFirsts: " + firsts.print()
                + "\n--------------------------------------"
                + "\nSeconds: " + seconds.print()
                + "\n--------------------------------------"
                + "\nDesserts: " + desserts.print();
    }
}
