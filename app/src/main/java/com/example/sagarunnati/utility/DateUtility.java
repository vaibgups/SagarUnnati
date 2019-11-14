package com.example.sagarunnati.utility;

import androidx.annotation.NonNull;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateUtility {

    static int currentYear = Calendar.getInstance().get(Calendar.YEAR);
    static int currentYearPrevious = currentYear - 1;
    static int currentYearFuture = currentYear + 1;
    static String selectedPreviousMonth = "";
    static String  yearSelected ="", monthSelected = "", currentDate = "", currentMonth = "", currentYearFutureString = "",
    previousMonth = "";


    @NonNull
    public static String currentYearPreviousString() {
        return (currentYearPrevious + "-" + String.valueOf(currentYear).substring(2, 4));

    }

    @NonNull
    public static String currentYearFutureString() {
        return (currentYear + "-" + String.valueOf(currentYearFuture).substring(2, 4));

    }

    public static String selectedPreviousYear(@NonNull String selectedYear) {
        int number = Integer.parseInt(selectedYear.substring(0, 4));
        int numberDec = number - 1;
        String yearDec = String.valueOf(numberDec) + "-" + selectedYear.substring(2, 4);
        return yearDec;
    }

    public static String selectedFutureYear(@NonNull String selectedYear) {
        int number = Integer.parseInt(selectedYear.substring(0, 4));
        int numberInc = number + 1;
        String yearDec = String.valueOf(numberInc) + "-" + String.valueOf(numberInc+1).substring(2, 4);
        return yearDec;
    }

    public static String currentMonth(){
        Calendar cal = Calendar.getInstance();
//        currentDate=new SimpleDateFormat("dd-MM-yyyy").format(cal.getTime());
        currentMonth = new SimpleDateFormat("MMM").format(cal.getTime());
        return currentMonth;

    }

    public static String previousMonth(){
        Calendar cal = Calendar.getInstance();
        selectedPreviousMonth=new SimpleDateFormat("MMM").format(cal.getTime());
        cal.add(Calendar.MONTH, -1);
        previousMonth = previousMonth+cal.getTime();
        return previousMonth;
    }
}
