package com.pos.devices;

import com.pos.domain.Product;
import com.pos.domain.Receipt;
import com.pos.domain.Statements;

public class LcdDisplay {

    public String printIfProductIsInDB(Product product) {
        return (product.getProductName() + "\t" + product.getProductPrice());
    }

    public String printIfProductNotInDB() {
        return Statements.PRODUCTNOTFOUND;
    }

    public String printIfEmptyCodeScanned() {
        return Statements.INVALIDBARCODE;
    }

    public void printTotalSumToBePaid(Receipt receipt) {
        System.out.println("Total sum to be paid for all item: " + receipt.getTotalSum());
    }
}
