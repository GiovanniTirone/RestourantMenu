import com.sun.tools.jconsole.JConsoleContext;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //create the menu:
        Menu menu = Menu.getMenu();

        //create the drinks:
        Drink water = new Drink("Acqua");
        Drink wine = new Drink ("Vino","Uva della Valtellina");
        Drink beer = new Drink ("Birra",new ArrayList<>(Arrays.asList("Acqua","Malto d'Orzo","Luppolo","Lievito")));
        Drink coffee = new Drink("Caffe'",new ArrayList<>(Arrays.asList("Acqua","Caffè")));
        Drink the = new Drink("The",new ArrayList<>(Arrays.asList("Acqua","The")));
        Drink orangeJuice = new Drink("Aranciata",new ArrayList<>(Arrays.asList("Arance","Acqua","Zucchero")));

        //create the menu drinks List and add the drinks to it:
        menu.drinks = new DishList<>();
        menu.drinks.add(water);
        menu.drinks.add(wine);
        menu.drinks.add(beer);
        menu.drinks.add(coffee);
        menu.drinks.add(the);
        menu.drinks.add(orangeJuice);

        //print the men
        System.out.println(menu.toString());

    }
}