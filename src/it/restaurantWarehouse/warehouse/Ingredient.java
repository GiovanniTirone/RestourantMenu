package it.restaurantWarehouse.warehouse;

import it.restaurantMenu.menu.FoodList;

import java.io.Serializable;
import java.util.List;

public class Ingredient implements Serializable {


    private String name;
    private int quantity;  // pz. - kg. - lt.
    private int ingredientID;  // 0001, 0002, 0003

    public Ingredient(){
    }

    public Ingredient(String name){
        this.name = name;
    }

    public Ingredient(String name, int quantity){
        this.name = name;
        this.quantity = quantity;
    }

    public Ingredient(String name, int quantity, int ingredientID){
        this.name = name;
        this.quantity = quantity;
        this.ingredientID = ingredientID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getIngredientID() {
        return ingredientID;
    }

    public void setIngredientID(int ingredientID) {
        this.ingredientID = ingredientID;
    }




}
