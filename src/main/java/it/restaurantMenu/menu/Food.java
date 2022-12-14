package it.restaurantMenu.menu;

import it.restaurantWarehouse.warehouse.Ingredient;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Food implements Serializable {
    public TypeFood type;
    public String name;

    public List<Ingredient> ingredientList; //to map


    public double price;

    public Food(TypeFood typeFood, String name, double price){
        this.type = typeFood;
        this.name = name;
        this.price = price;
    }

    public Food(TypeFood typeFood, String name, Ingredient ingredient, double price) {
        this.type = typeFood;
        this.name = name;
        this.price = price;
        this.ingredientList = new ArrayList<>(Arrays.asList(ingredient));
    }


    public Food(TypeFood typeFood, String name, List<Ingredient> ingredient, double price) {
        this.type = typeFood;
        this.name = name;
        this.price = price;
        this.ingredientList = ingredient;
    }


    public void setName(String name){this.name = name;}

    public void setPrice(double price){this.price = price;}

    public void setIngredients(List<Ingredient> ingredient) {this.ingredientList = ingredient;}

    public String getName() {return name;}

    public List<Ingredient> getIngredients() {return ingredientList;}


    public double getPrice() {return price;}


    public String print() {
        String ingredientsPrint = "";
        for(Ingredient ingredient : ingredientList){
            ingredientsPrint +=ingredient.getName().toLowerCase() + "  ";
        }

        return String.format("%-50s%-5s €\n\tIngredients: %-5s\n", name, String.format("%.2f", price), ingredientsPrint);
    }

}