package com.erp.tests;

import com.erp.testbase.WebTestBase;
import com.erp.utils.ConfigurationReader;
import com.erp.utils.Wait;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;

public class EtsyChromeTest extends WebTestBase {


    @Test
    public void etsySearchTest() throws MalformedURLException, InterruptedException {

        driver.get("https://www.etsy.com");
        WebElement searchField = driver.findElement(By.name("search_query"));
        searchField.sendKeys("wooden spoon" + Keys.ENTER);
        WebElement results = driver.findElement(By.xpath("//span[contains(text(),'results,')]"));
        System.out.println("There are :" + results.getText() + " for wooden spoons on etsy");


    }

    @Test
    public void logintest() throws InterruptedException {

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



    }


}
