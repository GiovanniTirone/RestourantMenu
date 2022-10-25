package it.restaurantMenu.menu;

import it.restaurantWarehouse.warehouse.Ingredients;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Food {
    public TypeFood type;
    public String name;
    public List<Ingredients> ingredients; //to map

    public double price;


    public Food(TypeFood typeFood, String name, Ingredients ingredient, double price) {
        this.type = typeFood;
        this.name = name;
        this.price = price;
        this.ingredients = new ArrayList<>(Arrays.asList(ingredient));
    }

    public Food(TypeFood typeFood, String name, List<Ingredients> ingredients, double price) {
        this.type = typeFood;
        this.name = name;
        this.price = price;
        this.ingredients = ingredients;
    }


    public void setName(String name){this.name = name;}

    public void setPrice(double price){this.price = price;}

    public void setIngredients(List<Ingredients> ingredients) {this.ingredients = ingredients;}

    public String getName() {return name;}

    public List<Ingredients> getIngredients() {return ingredients;}

    public double getPrice() {return price;}


    public String print () {
            return name + "     " + "Price: " + price + " $" + "\n  Ingredients: " + ingredients.toString();}

}