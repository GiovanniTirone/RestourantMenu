package it.restaurantMenu.menu;


import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.List;

public class Menu implements Serializable {
    public String restaurantName = "Ristorante Team-1" ;
    public String type = "Vegano";

    public DishList <Dish> starters;
    public DishList <Drink> drinks;
    public DishList <Dish> firsts;
    public DishList <Dish> seconds;
    public DishList <Dish> sideDishes;
    public DishList<Dish> desserts;
    public DishList<Dish> fruits;





    public Menu  () {
        this.starters = new DishList<>();
        this.drinks = new DishList<>();
        this.firsts = new DishList<>();
        this.seconds = new DishList<>();
        this.sideDishes = new DishList<>();
        this.desserts = new DishList<>();
        this.fruits = new DishList<>();

    };



    public void addDrink (String name,Ingredients ingredient, double price){this.drinks.add(new Drink(name, ingredient, price));}
    public void addDrink (String name,List<Ingredients>ingredients, double price){this.drinks.add(new Drink(name,ingredients, price));}

    public void addFood (TypeFood typeFood, String name,Ingredients ingredient, double price){
            getDishListByTypeFood(typeFood).add(new Food(typeFood, name,ingredient,price));
    }
    public void addFood (TypeFood typeFood, String name,List<Ingredients>ingredients, double price){
            getDishListByTypeFood(typeFood).add(new Food(typeFood, name,ingredients,price));
    }

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


    public String printMenuDetails() {
        return  String.format("%34s\n\n", restaurantName)
                + String.format("%24s %s", "MENU", type.toUpperCase())
                + "\n\n---------------------------------------------------------"
                + "\n\nDRINKS:\n" + drinks.print()
                + "\n---------------------------------------------------------"
                + "\n\nFIRSTS:\n" + firsts.print()
                + "\n---------------------------------------------------------"
                + "\n\nSECONDS:\n" + seconds.print()
                + "\n---------------------------------------------------------"
                + "\n\nDESSERTS:\n" + desserts.print()
                + "\n---------------------------------------------------------";
    }
}
