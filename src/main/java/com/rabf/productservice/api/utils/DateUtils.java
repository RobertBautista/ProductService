package com.rabf.productservice.api.utils;

import java.util.Calendar;
import java.util.Date;

public class DateUtils {

    /**
     * If result is decimal, value returned is rounded to ceiling
     * @param aDate Date to count years elapsed
     * @return number of years since aDate to current date
     */
    public static int getYearsElapsedUntilToday(Date aDate) {
        Calendar currentCal = Calendar.getInstance();
        Calendar cal = Calendar.getInstance();
        cal.setTime(aDate);

        int anios = currentCal.get(Calendar.YEAR) - cal.get(Calendar.YEAR);

        if (currentCal.get(Calendar.DAY_OF_YEAR) > cal.get(Calendar.DAY_OF_YEAR)) {
            anios++;
        }

        return anios;
    }

    public static boolean isSameCurrentDayAndMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        int currentMonth = cal.get(Calendar.MONTH);
        int currentDay = cal.get(Calendar.DAY_OF_MONTH);

        cal.setTime(date);

        return cal.get(Calendar.MONTH) == currentMonth && cal.get(Calendar.DAY_OF_MONTH) == currentDay;
    }

}
