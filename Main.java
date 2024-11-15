package com.plurasight;
import java.util.Scanner;
import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;
import static Interface.Receipt.saveReceipt;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Order currentOrder = new Order();

        while (true) {
            System.out.println("Welcome to the Sandwich Order App!");
            System.out.println("1) New Order");
            System.out.println("0) Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            if (choice == 1) {
                startNewOrder(scanner, currentOrder);
            } else if (choice == 0) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid choice, try again.");
            }
        }

        scanner.close();
    }

    private static void startNewOrder(Scanner scanner, Order order) {
        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1) Add Sandwich");
            System.out.println("2) Add Sides");
            System.out.println("3) Checkout");
            System.out.println("0) Cancel Order");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            if (choice == 1) {
                addSandwich(scanner, order);
            } else if (choice == 2) {
                addSides(scanner, order);
            } else if (choice == 3) {
                checkout(scanner, order);
                break;
            } else if (choice == 0) {
                System.out.println("Order cancelled.");
                break;
            } else {
                System.out.println("Invalid choice, try again.");
            }
        }
    }

    // Add sandwich logic (prompts user for sandwich options)
    private static void addSandwich(Scanner scanner, Order order) {
        System.out.println("Choose a sandwich type:");
        System.out.println("1) French Dip Sandwich ($10.00)");
        System.out.println("2) Feta Grilled Sandwich ($10.00)");
        System.out.println("3) Butter Burger ($10.00)");
        System.out.println("4) Mushroom Melt Smash Burger ($15.00)");
        System.out.println("5) Smoked Breakfast Chorizo ($15.00)");
        System.out.println("6) Pharaoh BBQ Burger ($15.00)");

        int sandwichChoice = scanner.nextInt();
        scanner.nextLine();  // Consume the newline

        Sandwich sandwich = null;
        switch (sandwichChoice) {
            case 1: sandwich = new Sandwich("French Dip Sandwich", 10.00); break;
            case 2: sandwich = new Sandwich("Feta Grilled Sandwich", 10.00); break;
            case 3: sandwich = new Sandwich("Butter Burger", 10.00); break;
            case 4: sandwich = new Sandwich("Mushroom Melt Smash Burger", 15.00); break;
            case 5: sandwich = new Sandwich("Smoked Breakfast Chorizo", 15.00); break;
            case 6: sandwich = new Sandwich("Pharaoh BBQ Burger", 15.00); break;
        }

        if (sandwich != null) {
            customizeSandwich(scanner, sandwich);
            order.addSandwich(sandwich);
        }
    }

    private static void customizeSandwich(Scanner scanner, Sandwich sandwich) {
        // Bread selection
        System.out.println("Select your bread type:");
        System.out.println("1) Brioche ($1.50)");
        System.out.println("2) French Baguette ($1.50)");
        System.out.println("3) Ciabatta ($1.50)");
        int breadChoice = scanner.nextInt();
        scanner.nextLine();  // Consume the newline
        switch (breadChoice) {
            case 1: sandwich.setBread("Brioche"); break;
            case 2: sandwich.setBread("French Baguette"); break;
            case 3: sandwich.setBread("Ciabatta"); break;
        }

        // Sandwich Size selection
        System.out.println("Select your sandwich size:");
        System.out.println("1) 4\" ($0.50)");
        System.out.println("2) 8\" ($0.75)");
        System.out.println("3) 12\" ($1.00)");
        int sizeChoice = scanner.nextInt();
        scanner.nextLine();  // Consume the newline
        switch (sizeChoice) {
            case 1: sandwich.setSize("4\""); break;
            case 2: sandwich.setSize("8\""); break;
            case 3: sandwich.setSize("12\""); break;
        }

        // Toasted option
        System.out.println("Would you like your sandwich toasted? (yes or no)");
        String toasted = scanner.nextLine();
        sandwich.setToasted(toasted.equalsIgnoreCase("yes"));

        // Toppings
        addToppings(scanner, sandwich);
    }

    // Toppings for sandwich
    private static void addToppings(Scanner scanner, Sandwich sandwich) {
        System.out.println("Choose toppings (type 'done' when finished):");
        System.out.println("1) Extra Cheese ($0.50)");
        System.out.println("2) Lettuce ($0.50)");
        System.out.println("3) Tomatoes ($0.50)");
        System.out.println("4) Other toppings ($0.50)");

        while (true) {
            String topping = scanner.nextLine();
            if (topping.equalsIgnoreCase("done")) break;
            if (topping.equals("1")) sandwich.addTopping("Extra Cheese");
            if (topping.equals("2")) sandwich.addTopping("Lettuce");
            if (topping.equals("3")) sandwich.addTopping("Tomatoes");
            if (topping.equals("4")) sandwich.addTopping("Other toppings");
        }
    }

    private static void addSides(Scanner scanner, Order order) {
        System.out.println("Select a side:");
        System.out.println("1) Add Drinks");
        System.out.println("2) Add Chips");
        System.out.println("3) Add Sauces");
        System.out.println("0) Go back to order screen");

        int choice = scanner.nextInt();
        scanner.nextLine();  // Consume the newline
        switch (choice) {
            case 1: addDrinks(scanner, order); break;
            case 2: addChips(scanner, order); break;
            case 3: addSauces(scanner, order); break;
            case 0: return;
        }
    }

    // Add Drinks (prompt user for choice of brand and size)
    private static void addDrinks(Scanner scanner, Order order) {
        System.out.println("Select a drink brand:");
        System.out.println("1) Zevia");
        System.out.println("2) Sparkling Ice");
        System.out.println("3) Pepsi");

        int drinkChoice = scanner.nextInt();
        scanner.nextLine();  // Consume the newline

        String brand = "";
        String flavor = "";
        switch (drinkChoice) {
            case 1: brand = "Zevia"; break;
            case 2: brand = "Sparkling Ice"; break;
            case 3: brand = "Pepsi"; break;
        }

        System.out.println("Select a flavor:");
        if (brand.equals("Zevia")) {
            System.out.println("4) Ginger Ale");
            System.out.println("5) Grapefruit Citrus");
            System.out.println("6) Lemon Twist");
        } else if (brand.equals("Sparkling Ice")) {
            System.out.println("7) Coconut Pineapple");
            System.out.println("8) Peach Nectarine");
            System.out.println("9) Fruit Punch");
        } else if (brand.equals("Pepsi")) {
            System.out.println("10) Original");
            System.out.println("11) Wild Cherry");
            System.out.println("12) Lime");
        }
        int flavorChoice = scanner.nextInt();
        scanner.nextLine();  // Consume the newline

        switch (flavorChoice) {
            case 4: flavor = "Ginger Ale"; break;
            case 5: flavor = "Grapefruit Citrus"; break;
            case 6: flavor = "Lemon Twist"; break;
            case 7: flavor = "Coconut Pineapple"; break;
            case 8: flavor = "Peach Nectarine"; break;
            case 9: flavor = "Fruit Punch"; break;
            case 10: flavor = "Original"; break;
            case 11: flavor = "Wild Cherry"; break;
            case 12: flavor = "Lime"; break;
        }

        System.out.println("Select a size:");
        System.out.println("1) Large ($0.75)");
        System.out.println("2) Medium ($0.50)");
        System.out.println("3) Small ($0.25)");

        String size = "";
        int sizeChoice = scanner.nextInt();
        scanner.nextLine();  // Consume the newline
        switch (sizeChoice) {
            case 1: size = "Large"; break;
            case 2: size = "Medium"; break;
            case 3: size = "Small"; break;
        }

        order.addDrink(new Sides.Drink(brand, flavor, size));
    }

    private static void addChips(Scanner scanner, Order order) {
        System.out.println("Select a chip brand:");
        System.out.println("1) Vitner's");
        System.out.println("2) Sun Chips");
        System.out.println("3) Clancy's Kettle");

        int chipChoice = scanner.nextInt();
        scanner.nextLine();  // Consume the newline

        String brand = "";
        String flavor = "";
        switch (chipChoice) {
            case 1: brand = "Vitner's"; break;
            case 2: brand = "Sun Chips"; break;
            case 3: brand = "Clancy's Kettle"; break;
        }

        System.out.println("Select a flavor:");
        if (brand.equals("Vitner's")) {
            System.out.println("1) Hot Crunchy Curls");
            System.out.println("2) Hot Cheese & Lime");
            System.out.println("3) Extra Cheesy");
        } else if (brand.equals("Sun Chips")) {
            System.out.println("4) Original");
            System.out.println("5) French Onion");
            System.out.println("6) Harvest Cheddar");
        } else if (brand.equals("Clancy's Kettle")) {
            System.out.println("7) Jalapeno");
            System.out.println("8) Mesquite Barbecue");
            System.out.println("9) Sea Salt and Vinegar");
        }

        int flavorChoice = scanner.nextInt();
        scanner.nextLine();  // Consume the newline

        switch (flavorChoice) {
            case 1: flavor = "Hot Crunchy Curls"; break;
            case 2: flavor = "Hot Cheese & Lime"; break;
            case 3: flavor = "Extra Cheesy"; break;
            case 4: flavor = "Original"; break;
            case 5: flavor = "French Onion"; break;
            case 6: flavor = "Harvest Cheddar"; break;
            case 7: flavor = "Jalapeno"; break;
            case 8: flavor = "Mesquite Barbecue"; break;
            case 9: flavor = "Sea Salt and Vinegar"; break;
        }

        order.addChips(new Sides.Chips(brand, flavor));
    }

    private static void addSauces(Scanner scanner, Order order) {
        System.out.println("Would you like any sauce? (yes or no)");
        String sauceChoice = scanner.nextLine();

        if (sauceChoice.equalsIgnoreCase("yes")) {
            System.out.println("Select sauces:");
            System.out.println("1) BBQ ($0.15)");
            System.out.println("2) Ranch ($0.15)");
            System.out.println("3) Mayo ($0.15)");
            int sauce = scanner.nextInt();
            scanner.nextLine();  // Consume the newline
            switch (sauce) {
                case 1: order.addSauce("BBQ"); break;
                case 2: order.addSauce("Ranch"); break;
                case 3: order.addSauce("Mayo"); break;
            }
        }
    }

    // Checkout function - display order and total
    private static void checkout(Scanner scanner, Order order) {
        System.out.println("Order details:");
        System.out.println(order);
        System.out.println("Total cost: $" + order.getTotalCost());

        System.out.println("1) Confirm and checkout");
        System.out.println("0) Cancel order");

        int choice = scanner.nextInt();
        scanner.nextLine();  // Consume the newline
        if (choice == 1) {
            System.out.println("Order confirmed! Generating receipt...");
            saveReceipt(order);
        } else {
            System.out.println("Order cancelled.");
        }
    }}