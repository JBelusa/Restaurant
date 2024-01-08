package com.engeto.restaurant;

import java.math.BigDecimal;

public class Dish {

    public static int nextdishNumber = 1;

    private final int dishNumber = nextdishNumber++;
    private String title;
    private BigDecimal price;
    private int preparationTime;
    private String fileName;


    public String getTitle() {
        return title;
    }

    public Dish(String title, BigDecimal price, int preparationTime, String fileName) {
        this.title = title;
        this.price = price;
        if (preparationTime > 0) {
            this.preparationTime = preparationTime;
        } else {
            System.out.println("Čas přípravy jídla nesmí být záporný nebo nula");                                       // dodělat exception
        }
        this.fileName = fileName;

    }

    public Dish(String title, BigDecimal price, int preparationTime) {
        this(title, price, preparationTime, "blank");

    }

    public int getDishNumber() {
        return dishNumber;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getPreparationTime() {
        return preparationTime;
    }

    public void setPreparationTime(int preparationTime) {
        this.preparationTime = preparationTime;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }


    @Override
    public String toString() {
        return title + '\t' +
                "("+price +" Kč)"+ '\t' +
                preparationTime +" min" + '\t' +
                fileName + '\t';
    }
}
