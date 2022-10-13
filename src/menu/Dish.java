package menu;

import java.util.List;

abstract class Dish {
    public String name;
    public List<String> ingredients;

    @Override
    public String toString( ){
        return    this.name + " -- Ingredients: " + this.ingredients.toString();

    }
}
