package com.erp.tests;

import com.erp.pages.CalculatorPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorPOMTest {

    CalculatorPage page=new CalculatorPage();

    @Test
    public void pom_test(){

        // make sure to pass your chromedriver absolute path into your appium server
        // under advanced to start session for this test



        page.clickDigit(2);
        page.multiply.click();
        page.clickDigit(3);
        page.equals.click();
        int actual= Integer.parseInt(page.result.getText());
        int expected=6;
        Assertions.assertEquals(expected,actual);
        System.out.println("int a * int b = "+actual);
        page.clear.click();
        page.clickDigit(9);
        page.subtract.click();
        page.clickDigit(6);
        page.equals.click();
        int actualsub=Integer.parseInt(page.result.getText());
        int expectedsb=3;
        Assertions.assertEquals(expected,actual);
        System.out.println("int a - int b = "+actualsub);


    }
}
