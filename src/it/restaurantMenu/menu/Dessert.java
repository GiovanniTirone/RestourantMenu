package it.restaurantMenu.menu;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Dessert extends Dish{


    public Dessert(String name, String ingredient, double price) {
        this.name = name;
        this.price = price;
        this.ingredients = new ArrayList<>(Arrays.asList(ingredient));
    }

    public Dessert(String name, List<String> ingredients, double price) {
        this.name = name;
        this.price = price;
        this.ingredients = new ArrayList<>(ingredients);
    }

}
