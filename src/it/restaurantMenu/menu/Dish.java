package it.restaurantMenu.menu;


import it.restaurantWarehouse.warehouse.Ingredient;

import java.io.Serializable;
import java.util.List;


public class Dish extends Food implements Serializable {


   /*
    public Dish(TypeFood typeFood, String name, double price){
        super(typeFood, name, price);
    }

    public Dish (TypeFood typeFood, String name, Ingredient ingredients, double price) {
        super(typeFood, name, ingredient, price);
    }*/


    public Dish (TypeFood typeFood, String name, Ingredient ingredient, double price) {
        super(typeFood, name, ingredient, price);
    }

    public Dish (TypeFood typeFood, String name, List<Ingredient> ingredient, double price) {

        super(typeFood, name, (Ingredient) ingredient, price);
    }

}
