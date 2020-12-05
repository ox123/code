package org.basic.java.time;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class DateUtils {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        System.out.println(now.minusDays(10));
        System.out.println(now.with(TemporalAdjusters.lastDayOfYear()));
        System.out.println(now.with(TemporalAdjusters.lastDayOfMonth()));
        System.out.println('A'-'0');
    }
}
