package it.restaurantMenu.order.interfaces;

import java.io.IOException;

public interface IOrderFilePDF {

    void createPDF(IOrder order) throws IOException;

}
