import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Drink extends Dish {

    public Drink (String name, double price) {
        this.name = name;
        this.ingredients = new ArrayList<>(Arrays.asList(name));
        this.price = price;
    }

    public Drink (String name, String ingredient, double price) {
        this.name = name;
        this.ingredients = new ArrayList<>(Arrays.asList(ingredient));
        this.price = price;
    }

    public Drink (String name,List<String>ingredients, double price) {
        this.name = name;
        this.ingredients = new ArrayList<>(ingredients);
        this.price = price;
    }

}
