package com.vendingmachine;
import java.util.List;
import java.util.ArrayList;

public class ProductCatalog {

    public static List<Product> getDefaultProducts() {
        return new ArrayList<>(List.of(
                //Beverages

                new Beverage(100, "7UP", 15, 5, true, true, false),
                new Beverage(101, "Cola", 15, 6, true, true, true),
                new Beverage(102, "Fanta", 15, 4, true, true, false),
                new Beverage(103, "Water", 10, 10, false, false, false),
                new Beverage(104, "Cola Zero", 15, 7, true, false, true),

                // Snacks
                new Snack(200, "Candy bag", 12, 6, 300, false, true),
                new Snack(201, "Chips", 20, 5, 450, false, true),
                new Snack(202, "Cookie", 10, 8, 180, false, true),
                new Snack(203, "Nuts", 25, 4, 520,true, false),
                new Snack(204, "Brownie", 18, 5, 300, false, true),

                // Fruit
                new Fruit(300, "Apple", 10, 10, true),
                new Fruit(301, "Banana", 10, 11, true),
                new Fruit(302, "Grapes", 10, 7, false),
                new Fruit(303, "Kiwi", 5, 13, true),
                new Fruit(304, "Mandarin", 5, 13, true)
        ));
    }
}
