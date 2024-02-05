package com.engeto.restaurant;

import java.io.*;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CookBook {


    private static Map<Integer, Dish> cookBook;

    public CookBook() {
        cookBook = new HashMap<>();
    }

    public void addDish(Dish dish) {
        if (!cookBook.containsKey(dish.getDishNumber())) {
            cookBook.put(dish.getDishNumber(), dish);
        } else {
            System.out.println("Jídlo už je v seznamu." + dish.getTitle());
        }
    }

    public void editDish(int dishNumber, Dish editedDish) {
        if (cookBook.containsKey(dishNumber)) {
            Dish newDish = cookBook.get(dishNumber);
            newDish.setTitle(editedDish.getTitle());
            newDish.setPrice(editedDish.getPrice());
            newDish.setPreparationTime(editedDish.getPreparationTime());
            newDish.setFileName(editedDish.getFileName());
        }

    }


    public void removeDish(int dishNumber) {
        cookBook.remove(dishNumber);
    }

    public static Map<Integer, Dish> getCookBook() {
        return cookBook;
    }

    public static Dish getDishByNumber(int dishNumber) {
        return cookBook.get(dishNumber);
    }


    public void printDishes() {
        System.out.println("Seznam pokrmů:");
        for (Map.Entry<Integer, Dish> entry : cookBook.entrySet()) {
            System.out.println(entry.getKey() + ". " + entry.getValue().toString());
        }
        System.out.println("\n");
    }

    public static CookBook loadFromFile(String filename) throws DishException {
        CookBook newCookBook = new CookBook();
        int lineNumber = 1;
        try {
            Scanner scanner = new Scanner(new BufferedReader(new FileReader(filename)));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                parseLine(line, newCookBook, lineNumber);
                lineNumber++;
            }

        } catch (FileNotFoundException e) {
            throw new DishException("Soubor " + filename + " nelze otevřít");
        }
        return newCookBook;
    }

    public static void parseLine(String line, CookBook cookBook, int lineNumber) throws DishException {
        String[] blocks = line.split("\\t");

        if (blocks.length != 4) {
            throw new DishException("Nesprávný počet položek na řádku: " + lineNumber + ". :" + line + "! Počet položek: " + blocks.length + ".");

        }
        String title = blocks[0].trim();
        BigDecimal price;
        try {
            price = BigDecimal.valueOf(Long.parseLong(blocks[1].trim()));
        } catch (NumberFormatException e) {
            throw new DishException("Nesprávně zadaný formát ceny \"" + blocks[1] + "\" na řádku " + lineNumber + ". Zadaná hodnota musí číslo!");
        }

        int preparationTime = 0;
        try {
            preparationTime = Integer.parseInt(blocks[2].trim());
        } catch (NumberFormatException e) {
            throw new DishException("Nesprávně zadaný formát doby přípravy \"" + blocks[2] + "\" na řádku " + lineNumber + ". Zadaná hodnota musí být uvedena v minutách!");
        }

        String fileName = blocks[3].trim();


        Dish newDish = new Dish(title, price, preparationTime, fileName);
        cookBook.addDish(newDish);
    }

    public static void saveCookBookToFile(String filename) throws DishException {
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(filename, false)))) {
            for (Map.Entry<Integer, Dish> entry : getCookBook().entrySet()) {
                writer.println(entry.getValue().getTitle() + Settings.getGetFileCookBookDelimiter()
                        + entry.getValue().getPrice() + Settings.getGetFileCookBookDelimiter()
                        + entry.getValue().getPreparationTime() + Settings.getGetFileCookBookDelimiter()
                        + entry.getValue().getFileName());
            }


        } catch (IOException e) {
            throw new DishException("Soubor \"" + filename + "\" se nepodařilo zapsat. " + e.getLocalizedMessage());
        }

    }


}
