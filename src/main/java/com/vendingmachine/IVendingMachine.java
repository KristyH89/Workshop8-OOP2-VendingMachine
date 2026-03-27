package com.vendingmachine;
import java.util.List;

public interface IVendingMachine {

    // Insert coin
   boolean insertCoin(int coin);
    // true means accepted coin, false = rejected.


    // return balance

    int getBalance();

    // buy product and return product
    Product purchaseProduct(int productId);

    // Return all remaining balance and resets it to zero
    int returnChange();

    // Returns a list of all products in the vending machine
    List<Product> getProducts();
}
