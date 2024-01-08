package com.engeto.restaurant;

import java.math.BigDecimal;
import java.time.LocalTime;

public class TestingData {
    private static void cookBookData(CookBook cookBook) {
        cookBook.addDish(new Dish("Kuřecí řízek obalovaný 150 g", BigDecimal.valueOf(120), 20, "rizek-obalovany-01"));
        cookBook.addDish(new Dish("Hranolky 150 g", BigDecimal.valueOf(105), 30, "hranolky-01"));
        cookBook.addDish(new Dish("Pstruh na víně 200 g", BigDecimal.valueOf(158), 15, "pstruh-na-vine-01"));
        cookBook.addDish(new Dish("Kofola 0,5 l", BigDecimal.valueOf(39), 2, "kofola-01"));
    }

    public static void addCookBookData(CookBook cookBook) {
        cookBookData(cookBook);
    }

    private static void ordersData(Order order) {
        order.addOrder(new Order(1, 1, 1, LocalTime.now(), false));
        order.addOrder(new Order(1, 3, 1, LocalTime.now(), false));
        order.addOrder(new Order(12, 3, 31, LocalTime.now(), true));
    }

    public static void addOrdersData(Order order) {
        ordersData(order);
    }


    //        Order firstOrder= new Order(1,1,5,kofola, LocalTime.of(15,30), LocalTime.of(23,30),true);
//    System.out.println(firstOrder);

}