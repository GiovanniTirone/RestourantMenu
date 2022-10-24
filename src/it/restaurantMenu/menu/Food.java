package it.restaurantMenu.menu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Food {
    public TypeFood type;
    public String name;
    public List<DishIngredients> ingredients;

    public double price;


    public Food(TypeFood typeFood, String name, DishIngredients ingredient, double price) {
        this.type = typeFood;
        this.name = name;
        this.price = price;
        this.ingredients = new ArrayList<>(Arrays.asList(ingredient));
    }

    public Food(TypeFood typeFood, String name, List<DishIngredients> ingredients, double price) {
        this.type = typeFood;
        this.name = name;
        this.price = price;
        this.ingredients = ingredients;
    }


    public void setName(String name){this.name = name;}

    public void setPrice(double price){this.price = price;}

    public void setIngredients(List<DishIngredients> ingredients) {this.ingredients = ingredients;}

    public String getName() {return name;}

    public List<DishIngredients> getIngredients() {return ingredients;}

    public double getPrice() {return price;}


    public String print () {
            return name + "     " + "Price: " + price + " $" + "\n  Ingredients: " + ingredients.toString();}

}