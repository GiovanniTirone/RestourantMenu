import java.util.ArrayList;
import java.util.Comparator;

public class LunchOrDinnerBookings extends ArrayList <Prenotation> {
    public void sortBookings () {
        this.sort(new Comparator<Prenotation>() {
            @Override
            public int compare(Prenotation p1, Prenotation p2) {
                return p1.time.compareTo(p2.time);
            }
        });
    }
}
