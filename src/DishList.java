import java.util.ArrayList;
import java.util.List;

public class DishList <T extends Dish> extends ArrayList <Dish> {

    @Override
    public String toString () {
        String str = "";
        for(Dish dish : this) {
            str += "\n  " + dish.toString();
        };
        return str;
    }
}
