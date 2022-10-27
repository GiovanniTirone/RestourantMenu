package it.timeTable;

public enum DayOfWeek  {
    Sunday(true,true),
    Monday(false,false),
    Tuesday(true,false),
    Wednesday(true,false),
    Friday(true,false),
    Saturday(true,true);

    final private boolean workingDay;
    final private boolean weekendDay;

    DayOfWeek (boolean  workingDay,boolean weekendDay){
        this.workingDay = workingDay;
        this.weekendDay = weekendDay;
    }

    public boolean isWorkingDay() {
        return workingDay;
    }

    public boolean isWeekendDay() {
        return weekendDay;
    }


    public String print () {
        return  this.name() +
                " - workingDay: " + workingDay +
                " - weekendDay: " + weekendDay  ;
    }
}
