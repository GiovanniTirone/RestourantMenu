package it.restaurantMenu.menu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Dish{
    public String name;
    public List<Ingredients> ingredients;

    public double price;


    public void Dish(String name, Ingredients ingredient, double price) {
        this.name = name;
        this.price = price;
        this.ingredients = new ArrayList<>(Arrays.asList(ingredient));
    }

    public void Dish(String name, List<Ingredients> ingredients, double price) {
        this.name = name;
        this.price = price;
        this.ingredients = ingredients;
    }

/*
    public void setName(String name){this.name = name;}

    public void setPrice(double price){this.price = price;}

    public void setIngredients(List<String> ingredients) {this.ingredients = ingredients;}

    public void setDish(String name, double price, List<String> ingredients) {
        this.name = name;
        this.price = price;
        this.ingredients = ingredients;
    }

    public String getName() {return name;}

    public List<String> getIngredients() {return ingredients;}

    public double getPrice() {return price;}*/



    public String print () {
            return name + "     " + "Price: " + price + " $" + "\n  Ingredients: " + ingredients.toString();}

}