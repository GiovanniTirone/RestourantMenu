package calendar;

import restaurant.Restaurant;
import java.time.*;
import java.util.ArrayList;
import java.util.List;

public class Calendar {
        public List<DayBookings> bookings = new ArrayList<>();


        public int checkFreeTable (LocalDate date, LocalTime time, int peopleNumber) {

                for(DayBookings dayBookings : bookings){
                        if(dayBookings.date != date) continue;
                        if(dayBookings.date.isEqual(date)) {
                                if (Restaurant.timeIsInLunchRange(time)) {
                                        int possibleFreeTable = dayBookings.lunchPrenotations.getFreeTableAtTime(time);
                                        if (possibleFreeTable > 0 && Restaurant.getTableSeatsByNumberTable(possibleFreeTable) > 0) {
                                                return possibleFreeTable;
                                        }
                                }
                                if (Restaurant.timeIsInDinnerRange(time)) {
                                        int possibleFreeTable = dayBookings.dinnerPrenotations.getFreeTableAtTime(time);
                                        if (possibleFreeTable > 0 && Restaurant.getTableSeatsByNumberTable(possibleFreeTable) > 0) {
                                                return possibleFreeTable;
                                        }
                                }
                                break;
                        }
                }
                return -1;
        }


        public DayBookings searchDayBookings (LocalDate date) {
                for(DayBookings dayBookings : bookings){
                        if(dayBookings.date.isEqual(date)) return dayBookings;
                }
                return null;
        }

        public boolean bookTable (LocalDate date, LocalTime time, int peopleNumber){
                int freeTable = checkFreeTable(date,time,peopleNumber);
                if(freeTable>0){
                        DayBookings dayBookings = searchDayBookings(date);
                        if(dayBookings!=null) {
                                dayBookings.addPrenotation(freeTable,time);
                                return true;
                        } else{
                                bookings.add(new DayBookings(date,time,freeTable));
                                return true;
                        }
                } else {
                        return false;
                }
        }



                /*
        public String printBookingDates() {
                for(restaurant.Table table : tables ){

                }
        }*/
}


 /* DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
                LocalDate date = LocalDate.parse(dateTime.format(formatter),formatter);
                LocalTime time = LocalTime.parse(dateTime.format(formatter),formatter);*/