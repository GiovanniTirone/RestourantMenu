
import java.util.List;

abstract class Dish {
    public String name;
    public List<String> ingredients;

    @Override
    abstract public String toString ();
}
