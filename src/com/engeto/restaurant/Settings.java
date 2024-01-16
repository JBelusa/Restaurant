package com.engeto.restaurant;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Settings {

    private static final String getFileCookBookDelimiter = "\t";
    private static final String defaultFileName = "seznamjidel.txt";

    private static final String dateOrderFilename = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy_hh_mm"));

    private static final String defaultSaveFileName = "seznamobjednavek.txt";

    private static final LocalTime timeMinutesAgo = LocalTime.now().minusMinutes(18);
    private static final LocalDate dateDaysAgo = LocalDate.now().minusDays(1);

    public static String getGetFileCookBookDelimiter() {
        return getFileCookBookDelimiter;
    }

    public static String getDefaultFileName() {
        return defaultFileName;
    }

    public static String getDefaultSaveFileName() {
        return defaultSaveFileName;
    }

    public static String getDateOrderFilename() {
        return dateOrderFilename;
    }

    public static LocalTime getTimeMinutesAgo() {
        return timeMinutesAgo;
    }

    public static LocalDate getDateDaysAgo() {
        return dateDaysAgo;
    }
}
