package com.pos.devices;

import java.math.BigDecimal;

public class Product {
    private BigDecimal productId;
    private String productNam;
    private BarCode productBarCode;
    private Double productPrice;

    public Product(BigDecimal productId, String productNam, BarCode productBarCode, Double productPrice) {
        this.productId = productId;
        this.productNam = productNam;
        this.productBarCode = productBarCode;
        this.productPrice = productPrice;
    }

    public BigDecimal getProductId() {
        return productId;
    }

    public String getProductNam() {
        return productNam;
    }

    public void setProductNam(String productNam) {
        this.productNam = productNam;
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

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }
}
