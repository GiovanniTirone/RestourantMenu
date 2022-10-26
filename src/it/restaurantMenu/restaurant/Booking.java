package it.restaurantMenu.restaurant;

import java.time.LocalDate;
import java.time.LocalTime;

public class Booking {

    private String name;
    private int numberOfPeople;
    private int tableNumber;
    private LocalDate date;
    private LocalTime time;

    public Booking (String name, int numberOfPeople, int tableNumber, LocalDate date, LocalTime time){
        this.name = name;
        this.numberOfPeople = numberOfPeople;
        this.tableNumber = tableNumber;
        this.date = date;
        this.time = time;

    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }
}
