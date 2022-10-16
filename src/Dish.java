
import java.util.List;

public class Dish{
    public String name;
    public List<String> ingredients;

    public double price;

    @Override
    public String toString () {
            return this.name.toUpperCase() + "     " + "Price: " + price + "$" + "\n  Ingredients: " + this.ingredients.toString();}
}
