package com.engeto.restaurant;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

public class FileManager {

    public static CookBook loadCookBook(String filename) throws IOException, DishException {
        CookBook cookBook = null;

        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(filename)));
        cookBook = CookBook.loadFromFile(filename);
        return cookBook;
    }

    public static Order loadOrders(String filename) {
        Order order = null;
        try {
            order = RestaurantManager.loadFromFile(filename);
        } catch (DishException e) {
            System.err.println("Chyba při čtění souboru. " + e.getLocalizedMessage());
        }
        return order;
    }

    //Metoda pro uložení seznamu rostlin do souboru s požadovaným jménem
    public static void saveCookBook(String filename, CookBook plantListToSave) {
        try {
            CookBook.saveCookBookToFile(filename, plantListToSave);
        } catch (DishException e) {
            System.err.println("Chyba při ukládání souboru. " + e.getLocalizedMessage());
        }
    }


}
