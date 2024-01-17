package com.engeto.restaurant;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Settings {

    private static final String getFileCookBookDelimiter = "\t";
    private static final String cookBookFileName = "seznamjidel.txt";

    private static final String dateOrderFilename = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy_HH-mm"));

    private static final String defaultOrderFileName = "seznamobjednavek.txt";

    private static final LocalTime timeMinutesAgo = LocalTime.now().minusMinutes(15);
    private static final LocalDate dateDaysAgo = LocalDate.now().minusDays(1);

    public static String getGetFileCookBookDelimiter() {
        return getFileCookBookDelimiter;
    }

    public static String getCookBookFileName() {
        return cookBookFileName;
    }

    public static String getDefaultOrderFileName() {
        return defaultOrderFileName;
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
