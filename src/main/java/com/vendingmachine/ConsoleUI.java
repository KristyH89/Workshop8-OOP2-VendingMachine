package com.vendingmachine;

import java.util.Scanner;

public class ConsoleUI {
    private IVendingMachine vendingMachine;
    private Scanner scanner = new Scanner(System.in);

    public ConsoleUI(IVendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    // Starts the console menu loop
    public void start() {
        boolean running = true;

        while (running) {
            printMenu();
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> showProducts();
                case 2 -> insertCoin();
                case 3 -> purchaseProduct();
                case 4 -> returnChange();
                case 5 -> {
                    System.out.println("Thank you for using the Vending Machine, have a nice day!");
                    running = false;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private void printMenu() {
        System.out.println("\n--- Vending Machine ---");
        System.out.println("1. View products");
        System.out.println("2. Insert coin");
        System.out.println("3. Purchase product");
        System.out.println("4. Return change");
        System.out.println("5. Exit");
        System.out.print("Choose an option: ");
    }

    private void showProducts() {
        for (Product p : vendingMachine.getProducts()) {
            System.out.println(p.getId() + ": " + p.getDescription() +
                    " | Price: " + p.getPrice() +
                    " | Stock: " + p.getQuantity());
        }
    }

    private void insertCoin() {
        System.out.print("Insert coin: ");
        int coin = scanner.nextInt();

        boolean success = vendingMachine.insertCoin(coin);
        if (!success) {
            System.out.println("Invalid coin. Accepted coins are: 1, 2, 5, 10, 20, 50"); // // comment in English
        } else {
            System.out.println("Current balance: " + vendingMachine.getBalance());
        }
    }

    private void purchaseProduct() {
        System.out.print("Enter product ID: ");
        int id = scanner.nextInt();
        Product p = vendingMachine.purchaseProduct(id);

        if (p != null) {
            System.out.println("You purchased: " + p.getName());
            System.out.println("Remaining balance: " + vendingMachine.getBalance());
        } else {
            System.out.println("Purchase failed. Either insufficient balance or out of stock."); // // comment in English
        }
    }

    private void returnChange() {
        int change = vendingMachine.returnChange();
        System.out.println("Returned change: " + change);
    }
}