package com.erp.tests;

import com.erp.testbase.WebTestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class AmazonTest extends WebTestBase {
    @Test
    public void amazon() throws InterruptedException {

        driver.get("https://www.amazon.com/");
            Thread.sleep(4000);
        WebElement signin=driver.findElement(By.cssSelector("[class=\"nav-icon nav-icon-a11y nav-sprite\"]"));
        Thread.sleep(400);
        signin.click();
        WebElement email=driver.findElement(By.xpath("//input[@id='ap_email_login']"));
        email.sendKeys("", Keys.ENTER);
       // WebElement button=driver.findElement(By.xpath("//input[@id='continue'][1]"));
        Thread.sleep(2000);
       // button.click();
        WebElement password=driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("",Keys.ENTER);
    }
}
