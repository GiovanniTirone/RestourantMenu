package it.restaurantMenu.menu;

import java.io.Serializable;
import java.util.List;

public class Drink extends Food implements Serializable {

    public Drink (String name, Ingredients ingredients, double price) {
        super(TypeFood.DRINK, name, ingredients, price);
    }

    public Drink (String name, List<Ingredients> ingredients, double price) {
        super(TypeFood.DRINK, name, ingredients, price);
    }
}
