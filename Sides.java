package com.plurasight;

import java.util.Scanner;
public class Sides {

    public static class Drink {
        private String brand;
        private String flavor;
        private String size;
        private double price;

        public Drink(String brand, String flavor, String size) {
            this.brand = brand;
            this.flavor = flavor;
            this.size = size;
            this.price = 4.00;  // Base price for any drink
            // Adding extra price based on size
            switch (size) {
                case "Large": this.price += 0.75; break;
                case "Medium": this.price += 0.50; break;
                case "Small": this.price += 0.25; break;
            }
        }

        public double getPrice() {
            return this.price;
        }

        @Override
        public String toString() {
            return "Drink{" + "brand='" + brand + '\'' + ", flavor='" + flavor + '\'' + ", size='" + size + '\'' + '}';
        }
    }

    public static class Chips {
        private String brand;
        private String flavor;
        private double price;

        public Chips(String brand, String flavor) {
            this.brand = brand;
            this.flavor = flavor;
            this.price = 7.00;  // Chips price
        }

        public double getPrice() {
            return this.price;
        }

        @Override
        public String toString() {
            return "Chips{" + "brand='" + brand + '\'' + ", flavor='" + flavor + '\'' + '}';
        }
    }
}
