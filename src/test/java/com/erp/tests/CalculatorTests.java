package com.erp.tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class CalculatorTests {

    @Test
    public void calculator_add() throws MalformedURLException, InterruptedException {

        //Desired Capabilities
        // launch appiumDriver
        //set URL for appium server
        //close app

        DesiredCapabilities caps = new DesiredCapabilities();
        //map structure
        //  caps.setCapability("deviceName","Pixel 3");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 3");
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        caps.setCapability(MobileCapabilityType.APP, "https://cybertek-appium.s3.amazonaws.com/calculator.apk");

        URL url = new URL("http://localhost:4723/wd/hub");

        AppiumDriver<MobileElement> driver = new AndroidDriver<MobileElement>(url, caps);

       // System.out.println(driver.getContext());
        //System.out.println(driver.getDeviceTime());
        Assertions.assertEquals("android",driver.getPlatformName());


        Thread.sleep(400);

        MobileElement clearElement=driver.findElement(MobileBy.AccessibilityId("clear"));
        System.out.println(clearElement.getText()+" : AC on the calculator");
        Assertions.assertTrue(clearElement.isDisplayed());

        driver.closeApp();




    }
}
