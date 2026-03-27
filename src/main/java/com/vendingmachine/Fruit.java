package com.vendingmachine;

public class Fruit extends Product {

    private boolean hasPeel;

    public Fruit (int id, String name, int price, int quantity, boolean hasPeel) {
        super(id, name, price, quantity);
        this.hasPeel = hasPeel;
    }

    public boolean hasPeel() {
        return hasPeel;
    }

    @Override
    public String getDescription() {
        return "Fruit: " + getName() + (hasPeel ? " (peel)" : " (no peel)");
    }
}
