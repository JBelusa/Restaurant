package com.engeto.restaurant;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalTime;
import java.util.Scanner;

public class RestaurantManager {
Order order = new Order();

    public static Order loadFromFile(String filename) throws DishException {
        Order newOrder = new Order();


        int lineNumber = 1;
        try {
            Scanner scanner = new Scanner(new BufferedReader(new FileReader(filename)));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                parseLine(line, newOrder, lineNumber);
                lineNumber++;
            }
        } catch (FileNotFoundException e) {
            throw new DishException("Soubor " + filename + " nelze otevřít");
        }
//        System.out.println(newOrder.getOrders());

        return newOrder;

    }

    public static void parseLine(String line, Order newOrder, int lineNumber) throws DishException {
        String[] blocks = line.split("\\t");

        if (blocks.length != 5) {
            throw new DishException("Nesprávný počet položek na řádku: " + line + "! Počet položek: " + blocks.length + ".");
        }
        int orderNumber = 0;
        try {
            orderNumber = Integer.parseInt(blocks[1].trim());
        } catch (NumberFormatException e) {
            throw new DishException("Nesprávně zadaný formát doby přípravy \"" + blocks[2] + "\" na řádku " + lineNumber + ". Zadaná hodnota musí být uvedena v minutách!");
        }
        int tableNumber = 0;
        try {
            tableNumber = Integer.parseInt(blocks[2].trim());
        } catch (NumberFormatException e) {
            throw new DishException("Nesprávně zadaný formát doby přípravy \"" + blocks[2] + "\" na řádku " + lineNumber + ". Zadaná hodnota musí být uvedena v minutách!");
        }


        int dishNumber = 0;
        try {
            dishNumber = Integer.parseInt(blocks[3].trim());
        } catch (NumberFormatException e) {
            throw new DishException("Nesprávně zadaný formát doby přípravy \"" + blocks[2] + "\" na řádku " + lineNumber + ". Zadaná hodnota musí být uvedena v minutách!");
        }

        LocalTime orderedTime;
        try {
            orderedTime = LocalTime.parse(blocks[4].trim());
        } catch (NumberFormatException e) {
            throw new DishException("Nesprávně zadaný formát doby přípravy \"" + blocks[2] + "\" na řádku " + lineNumber + ". Zadaná hodnota musí být uvedena v minutách!");
        }


        newOrder.addOrder(new Order(orderNumber, tableNumber, dishNumber, orderedTime));


    }


}
