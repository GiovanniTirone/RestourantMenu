package it.restaurantMenu.order;

import it.restaurantMenu.menu.Menu;
import it.restaurantMenu.menu.TypeFood;
import it.restaurantMenu.menu.utilities.MenuSerializable;
import it.restaurantMenu.order.interfaces.IOrder;
import it.restaurantMenu.order.interfaces.IOrderFilePDF;
import it.restaurantMenu.order.interfaces.IOrderFileTxt;
import it.restaurantMenu.order.interfaces.IOrderSerializable;
import it.restaurantMenu.order.utilities.OrderFactory;
import it.restaurantMenu.order.utilities.OrderFilePDF;
import it.restaurantMenu.order.utilities.OrderFileTxt;
import it.restaurantMenu.order.utilities.OrderSerializable;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException, FileNotFoundException {

        //read and deserialize menu from file bin, get back the menu's object structure
        MenuSerializable menuSerializable = new MenuSerializable();
        Menu menu = (Menu) menuSerializable.readObject("menu-vegano.bin");
        System.out.println(menu.printMenuDetails());

        //create an OrderFactory instance to solve dependency injection between Order and IOrder instances
        OrderFactory orderFactory = new OrderFactory(new Order(LocalDateTime.now()));
        IOrder order = orderFactory.getOrderService();

        order.addDrink(menu.drinks.get(0).name, menu.drinks.get(0).price);
        order.addFood(TypeFood.FIRST, menu.firsts.get(0).name, menu.firsts.get(0).price);
        order.addFood(TypeFood.FIRST, menu.firsts.get(1).name, menu.firsts.get(1).price);
        order.addFood(TypeFood.SECOND, menu.seconds.get(0).name, menu.seconds.get(0).price);
        order.addFood(TypeFood.SECOND, menu.seconds.get(1).name, menu.seconds.get(1).price);
        order.addFood(TypeFood.DESSERT, menu.desserts.get(0).name, menu.desserts.get(0).price);
        order.setTotalPrice(order.calculateTotalPrice(order.getDishList()));

        order.printOrderDetails();

        /*
         - create an OrderFileTxt instance to save order on file txt
         - create file txt for order, save and write order on file txt
         - read order from file txt, print all lines
         */

        IOrderFileTxt orderFile = new OrderFileTxt();
        orderFile.writeOnFile(order, "order" + Order.getStringIdOrder(order.getIdOrder()) +".txt");
        orderFile.readFromFile("order" + Order.getStringIdOrder(order.getIdOrder()) +".txt");

        /*
         - create an OrderFilePDF instance to save order on file pdf
         - create file pdf for order, save and write order on file pdf
         */

        IOrderFilePDF orderFilePDF = new OrderFilePDF();
        orderFilePDF.createPDF(order);

         /*
         - create an OrderSerializable instance to serialize order on binary file as byte stream
         - create file bin for order, save and serialize order on file bin
         - deserialize order from file bin, get back the order's object structure
         */

        IOrderSerializable orderSerializable = new OrderSerializable();
        orderSerializable.writeObject(order, "order" + Order.getStringIdOrder(order.getIdOrder()) +".bin");

        System.out.println("\nDeserialization Object\n");
        //IOrder orderDes = orderSerializable.readObject("order" + Order.getStringIdOrder(order.getIdOrder()) +".bin");
        orderFactory.setOrderService((Order) orderSerializable.readObject("order" + Order.getStringIdOrder(order.getIdOrder()) +".bin"));
        //orderFactory.setOrderService((Order) orderSerializable.readObject("order" + Order.getStringIdOrder(1) +".bin"));
        IOrder orderDes = orderFactory.getOrderService();
        orderDes.printOrderDetails();

    }

}
