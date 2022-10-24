package it.restaurantMenu.order.utilities;

import it.restaurantMenu.order.Order;
import it.restaurantMenu.order.interfaces.IOrder;

public class OrderFactory {

    private IOrder orderService;

    public OrderFactory(){ }

    public OrderFactory(Order order){
        this.orderService = order;
    }

    public IOrder getOrderService(){ return orderService; }

    public void setOrderService(Order order){
        this.orderService = order;
    }

}
