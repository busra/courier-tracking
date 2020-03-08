package com.busra.couriertracking.util;

import java.util.Date;

public final class DateUtils {

    private DateUtils() {
    }

    public static long timeDifferenceInSeconds(Date firstDate, Date secondDate) {
        return (secondDate.getTime() - firstDate.getTime()) / 1_000;
    }

}