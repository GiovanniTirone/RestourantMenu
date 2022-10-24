package it.restaurantMenu.menu;


import java.lang.reflect.Type;
import java.util.List;

public class Menu {
    public String restaurantName = "Ristorante Team-1" ;
    public String type = "Vegano";

    public DishList <Drink> starters;
    public DishList <Drink> drinks;
    public DishList <Dish> firsts;
    public DishList <Dish> seconds;
    public DishList <Dish> sideDishes;
    public DishList<Dish> desserts;
    public DishList<Dish> fruits;


    private Menu () {
        this.starters = new DishList<>();
        this.drinks = new DishList<>();
        this.firsts = new DishList<>();
        this.seconds = new DishList<>();
        this.sideDishes = new DishList<>();
        this.desserts = new DishList<>();
        this.fruits = new DishList<>();

    };
    private static Menu menu = new Menu ();

    public static Menu getIstanceMenu() {
        return menu;
    }


    public void addDrink (String name,Ingredients ingredient, double price){this.drinks.add(new Drink(name, ingredient, price));}
    public void addDrink (String name,List<Ingredients>ingredients, double price){this.drinks.add(new Drink(name,ingredients, price));}


    private DishList <? extends Food> getDishListByTypeFood(TypeFood food){

        switch(food) {
            case STARTER:
                return this.starters;
            case FIRST:
                return this.firsts;
            case SECOND:
                return this.seconds;
            case SIDE_DISH:
                return this.sideDishes;
            case DESSERT:
                return this.desserts;
            case FRUIT:
                return this.fruits;
        }
        return null;
    }


    public void addFood (TypeFood typeFood, String name,Ingredients ingredient, double price){
        getDishListByTypeFood(typeFood).add(new Food(typeFood, name,ingredient,price));
    }

    public void addFood (TypeFood typeFood, String name,List<Ingredients>ingredients, double price){
        getDishListByTypeFood(typeFood).add(new Food(typeFood, name,ingredients,price));
    }


    public String print () {
        return    "Restaurant name: " + restaurantName
                + "\nType: " + type
                + "\n--------------------------------------"
                + "\nDrinks: " +drinks.print()
                + "\n--------------------------------------"
                + "\nStarters: " +starters.print()
                + "\n--------------------------------------"
                + "\nFirsts: " + firsts.print()
                + "\n--------------------------------------"
                + "\nSeconds: " + seconds.print()
                + "\n--------------------------------------"
                + "\nSide dishes: " + sideDishes.print()
                + "\n--------------------------------------"
                + "\nDesserts: " + desserts.print()
                + "\n--------------------------------------"
                + "\nFruits: " + fruits.print();
    }
}
