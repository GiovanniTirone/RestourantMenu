package it.restaurantMenu.menu;


import it.restaurantWarehouse.warehouse.Ingredients;

import java.util.List;


public class Dish extends Food{

    public Dish (TypeFood typeFood, String name, Ingredients ingredients, double price) {
        super(typeFood, name, ingredients, price);
    }

    public Dish (TypeFood typeFood, String name, List<Ingredients> ingredients, double price) {
        super(typeFood, name, ingredients, price);
    }

}
