package com.pos.domain;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class ReceiptTest {

    private Receipt receipt;
    private final List<Product> products = new ArrayList<Product>();

    @Before
    public void setup() {
        receipt = new Receipt();
    }

    @Test
    public void shouldTotalSumForNewReceiptIsZero(){
        assertEquals(new Double(0.0), receipt.getTotalSum());
    }

    @Test
    public void shouldAddProduct() {
        //given
        Product product = mock(Product.class);
        //when
        receipt.addProduct(product);
        products.add(product);
        //then
        assertEquals(products.size(), receipt.getAllProduct().size());
    }

    @Test
    public void shouldTotalSumForNotEmptyReceiptIsNotZero() {
        //given
        Product product1 = new Product (1, "przewodnik", new BarCode("556"), 15.80);
        Product product2 = new Product (2, "kolczyki", new BarCode("49244"), 389.0);
        //when
        receipt.addProduct(product1);
        receipt.addProduct(product2);
        //then
        assertEquals(new Double(product1.getProductPrice() + product2.getProductPrice()), receipt.getTotalSum());
    }
}