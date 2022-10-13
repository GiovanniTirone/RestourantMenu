import com.sun.tools.jconsole.JConsoleContext;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //create the menu:
        Menu menu = Menu.getMenu();

        //create the drinks:
        menu.addDrink("Acqua");
        menu.addDrink("Vino","Uva della Valtellina");
        menu.addDrink("Birra",new ArrayList<>(Arrays.asList("Acqua","Malto d'Orzo","Luppolo","Lievito")));
        menu.addDrink("Caffe'",new ArrayList<>(Arrays.asList("Acqua","Caffè")));
        menu.addDrink("The",new ArrayList<>(Arrays.asList("Acqua","The")));
        menu.addDrink("Aranciata",new ArrayList<>(Arrays.asList("Arance","Acqua","Zucchero")));


        //create the First:
        menu.addFirst("Insalata di riso e melone", new ArrayList<>(Arrays.asList("riso", "melone")));
        menu.addFirst("Spaghetti ai carciofi e limone", new ArrayList<>(Arrays.asList("carciofi", "limone")));
        menu.addFirst("Cous cous all’arancia", new ArrayList<>(Arrays.asList("Cous cous", "arancia")));
        menu.addFirst("Vellutata di sedano rapa", "sedano rapa");
        menu.addFirst("Gazpacho di anguria e pomodoro", new ArrayList<>(Arrays.asList("anguria", "pomodoro")));

        //print the menu
        System.out.println(menu.toString());

    }
}