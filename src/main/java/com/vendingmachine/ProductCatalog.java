package com.vendingmachine;
import java.util.List;
import java.util.ArrayList;

public class ProductCatalog {

    public static List<Product> getDefaultProducts() {
        return new ArrayList<>(List.of(
                //Beverages

                new Beverage(100, "7UP", 15, 5),
                new Beverage(101, "Cola", 15, 6),
                new Beverage(103, "Fanta", 15, 4),
                new Beverage(104, "Water", 10, 10),

                // Snacks
                new Snack(200, "Candy bag", 12, 6),
                new Snack(201, "Chips", 20, 5),
                new Snack(202, "Cookie", 10, 8),
                new Snack(203, "Nuts", 25, 4),

                // Fruit
                new Fruit(300, "Apple", 10, 10),
                new Fruit(301, "Banana", 8, 11),
                new Fruit(302, "Kiwi", 9, 7),
                new Fruit(303, "Mandarin", 6, 13)
        ));
    }
}
