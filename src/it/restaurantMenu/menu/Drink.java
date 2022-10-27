package it.restaurantMenu.menu;

import it.restaurantWarehouse.warehouse.Ingredient;

import java.io.Serializable;
import java.util.List;

public class Drink extends Food implements Serializable {


    public Drink (String name, double price) {

        super(TypeFood.DRINK, name, price);
    }


    public Drink (String name, Ingredient ingredient, double price) {

        super(TypeFood.DRINK, name, ingredient, price);
    }


    public Drink (String name, List<Ingredient> ingredient, double price) {
        super(TypeFood.DRINK, name, ingredient, price);
    }
}
