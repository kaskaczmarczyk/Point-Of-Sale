package com.pos;

import com.pos.devices.BarCodeScanner;
import com.pos.devices.LcdDisplay;
import com.pos.devices.Printer;
import com.pos.domain.ProductsDataBase;
import com.pos.domain.Receipt;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Printer printer = new Printer();
        LcdDisplay lcdDisplay = new LcdDisplay();
        Receipt receipt = new Receipt();
        ProductsDataBase productsDataBase = new ProductsDataBase();
        PointOfSale pointOfSale = new PointOfSale(lcdDisplay, printer, productsDataBase, receipt);
        BarCodeScanner barCodeScanner = new BarCodeScanner();

        while (true) {
            System.out.println("Enter the bar code or press exit.");
            Scanner input = new Scanner(System.in);
            String inputBarCode = input.nextLine();

            String regex = "\\d+";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(inputBarCode);

            if (inputBarCode.equals("exit")) {
                pointOfSale.getPrinter().printIfExit(receipt);
                break;
            }
            if (matcher.matches()) {
                System.out.println(barCodeScanner.scanBarCode(pointOfSale.getProductsDataBase().returnProductWithGivenBarCode(inputBarCode, pointOfSale), pointOfSale));
                if (pointOfSale.getProductsDataBase().returnProductWithGivenBarCode(inputBarCode, pointOfSale) != null) {
                    pointOfSale.getReceipt().addProduct(pointOfSale.getProductsDataBase().returnProductWithGivenBarCode(inputBarCode, pointOfSale));
                }
            }
        }
    }
}
