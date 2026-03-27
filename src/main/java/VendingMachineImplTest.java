package com.vendingmachine;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VendingMachineImplTest {

    private IVendingMachine vm;
    private Product cola;
    private Product chips;

    @BeforeEach
    void setUp() {
        // create a small test product list
        cola = new Beverage(1, "Cola", 15, 3);
        chips = new Snack(2, "Chips", 20, 2);

        vm = new VendingMachineImpl(List.of(cola, chips));
    }

    // ===================================================
    //  Testcase 1 - Insert Valid Coin
    // ===================================================
    @Test
    void testInsertValidCoin() {
        boolean result = vm.insertCoin(10);

        assertTrue(result, "Valid coin should return true");
        assertEquals(10, vm.getBalance(), "Balance should increase by 10");
    }

    // ===================================================
    //  Testcase 2 - Reject Invalid Coin
    // ===================================================

    @Test
    void testInsertInvalidCoin() {
        boolean result = vm.insertCoin(7);

        assertFalse(result, "Invalid coin should return false");
        assertEquals(0, vm.getBalance(), "Balance should remain 0");
    }

    // ===================================================
    //  Testcase 3 - Purchase Product Succesfully
    // ===================================================
    @Test
    void testPurchaseProductSuccess() {
        vm.insertCoin(20);

        Product purchased = vm.purchaseProduct(2);
        assertEquals("Chips", purchased.getName());
        assertEquals(0, vm.getBalance(), "Balance should be reduced to 0");
        assertEquals(1, chips.getQuantity(), "Quantity should decrease by 1");
    }

    // =======================================================
    //  Testcase 4 - Purchase Fails (Insufficient Balance)
    // =======================================================
    @Test
    void testPurchaseInsufficientBalance() {
        vm.insertCoin(10);

        Product purchased = vm.purchaseProduct(2);

        assertNull(purchased, "Purchase should fail");
        assertEquals(10, vm.getBalance(), "Balance should remain unchanged");
        assertEquals(2, chips.getQuantity(), "Quantity should remain unchanged");
    }

    // =======================================================
    //  Testcase 5 - Purchase Fails (Out of Stock)
    // ========================================================
    @Test
    void testPurchaseOutOfStock() {
        chips.setQuantity(0);
        vm.insertCoin(20);

        Product purchased = vm.purchaseProduct(2);

        assertNull(purchased, "Purchase should fail due to no stock");
        assertEquals(20, vm.getBalance(), "Balance should remain unchanged");
        assertEquals(0, chips.getQuantity(), "QUantity should remain 0");
    }

    // =======================================================
    //  Testcase 6 - Return Change Resets Balance
    // ========================================================
    @Test
    void testReturnChange() {
        vm.insertCoin(20);
        vm.insertCoin(10);

        int change = vm.returnChange();

        assertEquals(30, change, "Return change should equal balance");
        assertEquals(0, vm.getBalance(), "Balance should reset to 0");
    }

    // =======================================================
    //  Testcase 7 - Get Products Returns All Items
    // ========================================================
    @Test
    void testGetProducts() {
        List<Product> products = vm.getProducts();

        assertEquals(2, products.size(), "Should return 2 products");
        assertTrue(products.contains(cola));
        assertTrue(products.contains(chips));
    }
}