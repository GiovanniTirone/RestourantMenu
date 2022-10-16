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

        //create the sweets:
        menu.addSweet("Tiramisu' vegano", new ArrayList<>(Arrays.asList("Biscotti vegani", "Caffe'", "Cacao amaro", "Yogurt soia","Panna di soia")));
        menu.addSweet("Ciambellone vegano", new ArrayList<>(Arrays.asList("Latte vegetale", "olio di semi girasole","Farina 0", "Lievito", "Cacao amaro", "Zucchero")));
        menu.addSweet("Semifreddo vegano", new ArrayList<>(Arrays.asList("Panna di soia", "Zucchero", "Biscotti vegani", "Frutti di bosco", "Cioccolato Fondente", "Olio di cocco")));
        menu.addSweet("Torta vegana al cioccolato", new ArrayList<>(Arrays.asList("Farina 1", "Latte vegetale", "Olio di semi girasole", "Vaniglia", "Latte vegetale", "Lievito", "Ciccolato fondente")));
        menu.addSweet("Torta vegana alle carote", new ArrayList<>(Arrays.asList("Farina di mandorle", "Latte vegetale", "Zucchero", "Carote", "Olio di semi girasole", "Vaniglia")));

        //print the menu
        System.out.println(menu.toString());

    }
}