package com.vendingmachine;

public class Beverage extends Product {

    private boolean carbonated;
    private boolean containsSugar;
    private boolean containsCaffeine;

    public Beverage(int id, String name, int price, int quantity, boolean carbonated, boolean containsSugar, boolean containsCaffeine) {
        super(id, name, price, quantity);
        this.carbonated = carbonated;
        this.containsSugar = containsSugar;
        this.containsCaffeine = containsCaffeine;
    }
    public boolean isCarbonated(){
        return carbonated;
    }

    @Override
    public String getDescription() {
        return "Beverage: " + getName() +
                (carbonated ? " (carbonated)" : " (still)") +
                " | Sugar: " + (containsSugar ? "yes" : "no") +
                " | Caffeine: " + (containsCaffeine ? "yes" : "no");
    }
}
