import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Drink extends Dish {
    public String name;
    public List<String> ingredients;

    public Drink (String name) {
        this.name = name;
        this.ingredients = new ArrayList<>(Arrays.asList(name));
    }

    public Drink (String name, String ingredient) {
        this.name = name;
        this.ingredients = new ArrayList<>(Arrays.asList(ingredient));
    }

    public Drink (String name,List<String>ingredients) {
        this.name = name;
        this.ingredients = new ArrayList<>(ingredients);
    }

    @Override
    public String toString( ){
        return    " Name: " + this.name
                + "\n Ingredients: " + this.ingredients.toString();

    }
}
