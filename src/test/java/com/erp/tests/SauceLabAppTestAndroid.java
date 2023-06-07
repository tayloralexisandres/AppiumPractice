package com.erp.tests;

import com.erp.utils.Driver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;

public class SauceLabAppTestAndroid {


    @Test
    public void testLogin() throws InterruptedException, MalformedURLException {

        /// make sure to change your configuration.properties file to this-platform=android-sauceLabApp
        //and create your android-sauceLapApp in Driver class
        AppiumDriver<MobileElement> driver = Driver.getDriver();

        System.out.println(driver.getDeviceTime());
       // Thread.sleep(4000);
        System.out.println(driver.getPlatformName());
        driver.findElement(MobileBy.AccessibilityId("test-Username")).sendKeys("standard_user");
       // Thread.sleep(4000);
        driver.findElement(MobileBy.AccessibilityId("test-Password")).sendKeys("secret_sauce");
        //Thread.sleep(4000);
        driver.findElement(MobileBy.AccessibilityId("test-LOGIN")).click();
       // Thread.sleep(4000);



        // cast our driver to AndroidDriver to be able use a useful method that comes from this library
        // similate to JSE at selenium, we can use following script to scroll into view
       ((AndroidDriver) driver).findElementsByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Policy\"));");

        driver.closeApp();

        driver.quit();
    }


}
