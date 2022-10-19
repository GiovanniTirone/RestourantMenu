package it.restaurantMenu.menu;

import java.util.List;

public class Dish{
    public String name;
    public List<String> ingredients;

    public double price;

    public String getName () {
        return this.name;
    }

    public List<String> getIngredients () {
        return this.ingredients;
    }

    public double getPrice () {
        return this.price;
    }

    public void setName (String name) {
        this.name =name;
    }

    public void setIngredients (List<String>ingredients){
        this.ingredients = ingredients;
    }

    public void setPrice (double price){
        this.price = price;
    }

    public String print () {
            return this.name.toUpperCase() + "     " + "Price: " + price + "$" + "\n  Ingredients: " + this.ingredients.toString();}

}
