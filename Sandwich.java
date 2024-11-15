package com.plurasight;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Sandwich {
    private String type;
    private double price;
    private String bread;
    private String size;
    private boolean toasted;
    private List<String> toppings;

    public Sandwich(String type, double price) {
        this.type = type;
        this.price = price;
        this.toppings = new ArrayList<>();
    }

    public void setBread(String bread) {
        this.bread = bread;
        this.price += 1.50;  // Adding bread price
    }

    public void setSize(String size) {
        this.size = size;
        switch (size) {
            case "4\"":
                this.price += 0.50;
                break;
            case "8\"":
                this.price += 0.75;
                break;
            case "12\"":
                this.price += 1.00;
                break;
        }
    }

    public void setToasted(boolean toasted) {
        this.toasted = toasted;
    }

    public void addTopping(String topping) {
        this.toppings.add(topping);
        this.price += 0.50;  // Adding topping price
    }

    public double getPrice() {
        return this.price;
    }

    @Override
    public String toString() {
        return "Sandwich{" +
                "type='" + type + '\'' +
                ", price=" + price +
                ", bread='" + bread + '\'' +
                ", size='" + size + '\'' +
                ", toasted=" + toasted +
                ", toppings=" + toppings +
                '}';
    }
}
