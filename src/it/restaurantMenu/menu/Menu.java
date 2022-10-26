package it.restaurantMenu.menu;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Menu implements Serializable {
    public String restaurantName = "Ristorante Team-1" ;
    public String type = "Vegano";

    public FoodList<Dish> starters;
    public FoodList<Drink> drinks;
    public FoodList<Dish> firsts;
    public FoodList<Dish> seconds;
    public FoodList<Dish> sideDishes;
    public FoodList<Dish> desserts;
    public FoodList<Dish> fruits;


    public Menu  () {
        this.starters = new FoodList<>();
        this.drinks = new FoodList<>();
        this.firsts = new FoodList<>();
        this.seconds = new FoodList<>();
        this.sideDishes = new FoodList<>();
        this.desserts = new FoodList<>();
        this.fruits = new FoodList<>();

    };


    public void addDrink (String name, Ingredient ingredient, double price){this.drinks.add(new Drink(name, new Ingredient(), price));}
    public void addDrink (String name, List<Ingredient>ingredients, double price){this.drinks.add(new Drink(name, new Ingredient(), price));}

    public void addFood (TypeFood typeFood, String name, Ingredient ingredient, double price){
            getFoodListByTypeFood(typeFood).add(new Food(typeFood, name,ingredient,price));
    }
    public void addFood (TypeFood typeFood, String name, List<Ingredient>ingredients, double price){
            getFoodListByTypeFood(typeFood).add(new Food(typeFood, name,ingredients,price));
    }


    private FoodList<? extends Food> getFoodListByTypeFood(TypeFood food){

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

    public Food getFoodByNameAndType (String name, TypeFood typeFood) {
        return getFoodListByTypeFood(typeFood).getFoodByName(name);
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
