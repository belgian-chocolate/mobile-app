package com.tainguyenbui.techsprint.Utils;

import java.util.Calendar;

/**
 * Created by tainguyenbui on 14/03/2017.
 */

public enum DateUtil {;

    public static String getDayOfTheWeek(Calendar calendar) {

        String dayOfWeek = "";

        switch(calendar.get(Calendar.DAY_OF_WEEK)) {
            case 1:
                dayOfWeek = "Monday";
                break;
            case 2:
                dayOfWeek = "Tuesday";
                break;
            case 3:
                dayOfWeek = "Wednesday";
                break;
            case 4:
                dayOfWeek = "Thursday";
                break;
            case 5:
                dayOfWeek = "Friday";
                break;
            case 6:
                dayOfWeek = "Saturday";
                break;
            case 7:
                dayOfWeek = "Sunday";
                break;
            default:
                dayOfWeek = "";
                break;
        }

        return dayOfWeek;
    }

    public static String getDayOfMonth(Calendar calendar) {

        String dayOfMonth;

        int day = calendar.get(Calendar.DAY_OF_MONTH);

        if(day >= 11 && day <= 13) {
            return String.format("%dth", day);
        }

        switch (day % 10) {
            case 1:
                return String.format("%dst", day);
            case 2:
                return String.format("%dnd", day);
            case 3:
                return String.format("%drd", day);
            default:
                return String.format("%dth", day);
        }
    }
}
