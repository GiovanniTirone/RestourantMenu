package it.calendar;

import java.time.LocalDate;
import java.time.LocalTime;

public class Booking {
    protected String name;
    protected int peopleNumber;
    protected int tableNumber;
    protected LocalDate date;
    protected LocalTime time;

    public Booking (String name, int peopleNumber, int tableNumber, LocalDate date, LocalTime time){
        this.name = name;
        this.peopleNumber = peopleNumber;
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

    public int getPeopleNumber() {
        return peopleNumber;
    }

    public void setPeopleNumber(int peopleNumber) {
        this.peopleNumber = peopleNumber;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    //JTABLE


}
