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
        First first1 = new First("Insalata di riso e melone", new ArrayList<>(Arrays.asList("riso", "melone")));
        First first2 = new First("Spaghetti ai carciofi e limone", new ArrayList<>(Arrays.asList("carciofi", "limone")));
        First first3 = new First("Cous cous all’arancia", new ArrayList<>(Arrays.asList("Cous cous", "arancia")));
        First first4 = new First("Vellutata di sedano rapa", "sedano rapa");
        First first5 = new First("Gazpacho di anguria e pomodoro", new ArrayList<>(Arrays.asList("anguria", "pomodoro")));

        //create the menu First List and add the first to it:
        menu.firsts = new DishList<>();
        menu.firsts.add(first1);
        menu.firsts.add(first2);
        menu.firsts.add(first3);
        menu.firsts.add(first4);
        menu.firsts.add(first5);

        //print the menu
        System.out.println(menu.toString());

    }
}