## RESTOURANT MENU TEAM-1

PACKAGES: 

* .restaurantMenu
    * .menu: 
      Contiene le seguenti classi: 
      * Food: classe che descrive un generico cibo. Contiene le variabili: type, name, dishIngredients, price.
      * Drink: sottoclasse di Food
      * Dish: sottoclasse di Food
      * DishList: classe che estende ArrayList, può contenere classi che sono estensioni di Food
      * Ingredients: enum che contiene tutti gli ingredienti
      * TypeFoos: enum che specifica il tipo di cibo (DRINK, FIRST, SECOND, ....)
      * Menu: contiene una stringa name e una type, e una Dishlist per i drinks e altre Dishlists per i vari tipi di Dish
      
    * .timeTable
      Contiene le seguenti classi:
      * TimeTable: contiene quattro LocalTime che indicano gli orari di apertura e chiusura a pranzo e a cena
      * DayOfWeek: enum che contiene i nomi dei giorni (SUNDAY, MONDAY,...), ad ognuno sono assegnate le variabili: 
                   String name, boolean workingDay, boolean weekendDay
      * Day: contiene le seguenti variabili: DayofWeek dayOfWeek, TimeTable timeTable, Menu menu. Quindi è possibile impostare
             orari di apertura e menu differenti a senconda del giorno.
      * Week: continene un array Day days [7] con i giorni della settimana e due TimeTable che corrispondono agli orari standard
              durante la settimana e durante il weekend
      