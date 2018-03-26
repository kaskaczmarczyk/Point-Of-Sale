package com.pos;

import com.pos.devices.LcdDisplay;
import com.pos.devices.Printer;
import com.pos.domain.Receipt;
import com.pos.domain.ProductsDataBase;

public class PointOfSale {

    private LcdDisplay lcdDisplay;
    private Printer printer;
    private ProductsDataBase productsDataBase;
    private Receipt receipt;

    public PointOfSale(LcdDisplay lcdDisplay, Printer printer, ProductsDataBase productsDataBase, Receipt receipt) {
        this.lcdDisplay = lcdDisplay;
        this.printer = printer;
        this.productsDataBase = productsDataBase;
        this.receipt = receipt;
    }

    public LcdDisplay getLcdDisplay() {
        return lcdDisplay;
    }

    public Printer getPrinter() {
        return printer;
    }

    public ProductsDataBase getProductsDataBase() {
        return productsDataBase;
    }

    public Receipt getReceipt() {
        return receipt;
    }
}
