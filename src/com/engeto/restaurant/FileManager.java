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

    //Metoda pro uložení seznamu rostlin do souboru s požadovaným jménem
    public static void saveCookBook(String filename, CookBook plantListToSave) {
        try {
            CookBook.saveToFile(filename, plantListToSave);
        } catch (DishException e) {
            System.err.println("Chyba při ukládání souboru. " + e.getLocalizedMessage());
        }
    }


}
