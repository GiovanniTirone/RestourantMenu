import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class First extends Dish{

    public First (String name, String ingredient) {
        this.name = name;
        this.ingredients = new ArrayList<>(Arrays.asList(ingredient));
    }
    public First (String name, List<String> ingredients) {
        this.name = name;
        this.ingredients = new ArrayList<>(ingredients);
    }
}