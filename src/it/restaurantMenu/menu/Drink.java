package it.restaurantMenu.menu;

import it.restaurantWarehouse.warehouse.Ingredients;

import java.util.List;

public class Drink extends Food {

    public Drink (String name, Ingredients ingredients, double price) {
        super(TypeFood.DRINK, name, ingredients, price);
    }

    public Drink (String name, List<Ingredients> ingredients, double price) {
        super(TypeFood.DRINK, name, ingredients, price);
    }
}
