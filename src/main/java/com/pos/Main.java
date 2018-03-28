package com.pos;

import com.pos.devices.BarCodeScanner;
import com.pos.devices.LcdDisplay;
import com.pos.devices.Printer;
import com.pos.domain.Product;
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
            String inputData = input.nextLine();

            if (isBarCode(inputData)) {
                productsDataBase = pointOfSale.getProductsDataBase();
                Product product = productsDataBase.returnProductWithGivenBarCode(inputData, pointOfSale);
                System.out.println(barCodeScanner.scanBarCode(product, pointOfSale));
                if (productsDataBase.checkIfProductExist(inputData, pointOfSale)) {
                    pointOfSale.getReceipt().addProduct(product);
                }
            }
            else if (inputData.equals("exit")) {
                pointOfSale.getPrinter().printIfExit(receipt);
                break;
            }
        }
    }

    private static boolean isBarCode(String inputData) {
        String regex = "\\d+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(inputData);
        return matcher.matches();
    }
}
