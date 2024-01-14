package com.engeto.restaurant;

public class FileManager {

    public static CookBook loadCookBook(String filename) {
        CookBook cookBook = null;
        try {
            cookBook = CookBook.loadFromFile(filename);

        } catch (DishException e) {
            System.err.println("Chyba při čtění souboru. " + e.getLocalizedMessage());
        }

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
