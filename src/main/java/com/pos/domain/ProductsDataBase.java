package com.pos.domain;

import com.pos.PointOfSale;
import java.util.ArrayList;
import java.util.List;

public class ProductsDataBase {
    private List<Product> productListFromDB = new ArrayList<Product>();

    public void addProduct(Product product) {
        productListFromDB.add(product);
    }

    public Product returnProductWithGivenBarCode(String barCode, PointOfSale pointOfSale) {
        Product returnedProduct = null;
        for (Product product: pointOfSale.getProductsDataBase().productListFromDB) {
            try{
                if (product.getProductBarCode().getCode().equals(barCode)){
                    returnedProduct = product;
                    break;
                }            }
            catch (NullPointerException exc) {
                return null;
            }
        }
        return returnedProduct;
    }

    public boolean checkIfProductExist(String barCode, PointOfSale pointOfSale) {
        for (Product product: pointOfSale.getProductsDataBase().productListFromDB) {
            try {
                if (product.getProductBarCode().getCode().equals(barCode)) {
                    return true;
                }
            } catch (NullPointerException exc) {
                return false;
            }
        }
        return false;
    }
}
