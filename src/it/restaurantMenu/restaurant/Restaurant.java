package it.restaurantMenu.restaurant;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {

    private String name;

    List<Table> tables;

    public Restaurant(String name){
        this.name = name;
        this.tables = new ArrayList<>();
    }

    public void addTable (int number, int seating){
        this.tables.add(new Table(number, seating));
    }


}
