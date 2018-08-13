package com.fincash.uiActions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderComplete {

    public static final Logger log = Logger.getLogger(OrderComplete.class.getName());
    WebDriver driver;


    public OrderComplete(WebDriver driver)
    {
        this.driver= driver;
        PageFactory.initElements(driver,this);
    }
    String expectedMessage = "Your order has been initiated!";
    String actualMessage="";

    @FindBy(xpath = "//div[contains(text(),'Your order has been initiated!')]")
    WebElement message;


    public boolean isSuccess()
    {
        actualMessage= new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(message)).getText();

       if(expectedMessage.equalsIgnoreCase(actualMessage))
           return true;
       else return false;
    }
}
