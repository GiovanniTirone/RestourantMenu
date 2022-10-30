package it.calendar;

public enum TypeMeals {

    BREAKFAST,
    LUNCH,
    APERITIF,
    DINNER
    ;

    protected String name;

    TypeMeals() {
        this.name = this.name().charAt(0) + this.name().substring(1).toLowerCase();
    }

    public String getName() {return name;}

}
