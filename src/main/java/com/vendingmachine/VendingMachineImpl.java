package com.vendingmachine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VendingMachineImpl implements IVendingMachine {

// Allowed coins for this vending machine
    private final List<Integer> validCoins = Arrays.asList(1, 2, 5, 10, 20, 50);

    private int balance = 0;
    private List<Product> products = new ArrayList<>();

    // Constructor

    public VendingMachineImpl(List<Product> products) {
        this.products = products;
    }

    @Override
    public boolean insertCoin(int coin) {
        if (validCoins.contains(coin)) {
            balance += coin;
            return true;
        }
        return false;
    }

    @Override
    public int getBalance() {
        return balance;
    }

    @Override
    public Product purchaseProduct(int productId) {
        for (Product p : products) {
            if (p.getId() == productId) {

                // Check stock
                if (p.getQuantity() <= 0) {
                    return null;
                }

                // check balance
                if (balance < p.getPrice()) {
                    return null;
                }

                // update stock and balance
                p.setQuantity(p.getQuantity() - 1);
                balance -= p.getPrice();

                return p;
            }

        }

        return null;
    }

    @Override
    public int returnChange() {
        int change = balance;
        balance = 0;
        return change;
    }

    @Override
    public List<Product> getProducts(){
        return products;
    }
}


