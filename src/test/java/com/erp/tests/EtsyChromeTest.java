package com.erp.tests;

import com.erp.testbase.WebTestBase;
import com.erp.utils.ConfigurationReader;
import com.erp.utils.Wait;
import io.appium.java_client.PerformsTouchActions;
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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class EtsyChromeTest extends WebTestBase {


    @Test
    public void etsySearchTest() throws MalformedURLException, InterruptedException {

        driver.get("https://www.etsy.com");
        WebElement searchField = driver.findElement(By.name("search_query"));
        searchField.sendKeys("Colorado flag" + Keys.ENTER);
        WebElement results = driver.findElement(By.xpath("//span[contains(text(),'results,')]"));
        System.out.println("There are :" + results.getText() + " for Colorado flags on etsy");





    }

    @Test
    public void logintest() throws InterruptedException, MalformedURLException {

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
        int start_y = (int) (height * 0.3);
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
