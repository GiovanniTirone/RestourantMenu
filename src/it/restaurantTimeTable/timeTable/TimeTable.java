package it.restaurantTimeTable.timeTable;
import it.calendar.TypeMeals;
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

    public void setMealTime (TypeMeals typeMeals, OpenClosure openClosure, int hour, int min) {
        if(openClosureTimesMap.containsKey(typeMeals)){
            if(openClosureTimesMap.get(typeMeals).containsKey(openClosure)){
                System.out.println("The previus " + typeMeals.getName() + " " + openClosure.getName() + " time has been changed.");
            }
            openClosureTimesMap.get(typeMeals).put(openClosure,LocalTime.of(hour,min));
        }
        else {
            openClosureTimesMap.put(typeMeals, new HashMap<>(Map.of(openClosure,LocalTime.of(hour,min))));
        }
    }


    public TypeMeals getTypeMealsByTime(LocalTime time) throws Exception {
        for(TypeMeals typeMeals : openClosureTimesMap.keySet()){
            Map typeMealMap = openClosureTimesMap.get(typeMeals);
            if((LocalTime)typeMealMap.get(OpenClosure.OPEN) == null || (LocalTime)typeMealMap.get(OpenClosure.CLOSURE) == null){
                continue;
                //throw new Exception("The times of " + typeMeals.getName() + " aren't set");
            }
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
