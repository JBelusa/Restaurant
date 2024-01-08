package com.engeto.restaurant;

public class Settings {

    private static final String getFileCookBookDelimiter = "\t";
    private static final String defaultFileName = "seznamjidel.txt";

    public static String getGetFileCookBookDelimiter() {
        return getFileCookBookDelimiter;
    }

    public static String getDefaultFileName() {
        return defaultFileName;
    }
}
