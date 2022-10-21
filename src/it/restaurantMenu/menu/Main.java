package it.restaurantMenu.menu;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        //create the menu:
        Menu menu = Menu.getIstanceMenu();

        //create the drinks:
        menu.addDrink("Acqua", Ingredients.MELONE , 2);
        menu.addDrink("Vino", Ingredients.UVA, 15);
        menu.addDrink("Birra", new ArrayList<>(Arrays.asList(Ingredients.ACQUA, Ingredients.LIEVITO)), 6);
        menu.addDrink("Caffe", new ArrayList<>(Arrays.asList(Ingredients.ACQUA, Ingredients.CAFFE)), 3);
        menu.addDrink("The", new ArrayList<>(Arrays.asList(Ingredients.ACQUA, Ingredients.THE)), 3);
        menu.addDrink("Aranciata",new ArrayList<>(Arrays.asList(Ingredients.ARANCIA,Ingredients.ACQUA,Ingredients.ZUCCHERO)), 3);

        //create the it.retaurantMenu.menu.First:
        menu.addFirst("Insalata di riso e melone", new ArrayList<>(Arrays.asList(Ingredients.RISO,Ingredients.MELONE)), 11);
        menu.addFirst("Spaghetti ai carciofi e limone", new ArrayList<>(Arrays.asList(Ingredients.CARCIOFI, Ingredients.LIMONE)), 14);
        menu.addFirst("Cous cous all’arancia", new ArrayList<>(Arrays.asList(Ingredients.COUS_COUS, Ingredients.ARANCIA)), 15);
        menu.addFirst("Vellutata di sedano rapa", Ingredients.SEDANO_RAPA, 12);
        menu.addFirst("Gazpacho di anguria e pomodoro", new ArrayList<>(Arrays.asList(Ingredients.ANGURIA, Ingredients.POMODORO)), 12);


        //create the Seconds;
        menu.addSeconds("Polpettone di fagioli e tofu alle erbe",
                new ArrayList<>(Arrays.asList(Ingredients.TOFU, Ingredients.FAGIOLI, Ingredients.ERBE)), 13);
        menu.addSeconds("Zucchine ripiene con crema di fagioli bianchi",
                new ArrayList<>(Arrays.asList(Ingredients.ZUCCHINE, Ingredients.FAGIOLI)), 14);
        menu.addSeconds("Crostata salata vegana con cannellini e pomodori",
                new ArrayList<>(Arrays.asList(Ingredients.FAGIOLI_CANNELLINI, Ingredients.POMODORO)), 15);
        menu.addSeconds("Hamburger vegani di miglio, cannellini e olive",
                new ArrayList<>(Arrays.asList(Ingredients.MIGLIO, Ingredients.FAGIOLI_CANNELLINI, Ingredients.ARANCIA.OLIVE)), 13);
        menu.addSeconds("Sformato vegan di verdure estive",
                new ArrayList<>(Arrays.asList(Ingredients.ZUCCHINE, Ingredients.MELENZANE,Ingredients.PEPERONI)), 13);

        //create the sweets:
        menu.addDessert("Tiramisu' vegano", new ArrayList<>(Arrays.asList(Ingredients.BISCOTTI_VEGANI,
                Ingredients.CAFFE, Ingredients.CACAO_AMARO, Ingredients.YOGURT_DI_SOIA,Ingredients.PANNA_DI_SOIA)), 12);
        menu.addDessert("Ciambellone vegano", new ArrayList<>(Arrays.asList(Ingredients.LATTE_VEGETALE,
                Ingredients.OLIO_DI_SEMI_GIRASOLE,Ingredients.FARINA_0, Ingredients.LIEVITO, Ingredients.CACAO_AMARO, Ingredients.ZUCCHINE)), 15);
        menu.addDessert("Semifreddo vegano", new ArrayList<>(Arrays.asList(Ingredients.PANNA_DI_SOIA, Ingredients.ZUCCHERO,
                Ingredients.BISCOTTI_VEGANI, Ingredients.FRUTTI_DI_BOSCO, Ingredients.CIOCCOLATO_FONDENTE, Ingredients.ARANCIA.OLIO_DI_COCCO)), 10);
        menu.addDessert("Torta vegana al cioccolato", new ArrayList<>(Arrays.asList(Ingredients.FARINA_1,
                Ingredients.LATTE_VEGETALE, Ingredients.OLIO_DI_SEMI_GIRASOLE, Ingredients.VANIGLIA,
                Ingredients.LATTE_VEGETALE, Ingredients.LIEVITO, Ingredients.CIOCCOLATO_FONDENTE)), 12);
        menu.addDessert("Torta vegana alle carote", new ArrayList<>(Arrays.asList(Ingredients.FARINA_DI_MANDORLE,
                Ingredients.LATTE_VEGETALE, Ingredients.ZUCCHERO, Ingredients.CAROTE, Ingredients.OLIO_DI_SEMI_GIRASOLE, Ingredients.VANIGLIA)), 14);



        //print the menu
        System.out.println(menu.print());

    }
}