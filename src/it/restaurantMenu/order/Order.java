package it.restaurantMenu.order;

import it.restaurantMenu.menu.*;
import it.restaurantMenu.order.interfaces.IOrder;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class Order implements IOrder, Serializable {

    private final int idOrder;

    private DishList<? extends Food> dishList;

    private LocalDateTime date;
    private double totalPrice;
    private static int idOrders = 0;

    private static String restaurantName = new Menu().restaurantName;

    private Order(int idOrder){
        this.idOrder = idOrder;
    }

    public Order(LocalDateTime date){
        incrementOrdersNumber();
        this.idOrder = idOrders;
        this.dishList = new DishList<>();
        this.date = date;
    }

    public Order(DishList<? extends Food> dishList, LocalDateTime date){
        incrementOrdersNumber();
        this.idOrder = idOrders;
        this.dishList = dishList;
        this.date = date;
        this.totalPrice = this.calculateTotalPrice(dishList);
    }

    @Override
    public int getIdOrder() { return idOrder; }

    public static int getIdOrders() { return idOrders; }

    public static void setIdOrders(int idOrders) {
        idOrders = idOrders;
    }

    @Override
    public DishList<? extends Food> getDishList() { return dishList; }

    public void setDishList(DishList<? extends Food> dishList) {
        this.dishList = dishList;
    }

    public LocalDateTime getDate() { return date; }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public double getTotalPrice() { return totalPrice; }

    @Override
    public void setTotalPrice(double totalPrice){
        this.totalPrice = totalPrice;
    }

    @Override
    public double calculateTotalPrice(DishList<? extends Food> dishList) {
        for(Food food : dishList){
            totalPrice += food.price;
        }
        return totalPrice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "idOrder = '" + idOrder + '\'' +
                ", dishList = " + dishList +
                ", date = " + date +
                ", totalPrice = " + totalPrice +
                '}';
    }

    @Override
    public void printOrderDetails(){
        System.out.format("%26s\n\n", restaurantName);
        System.out.println("ORDER n. " + getStringIdOrder(idOrder));
        System.out.println(date.getDayOfMonth() + " " + date.getMonth() + " " +
                date.getYear() + " " + (date.getHour() < 10 ? "0" : "") + date.getHour() + ":" + (date.getMinute() < 10 ? "0" : "") + date.getMinute());
        System.out.println("-----------------------------------");
        for(Food food : dishList)
            System.out.format("%-50s%-5s €\n", food.name, String.format("%.2f", food.price));
        System.out.println("-----------------------------------");
        System.out.format("%-50s%-5s €\n", "TOTAL", String.format("%.2f", totalPrice));
    }

    @Override
    public String getOrderDetails(){
        String text = "";
        text += String.format("%26s\n\n", restaurantName);
        text += "ORDER n. " + getStringIdOrder(idOrder) +"\n";
        text += date.getDayOfMonth() + " " + date.getMonth() + " " +
                date.getYear() + " " + (date.getHour() < 10 ? "0" : "") + date.getHour() + ":" + (date.getMinute() < 10 ? "0" : "") + date.getMinute();
        text += "\n-----------------------------------\n";
        for(Food food : dishList)
            text += String.format("%-50s%-5s €\n", food.name, String.format("%.2f", food.price));
        text += "-----------------------------------\n";
        text += String.format("%-50s%-5s €\n", "TOTAL", String.format("%.2f", totalPrice));
        return text;
    }

    public static void incrementOrdersNumber(){
        ++idOrders;
    }

    public static String getStringIdOrder(int idOrder){

        final int digits = 8;

        char[] zeros = new char[digits];
        Arrays.fill(zeros, '0');
        DecimalFormat df = new DecimalFormat(String.valueOf(zeros));

        return df.format(idOrder);
    }

    @Override
    public void addDrink (String name, double price){
        dishList.add(new Drink(name, price));
    }

    @Override
    public void addFood (TypeFood typeFood, String name, double price){
        dishList.add(new Food(typeFood, name, price));
    }

}
