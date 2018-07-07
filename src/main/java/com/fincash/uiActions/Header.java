package com.fincash.uiActions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Header {

    public static final Logger log = Logger.getLogger(Homepage.class.getName());
    WebDriver driver;


    public Header(WebDriver driver)
    {
        this.driver= driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//span[text()='LOG IN']")
    public WebElement loginButton;

    @FindBy(xpath = "//span[text()='SIGN UP']")
    public WebElement signUpButton;

    @FindBy(xpath = "//button[@mattooltip='Account']")
    public WebElement account;

    @FindBy(xpath = "//button[@mattooltip='Dashboard']")
    public WebElement dashboard;

    @FindBy(xpath = "//button[@mattooltip='Report & Order']")
    WebElement quickReportAndOrder;

    @FindBy(xpath = "//button[@mattooltip='Cart']")
    WebElement cart;

    @FindBy(xpath = "//span[contains(text(),'Logout')]")
    WebElement logout;

    public void clickOnLogout()
    {
        new WebDriverWait(driver,5).until(ExpectedConditions.visibilityOf(account));
        account.click();
        new WebDriverWait(driver,5).until(ExpectedConditions.visibilityOf(logout));
        logout.click();
    }


}
