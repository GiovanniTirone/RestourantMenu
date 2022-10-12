import java.util.ArrayList;
import java.time.LocalDateTime;

public class TableBookings extends ArrayList <LocalDateTime> {

    @Override
    public String toString () {
        if(this == null) return "There are no bookings for this table";
        String str = "";
        LocalDateTime currentDateTime = LocalDateTime.now();
        for(LocalDateTime dateTime : this){
            if(dateTime.isBefore(currentDateTime)) continue;
            str += "\n " + dateTime.toString();
        }
        if(str == "") return "There are no bookings for this table";
        return str;
    }

    public boolean isTableFreeAtDateTime (LocalDateTime dateTimeToCheck){
        if(this == null) return true;
        return this.stream().anyMatch(dateTime -> dateTime.isEqual(dateTimeToCheck));
    }
}
