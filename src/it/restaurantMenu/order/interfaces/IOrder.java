package it.restaurantMenu.order.interfaces;

import it.restaurantMenu.menu.DishList;
import it.restaurantMenu.menu.Drink;
import it.restaurantMenu.menu.Food;
import it.restaurantMenu.menu.TypeFood;

import java.time.LocalDateTime;
import java.util.List;

public interface IOrder {

    int getIdOrder();
    double calculateTotalPrice(DishList<? extends Food> dishList);
    void printOrderDetails();
    String getOrderDetails();
    DishList<? extends Food> getDishList();
    void setTotalPrice(double totalPrice);
    void addDrink (String name, double price);
    void addFood (TypeFood typeFood, String name, double price);



}
