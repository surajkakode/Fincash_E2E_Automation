package com.fincash.uiActions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Cart {

    public static final Logger log = Logger.getLogger(Cart.class.getName());
    WebDriver driver;


    public Cart(WebDriver driver)
    {
        this.driver= driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//span[contains(text(),'INVEST NOW ')]")
    WebElement investNow ;

    public void clickOnInvestNow()
    {
        new WebDriverWait(driver,5).until(ExpectedConditions.visibilityOf(investNow));
        investNow.click();
    }

}
