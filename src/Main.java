import com.sun.tools.jconsole.JConsoleContext;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //create the menu:
        Menu menu = Menu.getMenu();

        //create the drinks:
        menu.addDrink("Acqua", 2);
        menu.addDrink("Vino","Uva della Valtellina", 15);
        menu.addDrink("Birra",new ArrayList<>(Arrays.asList("Acqua","Malto d'Orzo","Luppolo","Lievito")), 6);
        menu.addDrink("Caffè'",new ArrayList<>(Arrays.asList("Acqua","Caffè")), 3);
        menu.addDrink("Thè",new ArrayList<>(Arrays.asList("Acqua","Thè")),3);
        menu.addDrink("Aranciata",new ArrayList<>(Arrays.asList("Arance","Acqua","Zucchero")), 3);


        //create the First:
        menu.addFirst("Insalata di riso e melone", new ArrayList<>(Arrays.asList("riso", "melone")), 11);
        menu.addFirst("Spaghetti ai carciofi e limone", new ArrayList<>(Arrays.asList("carciofi", "limone")), 14);
        menu.addFirst("Cous cous all’arancia", new ArrayList<>(Arrays.asList("Cous cous", "arancia")), 15);
        menu.addFirst("Vellutata di sedano rapa", "sedano rapa", 12);
        menu.addFirst("Gazpacho di anguria e pomodoro", new ArrayList<>(Arrays.asList("anguria", "pomodoro")), 12);

        //create the Seconds;
        menu.addSeconds("Polpettone di fagioli e tofu alle erbe", new ArrayList<>(Arrays.asList("tofu", "fagioli", "carne")), 13);
        menu.addSeconds("Zucchine ripiene con crema di fagioli bianchi", new ArrayList<>(Arrays.asList("zucchine", "fagioli")), 14);
        menu.addSeconds("Crostata salata vegana con cannellini e pomodori", new ArrayList<>(Arrays.asList("cannellini", "pomodori")), 15);
        menu.addSeconds("Hamburger vegani di miglio, cannellini e olive", new ArrayList<>(Arrays.asList("miglio", "cannellini", "olive")), 13);
        menu.addSeconds("Sformato vegan di verdure estive", new ArrayList<>(Arrays.asList("zucchine", "melenzane", "peperoni")), 13);

        //print the menu
        System.out.println(menu.toString());

    }
}