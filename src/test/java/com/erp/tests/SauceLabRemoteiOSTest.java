package com.erp.tests;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Test;
import org.openqa.selenium.MutableCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class SauceLabRemoteiOSTest {
    private String SAUCE_US_URL = "https://ondemand.us-west-1.saucelabs.com/wd/hub";
    private AndroidDriver driver;

    @Test
    public void test1() throws MalformedURLException {

        URL url;
        url = new URL(SAUCE_US_URL);

        /// for IPHONE

        MutableCapabilities capabilities = new MutableCapabilities();
        MutableCapabilities sauceOptions = new MutableCapabilities();

        capabilities.setCapability("platformName", "iOS");
        // for ios in sacucelabs
        capabilities.setCapability("appium:automationName", "xcuitest");
        // call this application
        capabilities.setCapability("appium:app",
                "https://github.com/saucelabs/sample-app-mobile/releases/download/2.7.1/iOS.RealDevice.SauceLabs.Mobile.Sample.app.2.7.1.ipa");

        // apply for the app activity
        capabilities.setCapability("appium:appWaitActivity","com.swaglabsmobileapp.MainActivity");

        sauceOptions.setCapability("name", "swaglab test Iphone no Driver case");
        sauceOptions.setCapability("username", System.getenv("SAUCE_USERNAME"));
        sauceOptions.setCapability("accessKey", System.getenv("SAUCE_ACCESS_KEY"));
        capabilities.setCapability("sauce:options", sauceOptions);

        driver = new AndroidDriver(url, capabilities);


       driver.findElement(MobileBy.AccessibilityId("test-Username")).sendKeys("standard_user");
        driver.findElement(MobileBy.AccessibilityId("test-Password")).sendKeys("secret_sauce");
        driver.findElement(MobileBy.AccessibilityId("test-LOGIN")).click();


        driver.closeApp();
        driver.quit();
    }

   // for android on saucelabs
    // capabilities.setCapability("appium:app","https://github.com/saucelabs/sample-app-mobile/releases/download/2.7.1/Android.SauceLabs.Mobile.Sample.app.2.7.1.apk");

}
