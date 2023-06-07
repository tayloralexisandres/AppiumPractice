package com.erp.testbase;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public abstract class AndroidDriverTestBase {
    protected WebDriver driver;
    @BeforeEach
    public void init() throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities=new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"10.0");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel 3.3");
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME,"Chrome");

        URL url=new URL("http://localhost:4723/wd/hub");
        driver= new AndroidDriver<>(url,capabilities);


    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }
}


