package it.restaurantMenu.menu;

import java.util.List;

public class Drink extends Food {

    public Drink (String name, DishIngredients dishIngredients, double price) {
        super(TypeFood.DRINK, name, dishIngredients, price);
    }

    public Drink (String name, List<DishIngredients> ingredients, double price) {
        super(TypeFood.DRINK, name, ingredients, price);
    }
}
