package com.vendingmachine;
import java.util.List;

public class Main {
public  static void main(String [] args) {

        List<Product> products = ProductCatalog.getDefaultProducts();
        IVendingMachine vm = new VendingMachineImpl(products);
        ConsoleUI ui = new ConsoleUI(vm);

        ui.start();

        }
    }

