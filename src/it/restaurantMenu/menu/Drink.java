package it.restaurantMenu.menu;

import java.io.Serializable;
import java.util.List;

public class Drink extends Food implements Serializable {

    public Drink(String name, double price){
        super(TypeFood.DRINK, name, price);
    }

    public Drink (String name, Ingredient ingredients, double price) {
        super(TypeFood.DRINK, name, ingredients, price);
    }

    public Drink (String name, List<Ingredient> ingredients, double price) {
        super(TypeFood.DRINK, name, ingredients, price);
    }
}
