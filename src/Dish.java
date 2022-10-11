
import java.util.List;

public class Dish {
    public String name;
    public List<String> ingredients;

    @Override
    public String toString () {
            return    this.name + " -- Ingredients: " + this.ingredients.toString();
    }
}
