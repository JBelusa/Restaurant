package com.engeto.restaurant;


import java.sql.SQLOutput;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class RestaurantManager {

    public void unfulfilledOrders(Order orders, LocalDate date) {
        int unfulfilled = 0;

        for (Order order : orders.getOrders().values()) {
            orders.isOrderPaid(order);
            if (!order.isPaid() && order.checkDate(date, order)) {
                unfulfilled++;
            }
        }
        System.out.println("Počet rozpracovaných objednávek: " + unfulfilled);
    }

    public void orderedDishList(Order orders, LocalDate date) {
        System.out.println("\nDnes objednané jídla:");
        Set<Dish> orderedDishes = new HashSet<>();
        for (Order order : orders.getOrders().values()) {
            if (order.checkDate(date, order)) {
                orderedDishes.add(order.getDish());
            }
        }
        orderedDishes.forEach(System.out::println);
    }

    public void sortOrdersByOrderTime(Order orders, LocalDate date) {
        System.out.println("\nSeřazené objednávky dle času založení:");
        List<Order> ordersByTime = new ArrayList<>();

        for (Order order : orders.getOrders().values()) {
            if (order.checkDate(date, order)) {
                ordersByTime.add(order);
            }
        }
        ordersByTime.sort(Comparator.comparing(Order::getOrderedTime));
        for (Order order : ordersByTime) {
            System.out.printf("Číslo objednávky: %2d Čas objednání: "
                    + order.getOrderedTime().format(DateTimeFormatter.ofPattern("HH:mm")) + "\n", order.getOrderNumber());
        }
        System.out.println();
    }

    public void averageOrderTime(Order orders, LocalDate date) {
        System.out.println("\nPrůměrný čas zpracování objednávky:");
        Duration averageOrderTime;
        Duration totalOrderTime = Duration.ZERO;
        int finishedOrders = 0;
        String formattedAverage = "";

        for (Order order : orders.getOrders().values()) {
            if (order.checkDate(date, order)) {
                finishedOrders++;
                totalOrderTime = totalOrderTime.plus(Duration.between(order.getOrderedTime(), order.getFulfilmentTime()));

            }
        }
        if (finishedOrders > 0) {
            averageOrderTime = totalOrderTime.dividedBy(finishedOrders);
            formattedAverage = String.format("%02d:%02d:%02d",
                    averageOrderTime.toHours(),
                    averageOrderTime.toMinutesPart(),
                    averageOrderTime.toSecondsPart());
        }


        System.out.println(formattedAverage);


    }

}



