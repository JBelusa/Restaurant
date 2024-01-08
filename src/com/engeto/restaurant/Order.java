package com.engeto.restaurant;

import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;

public class Order {


    private int orderNumber;
    private static int nextOrderNumber = 1;
    private int tableNumber;
    private int dishCount;
    private Dish dish;
    private int dishNumber;
    private LocalTime orderedTime;
    private LocalTime fulfilmentTime;
    private boolean isPaid;

    private static Map<Integer, Order> orders = new HashMap<>();

    public Order(int tableNumber, int dishCount, int dishNumber, LocalTime orderedTime, boolean isPaid) {
        this.orderNumber = nextOrderNumber++;
        this.tableNumber = tableNumber;
        this.dishCount = dishCount;
        this.dishNumber = dishNumber;
        this.orderedTime = orderedTime;
        this.isPaid = false;
        orders.put(orderNumber, this);


    }

    public int getTableNumber() {
        return tableNumber;
    }

    public static Map<Integer, Order> getOrders() {
        return orders;
    }

    public void printOrder() {


    }


//    public static Map<Integer, List<Order>> getTableOrders(int tableNumber) {
//        Map<Integer, List<Order>> tableOrders = new HashMap<>();
//        List<Order> ordersForTable = new ArrayList<>();
//        for (Map.Entry<Integer, Order> order : orders.entrySet()) {
//
//            if (order.getValue().getTableNumber() == tableNumber) {
//                ordersForTable.add(order.getValue());
//                tableOrders.put(tableNumber, ordersForTable);
//            }
//        }
//
//        return tableOrders;
//    }

    public static List<Order> getTableOrders(int tableNumber) {
        return orders.values().stream()
                .filter(order -> order.getTableNumber() == tableNumber)
                .collect(Collectors.toList());
    }


    @Override
    public String toString() {
        return "Order{" + "orderNumber=" + orderNumber + ", tableNumber=" + tableNumber + ", dishCount=" + dishCount + ", dishNumber=" + dishNumber + ", orderedTime=" + orderedTime + ", fulfilmentTime=" + fulfilmentTime + ", isPaid=" + isPaid + '}';
    }
}
