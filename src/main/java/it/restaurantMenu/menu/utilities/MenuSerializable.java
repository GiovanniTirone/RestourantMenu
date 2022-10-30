package it.restaurantMenu.menu.utilities;

import it.restaurantMenu.menu.Menu;

import java.io.*;

public class MenuSerializable {

    public void writeObject(Menu menu, String filepath) {
        try{
            FileOutputStream fileOutputStream = new FileOutputStream(filepath);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(menu);
            objectOutputStream.close();
        }
        catch(Exception e){
            e.getStackTrace();
        }

    }

    public Menu readObject(String filepath) throws IOException, ClassNotFoundException, FileNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(filepath);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Menu menu = (Menu) objectInputStream.readObject();
        objectInputStream.close();
        return menu;
    }

}
