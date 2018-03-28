package com.pos.domain;

import com.pos.PointOfSale;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.hamcrest.CoreMatchers.*;


public class ProductsDataBaseTest {

    private static final String CODE_EXIST = "777";
    private static final String CODE_NOT_EXIST = "";
    private static final String CODE_NULL= null;
    private static final BarCode BARCODE_EXIST = new BarCode(CODE_EXIST);
    private static final BarCode BARCODE_NOT_EXIST = new BarCode(CODE_NOT_EXIST);
    private static final BarCode BARCODE_NULL = new BarCode(CODE_NULL);
    private static final Product PRODUCT_EXIST = new Product(9, "zeszyt", BARCODE_EXIST, 8.20);
    private static final Product PRODUCT_NOT_EXIST = new Product(10, "linijka", BARCODE_NOT_EXIST, 4.50);
    private static final Product PRODUCT_NULL = new Product(11, "mazak", BARCODE_NULL, 3.30);


    @Test
    public void shouldReturnProductWithGivenBarCode() {
        //given
        ProductsDataBase productsDataBase = mock(ProductsDataBase.class);
        PointOfSale pointOfSale = mock(PointOfSale.class);
        //when
        when(productsDataBase.returnProductWithGivenBarCode(CODE_EXIST, pointOfSale)).thenReturn(new Product(9, "zeszyt", BARCODE_EXIST, 8.20));
        Product productExist = productsDataBase.returnProductWithGivenBarCode(CODE_EXIST, pointOfSale);

        when(productsDataBase.returnProductWithGivenBarCode(CODE_NOT_EXIST, pointOfSale)).thenReturn(new Product(10, "linijka", BARCODE_NOT_EXIST, 4.50));
        Product productNotExist = productsDataBase.returnProductWithGivenBarCode(CODE_NOT_EXIST, pointOfSale);

        when(productsDataBase.returnProductWithGivenBarCode(CODE_NULL, pointOfSale)).thenReturn(new Product(11, "mazak", BARCODE_NULL, 3.30));
        Product productNull = productsDataBase.returnProductWithGivenBarCode(CODE_NULL, pointOfSale);

        //then
        assertThat(productExist.getProductBarCode().getCode(), equalTo(PRODUCT_EXIST.getProductBarCode().getCode()));
        assertThat(productNotExist.getProductBarCode().getCode(), equalTo(PRODUCT_NOT_EXIST.getProductBarCode().getCode()));
        assertThat(productNull.getProductBarCode().getCode(), equalTo(PRODUCT_NULL.getProductBarCode().getCode()));
    }
}