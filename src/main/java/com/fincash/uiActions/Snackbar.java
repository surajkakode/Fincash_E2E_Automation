package com.fincash.uiActions;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Snackbar {

    public static final Logger log = Logger.getLogger(Snackbar.class.getName());
    WebDriver driver= null;

    public Snackbar(WebDriver driver)
    {
        this.driver =driver;
        PageFactory.initElements(driver,this);
    }



    @FindBy(xpath = "//simple-snack-bar//span[contains(text(),'Checkout')]")
    WebElement checkout;

    @FindBy(xpath = "//simple-snack-bar//button")
    WebElement button;

    @FindBy(tagName = "simple-snack-bar")
    WebElement snackbar;



    public void waitForSnackbar()
    {
        new WebDriverWait(driver,5).until(ExpectedConditions.visibilityOf(snackbar));
    }

    public void clickOnCheckout()
    {
        waitForSnackbar();
        checkout.click();
    }

    public void clickOnButton()
    {
        waitForSnackbar();
        log.info("clicking on : "+button.getText());
        button.click();

    }

    public void getSnackbarmessage()
    {
        waitForSnackbar();
        log.info("message on snackbar is : "+snackbar.getText());
    }
}
