package com.erp.tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.jupiter.api.*;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorOperationsTest {
    AppiumDriver<MobileElement> driver;

    @BeforeEach
    public void setup() throws MalformedURLException, InterruptedException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 3.2");
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        caps.setCapability(MobileCapabilityType.APP, "https://cybertek-appium.s3.amazonaws.com/calculator.apk");
        URL url = new URL("http://localhost:4723/wd/hub");
        driver = new AppiumDriver<>(url, caps);
        Thread.sleep(4);

    }

    @Test
    public void operators() {
        MobileElement four = driver.findElement(MobileBy.id("com.google.android.calculator:id/digit_4"));
        four.click();
        MobileElement add = driver.findElement(MobileBy.AccessibilityId("plus"));
        add.click();
        four.click();
        MobileElement equals = driver.findElement(MobileBy.AccessibilityId("equals"));
        equals.click();
        MobileElement result = driver.findElement(MobileBy.id("com.google.android.calculator:id/result_final"));
        int expected = 8;
        String actResult = result.getText();
        assertEquals(expected, Integer.parseInt(actResult));
        System.out.println(actResult);


    }

    @Test
    public void divide() {
        MobileElement divide=driver.findElement(MobileBy.AccessibilityId("divide"));
        MobileElement one=driver.findElement(MobileBy.id("com.google.android.calculator:id/digit_1"));
        one.click();
        MobileElement five=driver.findElement(MobileBy.id("com.google.android.calculator:id/digit_5"));
        five.click();
        divide.click();
        five.click();
        MobileElement equals=driver.findElement(MobileBy.AccessibilityId("equals"));
        equals.click();

        MobileElement result = driver.findElement(MobileBy.id("com.google.android.calculator:id/result_final"));
        int expected = 3;
        String actResult = result.getText();
        assertEquals(expected, Integer.parseInt(actResult));
        System.out.println(actResult);

    }

    @Test
    public void multiply() {

        MobileElement times=driver.findElement(MobileBy.AccessibilityId("multiply"));
        MobileElement two=driver.findElement(MobileBy.id("com.google.android.calculator:id/digit_2"));
        MobileElement seven=driver.findElement(MobileBy.id("com.google.android.calculator:id/digit_7"));
        seven.click();
        times.click();
        two.click();


        MobileElement equals=driver.findElement(MobileBy.AccessibilityId("equals"));
        equals.click();

        MobileElement result = driver.findElement(MobileBy.id("com.google.android.calculator:id/result_final"));
        int expected = 14;
        String actResult = result.getText();
        assertEquals(expected, Integer.parseInt(actResult));
        System.out.println(actResult);
    }

    @AfterEach
    public void destroy() {
        driver.closeApp();
    }
}
