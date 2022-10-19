package it.restaurantMenu.menu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class DishList <T extends Dish> extends ArrayList <Dish> {
    double pricesAverage;

    public DishList () {
        super();
        this.pricesAverage = 0;
    }

    public void setPricesAverage () {
        this.forEach(dish -> pricesAverage += dish.price);
        pricesAverage /= this.size();
    }

    /*
    public Set<Dish> getDishesWithAllergen (Allergen allergen ) {
        Set<Dish> dishes = new HashSet<>();
        for(Dish dish : this) {
            if(dish.ingredients.ALLERGENS.contains(allergen)){
                dishes.add(dish);
            }
        }
        return dishes;
    }
    */
    /*
    public Set<Drink> getAlcoholicDrinks () {
        if(!this.getClass().getName().equals("Drink")) return null;
        Set<Drink> dishes = new HashSet<>();
        for(Drink (Drink)drink : this) {

        }
    }
    */


    @Override
    public String toString () {
        String str = "";
        for(Dish dish : this) {
            str += "\n" + dish.toString();
        };
        return str;
    }
}
