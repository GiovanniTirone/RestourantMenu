import java.util.ArrayList;
import java.util.List;

public class DishList <t extends Dish> extends ArrayList {
    List <t> dishList;

    @Override
    public String toString () {
        String str = "";
        if(dishList != null) for(Dish dish : this.dishList) {
            System.out.println("Dish: " + dish);
            System.out.println("Dish name" + dish.name);
            str += "  name: " + dish.name + "\n  ingredients: " + dish.ingredients.toString();
        };
        return str;
    }
}
