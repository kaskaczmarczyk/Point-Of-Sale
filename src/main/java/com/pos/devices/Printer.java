package com.pos.devices;

import com.pos.domain.Product;
import com.pos.domain.Receipt;

public class Printer {

    public void printIfExit(Receipt receipt) {
        System.out.println("List of scanned products: ");
        for (Product product : receipt.getAllProduct()) {
            System.out.println(product.getProductName() + "\t" + product.getProductPrice());
        }
        System.out.println("Total sum to be paid for all item: " + receipt.getTotalSum());
    }
}
