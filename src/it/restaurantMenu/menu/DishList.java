package it.restaurantMenu.menu;

import java.util.ArrayList;

public class DishList <T extends Food> extends ArrayList <Food> {
    double pricesAverage;

    public DishList () {
        super();
        this.pricesAverage = 0;
    }

    public void setPricesAverage () {
        this.forEach(dish -> pricesAverage += dish.price);
        pricesAverage /= this.size();
    }

    public Food getFoodByName (String name) {
        for(Food food : this){
            if(food.getName().equals(name)) return food;
        }
        return null;
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



    public String print () {
        String str = "";
        for(Food dish : this) {
            str += "\n" + dish.print();
        };
        return str;
    }
}
