package calendar;

import restaurant.Restaurant;
import restaurant.Table;

import java.time.*;
import java.util.ArrayList;
import java.util.List;

public class Calendar {
        public static List<DayBookings> bookings;

        private Calendar () {
              this.bookings =  new ArrayList<DayBookings>();
        }
        private static Calendar calendar = new Calendar();

        public static Calendar getCalendar ( ) {return calendar;}

        //Returns the number of a free table, if it doesn't exist returns a negative number
        public static int checkFreeTable (LocalDate date, LocalTime time, int peopleNumber) {

                if(bookings.size() == 0) {
                        for (Table table : Restaurant.tables){
                                if(table.seats>=peopleNumber) return table.number;
                        }
                        return -1;
                }

                for(DayBookings dayBookings : bookings){
                        if(!dayBookings.date.isEqual(date)) continue;
                        if(dayBookings.date.isEqual(date)) {
                                if (Restaurant.timeIsInLunchRange(time)) {
                                        int freeTable = dayBookings.lunchPrenotations.getFreeTableAtTime(time,peopleNumber);
                                        if (freeTable>0) {
                                                return freeTable;
                                        }
                                }
                                if (Restaurant.timeIsInDinnerRange(time)) {
                                        int possibleFreeTable = dayBookings.dinnerPrenotations.getFreeTableAtTime(time);
                                        if (possibleFreeTable > 0 && Restaurant.getTableSeatsByNumberTable(possibleFreeTable) >= peopleNumber) {
                                                return possibleFreeTable;
                                        }
                                }
                                break;
                        }
                }
                return -1;
        }


        public static DayBookings searchDayBookings (LocalDate date) {
                for(DayBookings dayBookings : bookings){
                        if(dayBookings.date.isEqual(date)) return dayBookings;
                }
                return null;
        }

        public static int bookTable (LocalDate date, LocalTime time, int peopleNumber, String name){
                if(date.isBefore(LocalDate.now())) return -1;
                int freeTable = checkFreeTable(date,time,peopleNumber);
                if(freeTable>0){
                        DayBookings dayBookings = searchDayBookings(date);
                        if(dayBookings!=null) {
                                dayBookings.addPrenotation(freeTable,time,name);
                        } else{
                                bookings.add(new DayBookings(date,time,freeTable,name));
                        }
                        return freeTable;
                } else {
                        return -1;
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