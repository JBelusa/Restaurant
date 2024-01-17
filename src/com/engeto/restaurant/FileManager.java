package com.engeto.restaurant;

import java.io.*;

public class FileManager {


    public static void loadCookBook(String filename) {
        try {
            new FileOutputStream(Settings.getCookBookFileName(), true).close();

            CookBook.loadFromFile(filename);
        } catch (DishException | FileNotFoundException e) {
            System.err.println("Soubor " + Settings.getCookBookFileName() + " se nepodařilo otevřít: " + e.getLocalizedMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void saveCookBook(String filename) {
        try {
            CookBook.saveCookBookToFile(filename);
        } catch (DishException e) {
            System.err.println("Chyba při ukládání souboru. " + e.getLocalizedMessage());
        }
    }

    public static void loadOrders(String filename) {
        if (!CookBook.getCookBook().isEmpty()
        ) {
            try {
                Order.loadFromFile(filename);
            } catch (OrderException e) {
                System.err.println("Chyba při čtění souboru. " + e.getLocalizedMessage());
            }
        }
    }

    public static void saveOrders(String filename) {
        try {
            Order.saveOrderToFile(filename);
        } catch (OrderException e) {
            System.err.println("Chyba při ukládání souboru. " + e.getLocalizedMessage());
        }
    }


}
