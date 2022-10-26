package it.restaurantWarehouse.warehouse;

import java.util.ArrayList;
import java.util.List;

public class Warehouse {

    public List<Ingredients> ingredientsList;

    public Warehouse(){
        this.ingredientsList = new ArrayList<>();
    }

    public void warehouseOverview() {
        for (Ingredients ingredient : ingredientsList) {
            System.out.println(ingredient.getName() + " " + ingredient.getQuantity());
        } //se la lista è vuota..
    }

    public void addToWarehouse(String name, int quantity){
        Ingredients ingredients = new Ingredients(name);
        ingredients.setQuantity(quantity);
        ingredientsList.add(ingredients);
    }

    public void removeFromWarehouse(String name){
        for (Ingredients ingredient: ingredientsList) {
            if (name.equals(ingredient.getName())) {
                ingredientsList.remove(ingredient);
                System.out.println(ingredient.getName() + " has been removed from the warehouse.");}
            else {
                System.out.println("Ingredient not in the list");}
        }
    }

    public void addQuantity(String name, int add){
        for (Ingredients ingredient: ingredientsList) {
            if (ingredient.getName().equals(name)) {
                ingredient.setQuantity(ingredient.getQuantity() + add);
                System.out.println(ingredient.getName() + " has been added. \nYou have now " + ingredient.getQuantity() + " in stock");}
            else {
                System.out.println("Ingredient not in the list");}
        }
    }

    public void removeQuantity(String name, int remove){
        for (Ingredients ingredient: ingredientsList) {
            if (ingredient.getName().equals(name)){
                ingredient.setQuantity(ingredient.getQuantity() - remove);
                System.out.println(ingredient.getName() + " has been removed. \nYou have now " + ingredient.getQuantity() + " in stock");}
            else {
                System.out.println("Ingredient not in the list");
            }
        }
    }
}
