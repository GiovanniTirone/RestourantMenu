package it.restaurantMenu.menu;

import java.util.ArrayList;
import java.util.List;

public class Magazzino {

    public static List<Ingredients> ingredientsList = new ArrayList<>();

    public static void addQuantity(Ingredients ingredients, int add){
        ingredients.setQuantity(ingredients.getQuantity() + add);
        System.out.println(ingredients.getName() + " has been added. \nYou have now " + ingredients.getQuantity() + " in stock");
    }

    public static void removeQuantity(Ingredients ingredients, int remove){
        ingredients.setQuantity(ingredients.getQuantity() - remove);
        System.out.println(ingredients.getName() + " has been removed. \nYou have now " + ingredients.getQuantity() + " in stock");
    }

    public static void viewMagazzino() {
        for (Ingredients ingredient : ingredientsList) {
            System.out.println(ingredient.getName() + " " + ingredient.getQuantity());
        }
    }

    public static void main(String[] args) {
        Ingredients acqua = new Ingredients("acqua");
        Ingredients caffe = new Ingredients("caffé");
        acqua.setQuantity(10);
        caffe.setQuantity(10);
        addQuantity(acqua, 5);
        addQuantity(caffe, 8);
        removeQuantity(acqua, 3);
        removeQuantity(acqua, 7);

        ingredientsList.add(acqua);
        ingredientsList.add(caffe);
        viewMagazzino();

    }
}
