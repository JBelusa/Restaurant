package com.engeto.restaurant;

import java.io.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class Order {


    private static int nextOrderNumber = 1;

    private int orderNumber;
    private int tableNumber;
    private int dishCount;
    private Dish dish;
    private int dishNumber;

    private LocalDate orderDate;
    private LocalTime orderedTime;
    private LocalTime fulfilmentTime;
    private boolean isPaid;

    private static Map<Integer, Order> orders = new HashMap<>();


    public Order(int tableNumber, int dishCount, int dishNumber, LocalTime orderedTime) {
        this.orderNumber = nextOrderNumber++;
        this.tableNumber = tableNumber;
        this.dishCount = dishCount;
        this.dishNumber = dishNumber;
        this.orderDate = LocalDate.now();
        this.orderedTime = orderedTime;

        this.dish = CookBook.getDishByNumber(dishNumber);
        this.fulfilmentTime = this.orderedTime.plusMinutes(this.dish.getPreparationTime());
//        if (fulfilmentTime.isBefore(LocalTime.now())) {
//            setPaid(true);
//        }
        orders.put(orderNumber, this);
    }

    public Order() {

    }

    //region Getters and Setters


    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }


    public int getDishCount() {
        return dishCount;
    }

    public void setDishCount(int dishCount) {
        this.dishCount = dishCount;
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public int getDishNumber() {
        return dishNumber;
    }


    public void setDishNumber(int dishNumber) {
        this.dishNumber = dishNumber;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public LocalTime getOrderedTime() {
        return orderedTime;
    }

    public void setOrderedTime(LocalTime orderedTime) {
        this.orderedTime = orderedTime;
    }

    public LocalTime getFulfilmentTime() {
        return fulfilmentTime;

    }

    public void setFulfilmentTime(LocalTime fulfilmentTime) {
        this.fulfilmentTime = fulfilmentTime;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public int getOrderNumber() {
        return orderNumber;
    }


    //endregion

    public void addOrder(Order order) {
        orders.put(order.getOrderNumber(), order);
    }

    public static void resetOrderNumber() {
        nextOrderNumber = 1;
    }

    public Map<Integer, Order> getOrders() {
        return orders;
    }


    public void printTableOrders(int tableNumber) {
        int orderPerTable = 1;
        System.out.printf("**Objednávky pro stůl č. %2d **%n", tableNumber);
        System.out.println("****");

        for (Order order : getTableOrders(tableNumber)) {

            isOrderPaid(order);
            String isPaidString = order.isPaid ? "Zaplaceno" : "Nezaplaceno";
            System.out.printf(orderPerTable + ". "
                    + order.dish.getTitle() + " "
                    + order.dishCount + "x "
                    + "(" + order.dish.getPrice() + " Kč):\t"
                    + order.getOrderedTime().format(DateTimeFormatter.ofPattern("HH:mm"))
                    + "-"
                    + order.getFulfilmentTime().format(DateTimeFormatter.ofPattern("HH:mm"))
                    + " " + isPaidString + "%n");
            orderPerTable++;
        }
        System.out.println("******");
    }

    public void printTablePrice(int tableNumber) {
        BigDecimal tablePrice = new BigDecimal(0);
        for (Order order : getTableOrders(tableNumber)) {
            tablePrice = tablePrice.add(order.dish.getPrice().multiply(BigDecimal.valueOf(order.getDishCount())));
        }
        System.out.println(tablePrice);
    }

    private void isOrderPaid(Order order) {
        if (order.fulfilmentTime.isBefore(LocalTime.now())) {
            order.setPaid(true);
        }
    }


    private List<Order> getTableOrders(int tableNumber) {
        return orders.values()
                .stream()
                .filter(order -> order.getTableNumber() == tableNumber)
                .collect(Collectors.toList());
    }


    public static void saveOrderToFile(String filename, Order order) throws OrderException {
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(filename)))) {
            for (Map.Entry<Integer, Order> entry : Order.orders.entrySet()) {
                writer.println(entry.getValue().getOrderNumber() + Settings.getGetFileCookBookDelimiter()
                        + entry.getValue().getTableNumber() + Settings.getGetFileCookBookDelimiter()
                        + entry.getValue().getDishCount() + Settings.getGetFileCookBookDelimiter()
                        + entry.getValue().getDishNumber() + Settings.getGetFileCookBookDelimiter()
                        + entry.getValue().getOrderedTime() + Settings.getGetFileCookBookDelimiter());

            }


        } catch (IOException e) {
            throw new OrderException("Soubor \"" + filename + "\" se nepodařilo zapsat. " + e.getLocalizedMessage());
        }

    }


    @Override
    public String toString() {
        return "Order{" + "orderNumber=" + orderNumber + ", tableNumber=" + tableNumber + ", dishCount=" + dishCount + ", dishNumber=" + dishNumber + ", orderedTime=" + orderedTime + ", fulfilmentTime=" + fulfilmentTime + ", isPaid=" + isPaid + '}';
    }
}

