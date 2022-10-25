package it.restaurantMenu.menu.utilities;

import it.restaurantMenu.menu.Menu;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class MenuFileTxt {

    public void writeOnFile(Menu menu, String filePath) {
        try {
            FileWriter output = new FileWriter(filePath, false);
            PrintWriter pw = new PrintWriter(output);

            pw.write(menu.printMenuDetails());

            output.close();
        }
        catch (Exception e) {
            e.getStackTrace();
        }
    }

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
