package com.engeto.restaurant;

public class FileManager {

    public static CookBook loadPlants(String filename) {
        CookBook cookBook = null;
        try {
            cookBook = CookBook.loadFromFile(filename);

        } catch (DishException e) {
            System.err.println("Chyba při čtění souboru. " + e.getLocalizedMessage());
        }

        return cookBook;
    }

    //Metoda pro uložení seznamu rostlin do souboru s požadovaným jménem
    public static void savePlants(String filename, CookBook plantListToSave) {
        try {
            CookBook.saveToFile(filename, plantListToSave);
        } catch (DishException e) {
            System.err.println("Chyba při ukládání souboru. " + e.getLocalizedMessage());
        }
    }


}
