package com.engeto.restaurant;

import java.time.LocalDate;
import java.time.LocalTime;
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

    private static final Map<Integer, Order> orders = new HashMap<>();


    public Order(int tableNumber, int dishCount, int dishNumber, LocalTime orderedTime, boolean isPaid) {
        this.orderNumber = nextOrderNumber++;
        this.tableNumber = tableNumber;
        this.dishCount = dishCount;
        this.dishNumber = dishNumber;
        this.orderDate = LocalDate.now();
        this.orderedTime = orderedTime;
        this.isPaid = false;
        this.dish = CookBook.getDishByNumber(dishNumber);
        this.fulfilmentTime=this.orderedTime.plusMinutes(this.dish.getPreparationTime());
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
        System.out.printf("**Objednávky pro stůl č. %2d **%n", tableNumber);
//      getTableOrders(tableNumber).forEach(System.out::println);
        for (Order order : getTableOrders(tableNumber)) {
            System.out.printf(order.getOrderNumber() + " " + order.dish.getTitle() + " " + order.dishCount + " " + order.getFulfilmentTime() + "%n");

        }
    }

    private List<Order> getTableOrders(int tableNumber) {
        return orders.values().stream().filter(order -> order.getTableNumber() == tableNumber).collect(Collectors.toList());
    }


    @Override
    public String toString() {
        return "Order{" + "orderNumber=" + orderNumber + ", tableNumber=" + tableNumber + ", dishCount=" + dishCount + ", dishNumber=" + dishNumber + ", orderedTime=" + orderedTime + ", fulfilmentTime=" + fulfilmentTime + ", isPaid=" + isPaid + '}';
    }
}

