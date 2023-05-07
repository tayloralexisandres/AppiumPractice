package com.erp.utils;

public class Wait {

    private static void waitfor(int i) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
