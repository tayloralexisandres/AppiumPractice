package com.erp.tests;

import com.erp.testbase.AndroidDriverTestBase;
import com.erp.utils.ConfigurationReader;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class EtsyChromeSwipeDownTest extends AndroidDriverTestBase {



    @Test
    void etsy() throws MalformedURLException, InterruptedException {


        driver.get("https://www.etsy.com");
        // set variables
        String email = ConfigurationReader.getProperty("email");
        String password = ConfigurationReader.getProperty("password");


        // I tried to use try/catch, did not work, used Thread sleep and throws

        WebElement signIn = driver.findElement(By.xpath("//a[@href='https://www.etsy.com/signin/router?ref=hdr-signin&from_action=signin-header&from_page=https%3A%2F%2Fwww.etsy.com%2F']"));
        signIn.click();

        WebElement userName = driver.findElement(By.name("email"));
        userName.sendKeys(email + Keys.ENTER);

        Thread.sleep(4000);

        WebElement pass = driver.findElement(By.name("password"));
        pass.sendKeys(password + Keys.ENTER);


        // the result will be reset password-

        Thread.sleep(4000);

        WebElement resetPassword = driver.findElement(By.xpath("//div[@class='wt-mt-xs-1 wt-mb-xs-2']//p"));
        String actualResult = resetPassword.getText();
        String expectedResult = "Reset your password";
        Assertions.assertEquals(expectedResult, actualResult);


        Thread.sleep(2000);

        System.out.println(actualResult);



        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        int width = ((Long) jsExecutor.executeScript("return window.innerWidth || document.documentElement.clientWidth || document.body.clientWidth;")).intValue();
        int height = ((Long) jsExecutor.executeScript("return window.innerHeight || document.documentElement.clientHeight || document.body.clientHeight;")).intValue();

        // Calculate swipe coordinates
        int start_x = width / 2;
        int start_y = (int) (height * 0.0);
        int end_x = width / 2;
        int end_y = (int) (height * 0.8);

        // Perform swipe down
        TouchAction swipeDown = new TouchAction((AndroidDriver)driver);
        swipeDown.press(PointOption.point(start_x, start_y))
                .moveTo(PointOption.point(end_x, end_y))
                .release()
                .perform();





}
}
