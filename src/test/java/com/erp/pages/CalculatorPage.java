package com.erp.pages;

import com.erp.utils.Driver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;

public class CalculatorPage {

    public CalculatorPage() throws MalformedURLException, InterruptedException {
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getDriver()),this);
    }

    @AndroidFindBy(id = "com.google.android.calculator:id/result_final")
    public MobileElement result;

    @AndroidFindBy(accessibility = "equals")
    public MobileElement equals;

    @AndroidFindBy(accessibility = "multiply")
    public MobileElement multiply;

    @AndroidFindBy(accessibility = "divide")
    public MobileElement divide;

    @AndroidFindBy(accessibility = "plus")
    public MobileElement add;

    @AndroidFindBy(accessibility = "minus")
    public MobileElement subtract;

    @AndroidFindBy(accessibility = "clear")
    public MobileElement clear;
    public void clickDigit(int digit) throws MalformedURLException, InterruptedException {
       String id="com.google.android.calculator:id/digit_"+digit;
        MobileElement num=Driver.getDriver().findElement(MobileBy.id(id));
        num.click();
    }


}
