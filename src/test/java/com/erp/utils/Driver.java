package com.erp.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Driver {
    private static AppiumDriver<MobileElement> driver;
    private static URL url;

    private Driver() {
    }

    public static AppiumDriver<MobileElement> getDriver() throws MalformedURLException, InterruptedException {
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
                    desiredCapabilities2.setCapability("appPackage", "com.swaglabsmobileapp");
                    desiredCapabilities2.setCapability("appActivity", "com.swaglabsmobileapp.SplashActivity");
                    try {
                        url = new URL("http://localhost:4723/wd/hub");
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                    driver = new AndroidDriver<>(url, desiredCapabilities2);
                    break;


                case "remote-android-swaglab":
                    // we get following capabilities setup from saucelab configurator, we change some lines according to our test need, and we need to add app location
                    MutableCapabilities capsAndroid = new MutableCapabilities();
                    capsAndroid.setCapability("platformName", "Android");
                    capsAndroid.setCapability("appium:deviceName", "Samsung.*");
                    capsAndroid.setCapability("appium:deviceOrientation", "portrait");
                    capsAndroid.setCapability("appium:automationName", "UiAutomator2");

                    capsAndroid.setCapability(MobileCapabilityType.APP, "https://github.com/saucelabs/sample-app-mobile/releases/download/2.7.1/Android.SauceLabs.Mobile.Sample.app.2.7.1.apk");
                    capsAndroid.setCapability("appPackage", "com.swaglabsmobileapp");
                    capsAndroid.setCapability("appActivity", "com.swaglabsmobileapp.SplashActivity");
                    MutableCapabilities sauceOptions = new MutableCapabilities();
                    sauceOptions.setCapability("name", "swaglab test");
                    capsAndroid.setCapability("sauce:options", sauceOptions);

                    try {
                        url = new URL("https://oauth-taylor.erp.andres-bce19:9afc967b-511e-4572-b204-d61f748ec680@ondemand.us-west-1.saucelabs.com:443/wd/hub");
                    } catch (MalformedURLException e) {
                        throw new RuntimeException(e);
                    }
                    driver = new AndroidDriver(url, capsAndroid);
                    break;

                case "remote-iphone-swaglab":
                    MutableCapabilities capsIphone = new MutableCapabilities();
                    capsIphone.setCapability("platformName", "iOS");
                    capsIphone.setCapability("appium:deviceName", "iPhone.*");
                   // capsIphone.setCapability("appium:deviceName", "iPhone Simulator");
                   // capsIphone.setCapability("appium:platformVersion", "16.2");
                    capsIphone.setCapability("appium:deviceOrientation", "portrait");
                    capsIphone.setCapability("appium:automationName", "XCUITest");
                    capsIphone.setCapability(MobileCapabilityType.APP, "https://github.com/saucelabs/sample-app-mobile/releases/download/2.7.1/iOS.RealDevice.SauceLabs.Mobile.Sample.app.2.7.1.ipa");
                    MutableCapabilities sauceOptionsIOS = new MutableCapabilities();
                    sauceOptionsIOS.setCapability("name", "swaglab test Iphone");
                    capsIphone.setCapability("sauce:options", sauceOptionsIOS);
                    try {
                         url = new URL("https://oauth-taylor.erp.andres-bce19:9afc967b-511e-4572-b204-d61f748ec680@ondemand.us-west-1.saucelabs.com:443/wd/hub");

                    } catch (MalformedURLException e) {
                        throw new RuntimeException(e);
                    }

                    driver = new IOSDriver(url, capsIphone);
                    break;

                case "remote-android-swaglab-systemProp":
                    MutableCapabilities capsAndroidSYS = new MutableCapabilities();
                    capsAndroidSYS.setCapability("platformName", "Android");
                    capsAndroidSYS.setCapability("appium:deviceName", "Samsung.*");
                    capsAndroidSYS.setCapability("appium:deviceOrientation", "portrait");
                    capsAndroidSYS.setCapability("appium:automationName", "UiAutomator2");
                    capsAndroidSYS.setCapability(MobileCapabilityType.APP,"https://github.com/saucelabs/sample-app-mobile/releases/download/2.7.1/Android.SauceLabs.Mobile.Sample.app.2.7.1.apk");
                    capsAndroidSYS.setCapability("appPackage","com.swaglabsmobileapp");
                    capsAndroidSYS.setCapability("appActivity","com.swaglabsmobileapp.SplashActivity");
                    MutableCapabilities sauceOptionsSYS = new MutableCapabilities();
                    sauceOptionsSYS.setCapability("name", "swaglab test");
                    sauceOptionsSYS.setCapability("username",System.getenv("SAUCE_USERNAME"));
                    sauceOptionsSYS.setCapability("accessKey",System.getenv("SAUCE_ACCESS_KEY"));
                    capsAndroidSYS.setCapability("sauce:options", sauceOptionsSYS);

                    try {
                        url = new URL("https://ondemand.us-west-1.saucelabs.com/wd/hub");   // either US or EU central hub
                        /*
                    private String SAUCE_EU_URL = "https://ondemand.eu-central-1.saucelabs.com/wd/hub";
                    private String SAUCE_US_URL = "https://ondemand.us-west-1.saucelabs.com/wd/hub";
                         */
                    } catch (MalformedURLException e) {
                        throw new RuntimeException(e);
                    }
                    driver = new AndroidDriver(url, capsAndroidSYS);
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
