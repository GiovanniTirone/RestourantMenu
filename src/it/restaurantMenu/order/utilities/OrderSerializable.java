package it.restaurantMenu.order.utilities;

import it.restaurantMenu.order.Order;
import it.restaurantMenu.order.interfaces.IOrder;
import it.restaurantMenu.order.interfaces.IOrderSerializable;

import java.io.*;

public class OrderSerializable implements IOrderSerializable {

    @Override
    public void writeObject(IOrder order, String filepath) {
        try{
            FileOutputStream fileOutputStream = new FileOutputStream(filepath);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(order);
            objectOutputStream.close();
        }
        catch(Exception e){
            e.getStackTrace();
        }

    }

    @Override
    public IOrder readObject(String filepath) throws IOException, ClassNotFoundException, FileNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(filepath);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        IOrder order = (Order) objectInputStream.readObject();
        objectInputStream.close();
        return order;
    }

}
