package com.pos.devices;

import com.pos.PointOfSale;
import com.pos.domain.Product;

public class BarCodeScanner {

    public String scanBarCode(Product product, PointOfSale pointOfSale) {
        String code;
        try {
            code = product.getProductBarCode().getCode();
        } catch (NullPointerException exc) {
            return pointOfSale.getLcdDisplay().printIfEmptyCodeScanned();
        }

        if (!code.isEmpty()) {
            return pointOfSale.getLcdDisplay().printIfProductIsInDB(product);
        } else {
            return pointOfSale.getLcdDisplay().printIfEmptyCodeScanned();
        }
    }
}
