package it.restaurantMenu.order.interfaces;

import it.restaurantMenu.menu.FoodList;
import it.restaurantMenu.menu.Food;
import it.restaurantMenu.menu.TypeFood;

public interface IOrder {

    int getIdOrder();
    double calculateTotalPrice(FoodList<? extends Food> foodList);
    void printOrderDetails();
    String getOrderDetails();
    FoodList<? extends Food> getDishList();
    void setTotalPrice(double totalPrice);
    void addDrink (String name, double price);
    void addFood (TypeFood typeFood, String name, double price);



}
