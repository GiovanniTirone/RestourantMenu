package it.restaurantMenu.order.interfaces;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface IOrderSerializable {

    void writeObject(IOrder order, String filepath);
    IOrder readObject(String filepath) throws IOException, ClassNotFoundException, FileNotFoundException;

}
