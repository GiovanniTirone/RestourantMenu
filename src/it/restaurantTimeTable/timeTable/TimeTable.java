package it.restaurantTimeTable.timeTable;
import it.restaurantMenu.calendar.TypeMeals;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

public class TimeTable {

    private Map <TypeMeals, Map<OpenClosure, LocalTime>> openClosureTimesMap;

    public TimeTable (){
        this.openClosureTimesMap = new HashMap<>();
    }

    public LocalTime getMealTime (TypeMeals typeMeals, OpenClosure openClosure){
        return openClosureTimesMap.get(typeMeals).get(openClosure);
    }

    public void setMealTime (TypeMeals typeMeals, OpenClosure openClosure, LocalTime time) {
        openClosureTimesMap.put(typeMeals, Map.of(openClosure,time));
    }

    public TypeMeals getTypeMealsByTime(LocalTime time){
        for(TypeMeals typeMeals : openClosureTimesMap.keySet()){
            Map typeMealMap = openClosureTimesMap.get(typeMeals);
            if(time.isAfter((LocalTime) typeMealMap.get(OpenClosure.OPEN)) && time.isBefore((LocalTime) typeMealMap.get(OpenClosure.CLOSURE)))
                return typeMeals;
        }
        return null;
    }

    public String printDetails () {
        String str = "";
        for(TypeMeals typeMeals : openClosureTimesMap.keySet()){
            for(OpenClosure openClosure : openClosureTimesMap.get(typeMeals).keySet())
            str += typeMeals.getName() + " " + openClosure.getName() + "  time: " + openClosureTimesMap.get(typeMeals).get(openClosure);
        }
        return str;
    }


}
