package it.restaurantMenu.menu;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //create the menu:
        Menu menu = Menu.getIstanceMenu();

        //create the drinks:
        menu.addDrink("Acqua", "Acqua" , 2);
        menu.addDrink("Vino","Uva della Valtellina", 15);
        menu.addDrink("Birra",new ArrayList<>(Arrays.asList("Acqua","Malto d'Orzo","Luppolo","Lievito")), 6);
        menu.addDrink("Caffe'",new ArrayList<>(Arrays.asList("Acqua","Caffe")), 3);
        menu.addDrink("The'",new ArrayList<>(Arrays.asList("Acqua","The")),3);
        menu.addDrink("Aranciata",new ArrayList<>(Arrays.asList("Arance","Acqua","Zucchero")), 3);


        //create the it.retaurantMenu.menu.First:
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

        //create the sweets:
        menu.addDessert("Tiramisu' vegano", new ArrayList<>(Arrays.asList("Biscotti vegani", "Caffe'", "Cacao amaro", "Yogurt soia","Panna di soia")), 12);
        menu.addDessert("Ciambellone vegano", new ArrayList<>(Arrays.asList("Latte vegetale", "olio di semi girasole","Farina 0", "Lievito", "Cacao amaro", "Zucchero")), 15);
        menu.addDessert("Semifreddo vegano", new ArrayList<>(Arrays.asList("Panna di soia", "Zucchero", "Biscotti vegani", "Frutti di bosco", "Cioccolato Fondente", "Olio di cocco")), 10);
        menu.addDessert("Torta vegana al cioccolato", new ArrayList<>(Arrays.asList("Farina 1", "Latte vegetale", "Olio di semi girasole", "Vaniglia", "Latte vegetale", "Lievito", "Ciccolato fondente")), 12);
        menu.addDessert("Torta vegana alle carote", new ArrayList<>(Arrays.asList("Farina di mandorle", "Latte vegetale", "Zucchero", "Carote", "Olio di semi girasole", "Vaniglia")), 14);

        //print the menu
        System.out.println(menu.print());

    }
}