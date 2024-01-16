package com.engeto.restaurant;

import java.io.*;
import java.math.BigDecimal;



public class TestingData {
    private static void cookBookData(CookBook cookBook) {
        try (BufferedReader reader = new BufferedReader(new FileReader(Settings.getDefaultFileName()))){
             if(reader.readLine()==null){
            cookBook.addDish(new Dish("Kuřecí řízek obalovaný 150 g", BigDecimal.valueOf(120), 20, "rizek-obalovany-01"));
            cookBook.addDish(new Dish("Hranolky 150 g", BigDecimal.valueOf(105), 15, "hranolky-01"));
            cookBook.addDish(new Dish("Pstruh na víně 200 g", BigDecimal.valueOf(158), 30, "pstruh-na-vine-01"));
            cookBook.addDish(new Dish("Kofola 0,5 l", BigDecimal.valueOf(39), 2, "kofola-01"));
        }
    } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }

    }



    public static void addCookBookData(CookBook cookBook) {
        cookBookData(cookBook);
    }

    private static void ordersData(Order order) {

        //Yesterday orders
        order.addOrder(new Order(2, 10, 1, Settings.getTimeMinutesAgo(),Settings.getDateDaysAgo()));
        order.addOrder(new Order(2, 20, 3, Settings.getTimeMinutesAgo(),Settings.getDateDaysAgo()));
        order.addOrder(new Order(2, 30, 2, Settings.getTimeMinutesAgo(),Settings.getDateDaysAgo()));
        order.addOrder(new Order(2, 30, 3, Settings.getTimeMinutesAgo(),Settings.getDateDaysAgo()));

        order.addOrder(new Order(15, 20, 1,Settings.getTimeMinutesAgo(),Settings.getDateDaysAgo()));
        order.addOrder(new Order(15, 20, 2,Settings.getTimeMinutesAgo(),Settings.getDateDaysAgo()));
        order.addOrder(new Order(15, 20, 4,Settings.getTimeMinutesAgo(),Settings.getDateDaysAgo()));

        //Today orders
        order.addOrder(new Order(2, 1, 1, Settings.getTimeMinutesAgo()));
        order.addOrder(new Order(2, 2, 3, Settings.getTimeMinutesAgo()));
        order.addOrder(new Order(2, 3, 2, Settings.getTimeMinutesAgo()));
        order.addOrder(new Order(2, 3, 3, Settings.getTimeMinutesAgo()));

        order.addOrder(new Order(15, 2, 1, Settings.getTimeMinutesAgo()));
        order.addOrder(new Order(15, 2, 2, Settings.getTimeMinutesAgo()));
        order.addOrder(new Order(15, 2, 4, Settings.getTimeMinutesAgo()));
    }

    public static void addOrdersData(Order order) {
        ordersData(order);
    }
}