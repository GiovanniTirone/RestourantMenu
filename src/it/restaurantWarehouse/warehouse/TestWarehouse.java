package it.restaurantWarehouse.warehouse;

import java.util.Scanner;

public class TestWarehouse {

    public static void test(Warehouse warehouse){
        Scanner input = new Scanner(System.in);
        System.out.println("Cosa vuoi fare? <1> PANORAMICA DEL MAGAZZINO | <2> AGGIUNGI/RIMUOVI INGREDIENTE | <3> AGGIUNGI/RIMUOVI QUANTITÀ");
        String firstStep = input.nextLine();
        switch (firstStep) {
            case "1":
                warehouse.warehouseOverview();
                break;
            case "2":
                System.out.println("Cosa vuoi fare? <1> AGGIUNGI | <2> RIMUOVI");
                String secondStep1 = input.nextLine();
                switch (secondStep1) {
                    case "1":
                        System.out.println("Quale ingrediente vuoi aggiungere?");
                        String ingredientToAdd = input.nextLine();
                        System.out.println("In che quantità?");
                        int quantityToAdd = input.nextInt();
                        warehouse.addToWarehouse(ingredientToAdd, quantityToAdd);
                        break;
                    case "2":
                        System.out.println("Quale ingrediente vuoi rimuovere?");
                        String ingredientToRemove = input.nextLine();
                        warehouse.removeFromWarehouse(ingredientToRemove);
                        break;
                }
                break;
            case "3":
                System.out.println("Cosa vuoi fare? <1> AGGIUNGI | <2> RIMUOVI");
                String secondStep2 = input.nextLine();
                switch (secondStep2) {
                    case "1":
                        System.out.println("Di quale ingrediente vuoi aumentare la quantità?");
                        String ingredientToAddQuantity = input.nextLine();
                        System.out.println("In che quantità?");
                        int quantityToAdd = input.nextInt();
                        warehouse.addQuantity(ingredientToAddQuantity, quantityToAdd);
                        break;
                    case "2":
                        System.out.println("Di quale ingrediente vuoi diminuire la quanità?");
                        String ingredientsToRemoveQuantity = input.nextLine();
                        System.out.println("In che quantità?");
                        int quantityToRemove = input.nextInt();
                        warehouse.removeQuantity(ingredientsToRemoveQuantity, quantityToRemove);
                        break;
                }
                break;
        }
    }
    public static void main(String[] args) {

        Warehouse warehouse = new Warehouse();

        Scanner scanner = new Scanner(System.in);
        String exit = "N";

        while(!exit.equals("S")){
            test(warehouse);
            System.out.println("Vuoi uscire dal programma? <S> <N>");
            exit = scanner.nextLine();
        }
    }
}

