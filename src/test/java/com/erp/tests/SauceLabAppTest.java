package com.erp.tests;

import com.erp.utils.Driver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.Test;

public class SauceLabAppTest {


    @Test
            public void testLogin() throws InterruptedException {
        AppiumDriver<MobileElement> driver = Driver.getDriver();

        System.out.println(driver.getDeviceTime());
Thread.sleep(4000);
        driver.findElement(MobileBy.AccessibilityId("test-Username")).sendKeys("standard_user");
        Thread.sleep(4000);
        driver.findElement(MobileBy.AccessibilityId("test-Password")).sendKeys("secret_sauce");
        Thread.sleep(4000);
        driver.findElement(MobileBy.AccessibilityId("test-LOGIN")).click();
        Thread.sleep(4000);

        // cast our driver to AndroidDriver to be able use a useful method that comes from this library
        // similate to JSE at selenium, we can use following script to scroll into view
        ((AndroidDriver)driver).findElementsByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Policy\"));");

  driver.closeApp();
    }



}
