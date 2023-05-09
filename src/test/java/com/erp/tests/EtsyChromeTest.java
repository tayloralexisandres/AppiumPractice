package com.erp.tests;

import com.erp.testbase.WebTestBase;
import com.erp.utils.ConfigurationReader;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;

public class EtsyChromeTest extends WebTestBase {


    @Test
    public void etsySearchTest() throws MalformedURLException, InterruptedException {

        driver.get("https://www.etsy.com");
        // if this doesn't work- your chromium is set
        // to version 74 and needs to set to version 111 so
        // update your chromedriver file

        // for windows - under target- chromedriver.exe- drag and drop into project level
        //mac no idea


        WebElement searchField = driver.findElement(By.name("search_query"));
        searchField.sendKeys("wooden spoon" + Keys.ENTER);
        WebElement results = driver.findElement(By.xpath("//span[contains(text(),'results,')]"));
        System.out.println(results.getText());

//email-name
    }

    @Test
    public void logintest() throws InterruptedException {

        driver.get("https://www.etsy.com");

        String email = ConfigurationReader.getProperty("email");
        String password = ConfigurationReader.getProperty("password");


        WebElement signIn = driver.findElement(By.xpath("//a[@href='https://www.etsy.com/signin/router?ref=hdr-signin&from_action=signin-header&from_page=https%3A%2F%2Fwww.etsy.com%2F']"));
        signIn.click();

        WebElement userName = driver.findElement(By.name("email"));
        userName.sendKeys(email + Keys.ENTER);
        Thread.sleep(6000);
        WebElement pass = driver.findElement(By.name("password"));
        pass.sendKeys(password + Keys.ENTER);
        WebElement button = driver.findElement(By.name("submit_attempt"));
        Thread.sleep(6000);
        // button.click();

        Thread.sleep(6000);
    }


}
