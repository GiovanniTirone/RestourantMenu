package it.restaurantMenu.calendar;

public enum TypeMeals {

    BREAKFAST,
    LUNCH,
    APERITIF,
    DINNER
    ;

    String name;

    TypeMeals() {
        this.name = this.name().charAt(0) + this.name().substring(1).toLowerCase();
    }

    public String getName() {
        return name;
    }

}
