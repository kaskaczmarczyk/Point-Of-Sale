package com.pos.domain;

import java.util.ArrayList;
import java.util.List;

public class Receipt {

    private final List<Product> products = new ArrayList<Product>();
    private Double totalSum= 0.00;

    public void addProduct(Product product) {
        products.add(product);
        totalSum+=product.getProductPrice();
    }

    public Double getTotalSum() {
        return totalSum;
    }

    public List<Product> getAllProduct() {
        return products;
    }
}
