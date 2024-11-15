package com.plurasight;

import java.util.ArrayList;
import java.util.List;


public class Order {
    private List<Sandwich> sandwiches = new ArrayList<>();
    private List<Sides.Drink> drinks = new ArrayList<>();
    private List<Sides.Chips> chips = new ArrayList<>();
    private List<String> sauces = new ArrayList<>();
    private double totalCost;

    public void addSandwich(Sandwich sandwich) {
        sandwiches.add(sandwich);
        totalCost += sandwich.getPrice();
    }

    public void addDrink(Sides.Drink drink) {
        drinks.add(drink);
        totalCost += drink.getPrice();
    }

    public void addChips(Sides.Chips chip) {
        chips.add(chip);
        totalCost += chip.getPrice();
    }

    public void addSauce(String sauce) {
        sauces.add(sauce);
        totalCost += 0.15;  // Sauce price
    }

    public double getTotalCost() {
        return totalCost;
    }

    @Override
    public String toString() {
        return "Order{" +
                "sandwiches=" + sandwiches +
                ", drinks=" + drinks +
                ", chips=" + chips +
                ", sauces=" + sauces +
                ", totalCost=" + totalCost +
                '}';
    }
}


