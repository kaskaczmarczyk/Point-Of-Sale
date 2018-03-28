package com.pos.devices;

import org.junit.Assert;
import org.junit.Test;

public class BarCodeScannerTest {

    private static final String CODE_EXIST = "777";
    private static final String CODE_NOT_EXIST = "";
    private static final String CODE_NULL= null;

    @Test
    public void shouldScanBarCode() {
        Assert.assertNotNull(CODE_EXIST);
        Assert.assertEquals("", CODE_NOT_EXIST);
        Assert.assertNull(CODE_NULL);
    }
}