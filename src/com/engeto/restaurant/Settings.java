package com.engeto.restaurant;

import java.time.LocalTime;

public class Settings {

    private static final String getFileCookBookDelimiter = "\t";
    private static final String defaultFileName = "seznamjidel.txt";

    private static final String defaultSaveFileName = "seznamobjednavek.txt";

    private static final LocalTime timeMinutesAgo = LocalTime.now().minusMinutes(18);

    public static String getGetFileCookBookDelimiter() {
        return getFileCookBookDelimiter;
    }

    public static String getDefaultFileName() {
        return defaultFileName;
    }
    public static String getDefaultSaveFileName() {
        return defaultSaveFileName;
    }

    public static LocalTime getTimeMinutesAgo() {
        return timeMinutesAgo;
    }
}
