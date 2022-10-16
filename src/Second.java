import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Second extends Dish{

    public Second (String name, String ingredient, double price) {
        this.name = name;
        this.ingredients = new ArrayList<>(Arrays.asList(ingredient));
        this.price = price;
    }
    public Second (String name, List<String> ingredients, double price) {
        this.name = name;
        this.ingredients = new ArrayList<>(ingredients);
        this.price = price;
    }
}
