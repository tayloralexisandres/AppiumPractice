package com.erp.tests;

import com.saucelabs.saucebindings.junit5.SauceBaseTest;
import io.appium.java_client.MobileBy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.By;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;



public class DemoTest {

    public RemoteWebDriver driver;

    /**
     * A Test Watcher is needed to be able to get the results of a Test so that it can be sent to Sauce Labs.
     * Note that the name is never actually used
     */
    @RegisterExtension
    public SauceTestWatcher watcher = new SauceTestWatcher();

    @BeforeEach
    public void setup(TestInfo testInfo) throws MalformedURLException {
        MutableCapabilities sauceOptions = new MutableCapabilities();
        sauceOptions.setCapability("username", System.getenv("SAUCE_USERNAME"));
        sauceOptions.setCapability("access_key", System.getenv("SAUCE_ACCESS_KEY"));
        sauceOptions.setCapability("name", testInfo.getDisplayName());
        sauceOptions.setCapability("browserVersion", "latest");

        ChromeOptions options = new ChromeOptions();
        options.setCapability("sauce:options", sauceOptions);
        URL url = new URL("https://ondemand.us-west-1.saucelabs.com/wd/hub");

        driver = new RemoteWebDriver(url, options);
    }

    @DisplayName("W3C example with JUnit5")
    @Test
    public void w3cExampleWithJUnit5() throws InterruptedException {
        driver.navigate().to("https://www.saucedemo.com");
        Assertions.assertEquals("Swag Labs", driver.getTitle());
        System.out.println(driver.getTitle());

        //driver.findElement(MobileBy.AccessibilityId("test-Username")).sendKeys("standard_user");
        //        Thread.sleep(4000);
        //        driver.findElement(MobileBy.AccessibilityId("test-Password")).sendKeys("secret_sauce");
        //        Thread.sleep(4000);
        //        driver.findElement(MobileBy.AccessibilityId("test-LOGIN")).click();
        //        Thread.sleep(4000);
       // driver.findElement(By.xpath("input[@data-test='username']")).sendKeys("standard_user");
         //input[@data-test='username']
        //input[@data-test='password']
        // input[@data-test='login-button']
    }

    /**
     * Custom TestWatcher for Sauce Labs projects.
     */
   public class SauceTestWatcher implements TestWatcher {
        @Override
        public void testSuccessful(ExtensionContext context) {
            driver.executeScript("sauce:job-result=passed");
            driver.quit();
        }

        @Override
        public void testFailed(ExtensionContext context, Throwable cause) {
            driver.executeScript("sauce:job-result=failed");
            driver.quit();
        }
    }
}
