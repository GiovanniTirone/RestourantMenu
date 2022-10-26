package it.restaurantMenu.menu;

import it.restaurantMenu.menu.utilities.MenuFileTxt;
import it.restaurantMenu.menu.utilities.MenuSerializable;
import it.restaurantWarehouse.warehouse.Ingredient;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException, FileNotFoundException {
        //create the menu:
        Menu menu = new Menu();

<<<<<<< HEAD
        //Menu menu = new Menu();

        //create the drinks:
        menu.addDrink("Acqua", new Ingredient("Acqua") , 2);
        menu.addDrink("Vino", , 15);
        menu.addDrink("Birra", , 6);
        menu.addDrink("Caffe", new ArrayList<>(Arrays.asList(Ingredient.ACQUA, Ingredient.CAFFE)), 3);
        menu.addDrink("The", new ArrayList<>(Arrays.asList(Ingredient.ACQUA, Ingredient.THE)), 3);
        menu.addDrink("Aranciata",new ArrayList<>(Arrays.asList(Ingredient.ARANCIA, Ingredient.ACQUA, Ingredient.ZUCCHERO)), 3);

        //create the it.retaurantMenu.menu.First:
        menu.addFood(TypeFood.FIRST,"Insalata di riso e melone", new ArrayList<>(Arrays.asList(Ingredient.RISO, Ingredient.MELONE)), 11);
        menu.addFood(TypeFood.FIRST,"Spaghetti ai carciofi e limone", new ArrayList<>(Arrays.asList(Ingredient.CARCIOFI, Ingredient.LIMONE)), 14);
        menu.addFood(TypeFood.FIRST,"Cous cous all’arancia", new ArrayList<>(Arrays.asList(Ingredient.COUS_COUS, Ingredient.ARANCIA)), 15);
        menu.addFood(TypeFood.FIRST,"Vellutata di sedano rapa", Ingredient.SEDANO_RAPA, 12);
        menu.addFood(TypeFood.FIRST,"Gazpacho di anguria e pomodoro", new ArrayList<>(Arrays.asList(Ingredient.ANGURIA, Ingredient.POMODORO)), 12);
=======

        //create the drinks:
        menu.addDrink("Acqua", DishIngredients.MELONE , 2);
        menu.addDrink("Vino", DishIngredients.UVA, 15);
        menu.addDrink("Birra", new ArrayList<>(Arrays.asList(DishIngredients.ACQUA, DishIngredients.LIEVITO)), 6);
        menu.addDrink("Caffe", new ArrayList<>(Arrays.asList(DishIngredients.ACQUA, DishIngredients.CAFFE)), 3);
        menu.addDrink("The", new ArrayList<>(Arrays.asList(DishIngredients.ACQUA, DishIngredients.THE)), 3);
        menu.addDrink("Aranciata",new ArrayList<>(Arrays.asList(DishIngredients.ARANCIA, DishIngredients.ACQUA, DishIngredients.ZUCCHERO)), 3);

        //create the it.retaurantMenu.menu.First:
        menu.addFood(TypeFood.FIRST,"Insalata di riso e melone", new ArrayList<>(Arrays.asList(DishIngredients.RISO, DishIngredients.MELONE)), 11);
        menu.addFood(TypeFood.FIRST,"Spaghetti ai carciofi e limone", new ArrayList<>(Arrays.asList(DishIngredients.CARCIOFI, DishIngredients.LIMONE)), 14);
        menu.addFood(TypeFood.FIRST,"Cous cous all’arancia", new ArrayList<>(Arrays.asList(DishIngredients.COUS_COUS, DishIngredients.ARANCIA)), 15);
        menu.addFood(TypeFood.FIRST,"Vellutata di sedano rapa", DishIngredients.SEDANO_RAPA, 12);
        menu.addFood(TypeFood.FIRST,"Gazpacho di anguria e pomodoro", new ArrayList<>(Arrays.asList(DishIngredients.ANGURIA, DishIngredients.POMODORO)), 12);
>>>>>>> personal


        //create the Seconds;
        menu.addFood(TypeFood.SECOND, "Polpettone di fagioli e tofu alle erbe",
<<<<<<< HEAD
                new ArrayList<>(Arrays.asList(Ingredient.TOFU, Ingredient.FAGIOLI, Ingredient.ERBE)), 13);
        menu.addFood(TypeFood.SECOND,"Zucchine ripiene con crema di fagioli bianchi",
                new ArrayList<>(Arrays.asList(Ingredient.ZUCCHINE, Ingredient.FAGIOLI)), 14);
        menu.addFood(TypeFood.SECOND,"Crostata salata vegana con cannellini e pomodori",
                new ArrayList<>(Arrays.asList(Ingredient.FAGIOLI_CANNELLINI, Ingredient.POMODORO)), 15);
        menu.addFood(TypeFood.SECOND,"Hamburger vegani di miglio, cannellini e olive",
                new ArrayList<>(Arrays.asList(Ingredient.MIGLIO, Ingredient.FAGIOLI_CANNELLINI, Ingredient.ARANCIA.OLIVE)), 13);
        menu.addFood(TypeFood.SECOND,"Sformato vegan di verdure estive",
                new ArrayList<>(Arrays.asList(Ingredient.ZUCCHINE, Ingredient.MELENZANE, Ingredient.PEPERONI)), 13);

        //create the sweets:
        menu.addFood(TypeFood.DESSERT, "Tiramisu' vegano", new ArrayList<>(Arrays.asList(Ingredient.BISCOTTI_VEGANI,
                Ingredient.CAFFE, Ingredient.CACAO_AMARO, Ingredient.YOGURT_DI_SOIA, Ingredient.PANNA_DI_SOIA)), 12);
        menu.addFood(TypeFood.DESSERT,"Ciambellone vegano", new ArrayList<>(Arrays.asList(Ingredient.LATTE_VEGETALE,
                Ingredient.OLIO_DI_SEMI_GIRASOLE, Ingredient.FARINA_0, Ingredient.LIEVITO, Ingredient.CACAO_AMARO, Ingredient.ZUCCHINE)), 15);
        menu.addFood(TypeFood.DESSERT,"Semifreddo vegano", new ArrayList<>(Arrays.asList(Ingredient.PANNA_DI_SOIA, Ingredient.ZUCCHERO,
                Ingredient.BISCOTTI_VEGANI, Ingredient.FRUTTI_DI_BOSCO, Ingredient.CIOCCOLATO_FONDENTE, Ingredient.ARANCIA.OLIO_DI_COCCO)), 10);
        menu.addFood(TypeFood.DESSERT,"Torta vegana al cioccolato", new ArrayList<>(Arrays.asList(Ingredient.FARINA_1, Ingredient.LATTE_VEGETALE,
                Ingredient.OLIO_DI_SEMI_GIRASOLE, Ingredient.VANIGLIA, Ingredient.LIEVITO, Ingredient.CIOCCOLATO_FONDENTE)), 12);
        menu.addFood(TypeFood.DESSERT,"Torta vegana alle carote", new ArrayList<>(Arrays.asList(Ingredient.FARINA_DI_MANDORLE,
                Ingredient.LATTE_VEGETALE, Ingredient.ZUCCHERO, Ingredient.CAROTE, Ingredient.OLIO_DI_SEMI_GIRASOLE, Ingredient.VANIGLIA)), 14);
=======
                new ArrayList<>(Arrays.asList(DishIngredients.TOFU, DishIngredients.FAGIOLI, DishIngredients.ERBE)), 13);
        menu.addFood(TypeFood.SECOND,"Zucchine ripiene con crema di fagioli bianchi",
                new ArrayList<>(Arrays.asList(DishIngredients.ZUCCHINE, DishIngredients.FAGIOLI)), 14);
        menu.addFood(TypeFood.SECOND,"Crostata salata vegana con cannellini e pomodori",
                new ArrayList<>(Arrays.asList(DishIngredients.FAGIOLI_CANNELLINI, DishIngredients.POMODORO)), 15);
        menu.addFood(TypeFood.SECOND,"Hamburger vegani di miglio, cannellini e olive",
                new ArrayList<>(Arrays.asList(DishIngredients.MIGLIO, DishIngredients.FAGIOLI_CANNELLINI, DishIngredients.ARANCIA.OLIVE)), 13);
        menu.addFood(TypeFood.SECOND,"Sformato vegan di verdure estive",
                new ArrayList<>(Arrays.asList(DishIngredients.ZUCCHINE, DishIngredients.MELENZANE, DishIngredients.PEPERONI)), 13);

        //create the sweets:
        menu.addFood(TypeFood.DESSERT, "Tiramisu' vegano", new ArrayList<>(Arrays.asList(DishIngredients.BISCOTTI_VEGANI,
                DishIngredients.CAFFE, DishIngredients.CACAO_AMARO, DishIngredients.YOGURT_DI_SOIA, DishIngredients.PANNA_DI_SOIA)), 12);
        menu.addFood(TypeFood.DESSERT,"Ciambellone vegano", new ArrayList<>(Arrays.asList(DishIngredients.LATTE_VEGETALE,
                DishIngredients.OLIO_DI_SEMI_GIRASOLE, DishIngredients.FARINA_0, DishIngredients.LIEVITO, DishIngredients.CACAO_AMARO, DishIngredients.ZUCCHINE)), 15);
        menu.addFood(TypeFood.DESSERT,"Semifreddo vegano", new ArrayList<>(Arrays.asList(DishIngredients.PANNA_DI_SOIA, DishIngredients.ZUCCHERO,
                DishIngredients.BISCOTTI_VEGANI, DishIngredients.FRUTTI_DI_BOSCO, DishIngredients.CIOCCOLATO_FONDENTE, DishIngredients.ARANCIA.OLIO_DI_COCCO)), 10);
        menu.addFood(TypeFood.DESSERT,"Torta vegana al cioccolato", new ArrayList<>(Arrays.asList(DishIngredients.FARINA_1, DishIngredients.LATTE_VEGETALE,
                DishIngredients.OLIO_DI_SEMI_GIRASOLE, DishIngredients.VANIGLIA, DishIngredients.LIEVITO, DishIngredients.CIOCCOLATO_FONDENTE)), 12);
        menu.addFood(TypeFood.DESSERT,"Torta vegana alle carote", new ArrayList<>(Arrays.asList(DishIngredients.FARINA_DI_MANDORLE,
                DishIngredients.LATTE_VEGETALE, DishIngredients.ZUCCHERO, DishIngredients.CAROTE, DishIngredients.OLIO_DI_SEMI_GIRASOLE, DishIngredients.VANIGLIA)), 14);
>>>>>>> personal

        /*print the menu
        System.out.println(menu.printMenuDetails());*/

        /*
         - create a MenuFileTxt instance to save menu on file txt
         - create file txt for menu, save and write menu on file txt
         - read menu from file txt, print all lines
         */
        MenuFileTxt menuFileTxt = new MenuFileTxt();
        menuFileTxt.writeOnFile(menu, "menu-" + menu.type.toLowerCase() +".txt");
        menuFileTxt.readFromFile("menu-" + menu.type.toLowerCase() +".txt");

        /*
         - create a MenuSerializable instance to serialize menu on binary file as byte stream
         - create file bin for menu, save and serialize menu on file bin
         - deserialize menu from file bin, get back the menu's object structure
         */
        MenuSerializable menuSerializable = new MenuSerializable();
        menuSerializable.writeObject(menu, "menu-" + menu.type.toLowerCase() + ".bin");

        System.out.println("\nDeserialization Object\n");
        Menu menuDes = menuSerializable.readObject("menu-" + menu.type.toLowerCase() + ".bin");
        System.out.println(menuDes.printMenuDetails());

    }
}