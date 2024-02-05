package com.engeto.restaurant;

import java.io.*;

public class FileManager {


    public static CookBook loadCookBook(String filename) {
        CookBook newCookBook = null;
        try {
            new FileOutputStream(Settings.getCookBookFileName(), true).close();

            newCookBook = CookBook.loadFromFile(filename);
        } catch (DishException | FileNotFoundException e) {
            System.err.println("Soubor " + Settings.getCookBookFileName() + " se nepodařilo otevřít: " + e.getLocalizedMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return newCookBook;
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
