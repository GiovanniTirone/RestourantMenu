package it.restaurantMenu.restaurant;

public class Table {

    protected int number;
    protected int seating;

    //(prenotato e non prenotato)

    public Table(int number, int seating){
        this.number = number;
        this.seating = seating;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getSeating() {
        return seating;
    }

    public void setSeating(int seating) {
        this.seating = seating;
    }
}
