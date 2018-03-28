package com.pos.domain;

public class Product {
    private int productId;
    private String productName;
    private BarCode productBarCode;
    private Double productPrice;

    public Product(int productId, String productName, BarCode productBarCode, Double productPrice) {
        this.productId = productId;
        this.productName = productName;
        this.productBarCode = productBarCode;
        this.productPrice = productPrice;
    }

    public String getProductName() {
        return productName;
    }

    public BarCode getProductBarCode() {
        return productBarCode;
    }

    public void setProductBarCode(BarCode productBarCode) {
        this.productBarCode = productBarCode;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                '}';
    }
}
