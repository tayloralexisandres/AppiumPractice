package com.erp.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;

public class Driver {
    private static AppiumDriver<MobileElement> driver;
    private static URL url;

    private Driver() {
    }

    public static AppiumDriver<MobileElement> getDriver() {
        String platform = ConfigurationReader.getProperty("platform");
        if (Objects.isNull(driver)) {
            switch (platform) {
                case "android":
                    DesiredCapabilities caps = new DesiredCapabilities();
                    caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 3");
                    caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
                    caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
                    caps.setCapability(MobileCapabilityType.APP, "https://cybertek-appium.s3.amazonaws.com/calculator.apk");

                    try {
                        url = new URL("http://localhost:4723/wd/hub");
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }

                    driver = new AppiumDriver<>(url, caps);
                    break;
                case "android-remote":
                    DesiredCapabilities capabilities = new DesiredCapabilities();

                    //set your access credentials
                    capabilities.setCapability("browserstack.user", "testuser_1PhU8F");
                    capabilities.setCapability("browserstack.key", "qxU7LuK78o8BK1ki799f");
                    //set your URL of the application under test
                    capabilities.setCapability("app", "bs://e0ce6dfd61f8f7d9fd9c4fb11c746b65fd1d79f1");
                    //specify devices and os_version for testing
                    capabilities.setCapability("device", "OnePlus 8");
                    capabilities.setCapability("os_version", "10.0");
                    capabilities.setCapability("realMobile", "true");
                    // set other BrowserStack capabilities
                    capabilities.setCapability("project", "AppiumPractice");
                    capabilities.setCapability("build", "Java Android");
                    capabilities.setCapability("name", "Regression");
                    //Initialize the remote WebDriver using Browserstack remote URL
                    //and desired capabilities defined above
                    try {
                        driver = new AppiumDriver<>(new URL("http://hub.browserstack.com/wd/hub"), capabilities);
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                    break;

                case "android-sauceLabApp":
                    DesiredCapabilities desiredCapabilities2 = new DesiredCapabilities();
                    desiredCapabilities2.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
                    desiredCapabilities2.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
                    desiredCapabilities2.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
                    desiredCapabilities2.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 3");
                    // copy the absolute path of the ANDROID.SAUCE.LABS file
                    desiredCapabilities2.setCapability(MobileCapabilityType.APP, "C:\\Users\\taylo\\AppiumPractice\\Android.SauceLabs.Mobile.Sample.app.2.7.1.apk");
                    desiredCapabilities2.setCapability("appPackage","com.swaglabsmobileapp");
                    desiredCapabilities2.setCapability("appActivity","com.swaglabsmobileapp.SplashActivity");
                    try {
                        url = new URL("http://localhost:4723/wd/hub");
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                    driver = new AndroidDriver<>(url, desiredCapabilities2);
                    break;
            }


        }
        return driver;
    }

    public static void closeDriver() {
        if (Objects.nonNull(driver)) {
            driver.closeApp();
            driver = null;
        }
    }

}
