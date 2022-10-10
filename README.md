## RESTOURANT MENU TEAM-1

Classi : 
* Main: classe che contiene il metodo main
* Dish: classe astratta che serve per implemnetare i singoli piatti; 
* Drink, First, Second, Sweet : classi che corrispondo ai singoli piatti;
* DishList: classe che serve per raccogliere tutti i piatti dello stesso tipo (primi,secondi,...)
* Menu: classe singleton, dove vengono raccolte le dishList ; 

Problema: Nell'implementare il metodo toString per una DishList, quando bisogna entrare nel ciclo for la dishList 
viene riconosciuta come null anche se ho creato precedentemente la dishList drinks che contiene le bevande !!!???

   