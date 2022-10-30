package it.restaurantWarehouse.warehouse;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Warehouse {

    public static List<Ingredient> ingredientsList;


    public Warehouse(){
        this.ingredientsList = new ArrayList<>();
    }

    public void warehouseOverview() {
        for (Ingredient ingredient : ingredientsList) {
            System.out.println(ingredient.getName() + " " + ingredient.getQuantity());
        }
    }

    public void addToWarehouse(String name, int quantity){
        Ingredient ingredient = new Ingredient(name);
        ingredient.setQuantity(quantity);
        ingredientsList.add(ingredient);
    }


    public void removeFromWarehouse(String name){
        for (Ingredient ingredient: new ArrayList<>(ingredientsList)) {
            if (name.equals(ingredient.getName())) {
                ingredientsList.remove(ingredient);
                //System.out.println("'" + ingredient.getName() + "'" + " has been removed from the warehouse.");
                }
            else {
                System.out.println("Ingredient not in the list");}
        }
    }

    public void addQuantity(String name, int add){
        for (Ingredient ingredient: ingredientsList) {
            if (ingredient.getName().equals(name)) {
                ingredient.setQuantity(ingredient.getQuantity() + add);
                System.out.println(add + " units of '" + ingredient.getName() + "' has been added. You have now " + ingredient.getQuantity() + " in the warehouse");}
            else if (!Objects.equals(ingredient.getName(), name)) {
                return;}
            else {
                System.out.println("Ingredient not in warehouse");}
        }
    }

    public void removeQuantity(String name, int remove){
        for (Ingredient ingredient: ingredientsList) {
            if (ingredient.getName().equals(name)){
                ingredient.setQuantity(ingredient.getQuantity() - remove);
                System.out.println(remove + " units of '" + ingredient.getName() + "' has been removed. You have now " + ingredient.getQuantity() + " in the warehouse");}
            else if (!Objects.equals(ingredient.getName(), name)) {
            return;}
            else {
                System.out.println("Ingredient not the warehouse");
            }
        }
    }
}
