package com.erp.tests;

import com.erp.testbase.WebTestBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class EtsyAppTest extends WebTestBase {
    AppiumDriver<MobileElement> driver;

    @Test
    public void etsyTest() throws MalformedURLException, InterruptedException {
        DesiredCapabilities caps = new DesiredCapabilities();
        // Below lines are related to device settings
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 3.2");
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        // we need to do some settings related to APP under test
        caps.setCapability(MobileCapabilityType.APP,"https://cybertek-appium.s3.amazonaws.com/etsy.apk");
        // app package and main activity of the APP should be defined
       caps.setCapability("appPackage","com.etsy.android");
        caps.setCapability("appActivity","com.etsy.android.ui.user.auth.SignInActivity");

        URL url = new URL("http://localhost:4723/wd/hub");
        AppiumDriver<MobileElement> driver = new AndroidDriver<MobileElement>(url,caps);

        // Test the login functionality of ETSY native APP
        // click start button
        driver.findElement(By.id("com.etsy.android:id/btn_sign_in_dialog")).click();
        Thread.sleep(2000);
        // send email information
        driver.findElement(By.id("com.etsy.android:id/clg_text_input")).sendKeys("areatha@uspeakw.com");
        Thread.sleep(3000);


        //click on continue button: when you try to click on this element is behind, to lower the keyboard
        driver.hideKeyboard();



        Thread.sleep(3000);
        driver.findElement(By.id("com.etsy.android:id/sign_in_button_email")).click();
        Thread.sleep(2000);
        // get text of the username information
        //System.out.println(driver.findElement(By.id("join-neu-overlay-title")).getText());
        Thread.sleep(2000);

        System.out.println(driver.getDeviceTime());


        // Get device screen dimensions
        Dimension size = driver.manage().window().getSize();
        int width = size.getWidth();
        int height = size.getHeight();

        // Calculate swipe coordinates
        int start_x = (int) (width * 0.8);
        int start_y = height / 2;
        int end_x = (int) (width * 0.2);
        int end_y = height / 2;

        // Perform swipe right
        TouchAction swipeRight = new TouchAction(driver);
        swipeRight.press(PointOption.point(start_x, start_y))
                .moveTo(PointOption.point(end_x, end_y))
                .release()
                .perform();

        driver.closeApp();


    }
}
