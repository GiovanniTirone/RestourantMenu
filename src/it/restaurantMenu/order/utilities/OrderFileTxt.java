package it.restaurantMenu.order.utilities;

import it.restaurantMenu.order.interfaces.IOrder;
import it.restaurantMenu.order.interfaces.IOrderFileTxt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class OrderFileTxt implements IOrderFileTxt {

    @Override
    public void writeOnFile(IOrder order, String filePath) {
        try {
            FileWriter output = new FileWriter(filePath, false);
            PrintWriter pw = new PrintWriter(output);

            pw.write(order.getOrderDetails());

            output.close();
        }
        catch (Exception e) {
            e.getStackTrace();
        }
    }

    @Override
    public void readFromFile(String filePath) {
        try {
            FileReader reader = new FileReader(filePath);
            BufferedReader br = new BufferedReader(reader);

            while(br.ready())
                System.out.println(br.readLine());

        }
        catch (Exception e) {
            e.getStackTrace();
        }
    }

}
