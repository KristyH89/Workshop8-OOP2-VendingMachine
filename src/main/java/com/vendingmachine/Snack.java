package com.vendingmachine;

public class Snack extends Product {

    private int calories;
    private boolean containsNuts;
    private boolean containsGluten;

    public Snack(int id, String name, int price, int quantity, int calories, boolean containsNuts, boolean containsGluten) {
        super(id, name, price, quantity);
        this.calories = calories;
        this.containsNuts = containsNuts;
        this.containsGluten = containsGluten;
    }

    public int getCalories() {
        return calories;
    }

    @Override
    public String getDescription() {
        return "Snack: " + getName() +
                " (" + calories + " kcal)" +
                " | Nuts: " + (containsNuts ? "yes" : "no") +
                " | Gluten: " + (containsGluten ? "yes" : "no");


    }

}
