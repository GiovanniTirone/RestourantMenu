package it.restaurantMenu.order.interfaces;

public interface IOrderFileTxt {

    void writeOnFile(IOrder order, String filePath);
    void readFromFile(String filePath);

}
