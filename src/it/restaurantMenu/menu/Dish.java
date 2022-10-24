package it.restaurantMenu.menu;


import java.util.List;


public class Dish extends Food{

    public Dish (TypeFood typeFood, String name, DishIngredients dishIngredients, double price) {
        super(typeFood, name, dishIngredients, price);
    }

    public Dish (TypeFood typeFood, String name, List<DishIngredients> ingredients, double price) {
        super(typeFood, name, ingredients, price);
    }

}
