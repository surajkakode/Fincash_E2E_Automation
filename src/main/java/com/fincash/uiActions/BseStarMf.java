package com.fincash.uiActions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BseStarMf {

    public static final Logger log = Logger.getLogger(BseStarMf.class.getName());
    WebDriver driver;


    public BseStarMf(WebDriver driver)
    {
        this.driver= driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//select[@name='ddlMode']")
    WebElement ddlMode;

    @FindBy(xpath = "//input[@name='txtUTRNo']")
    WebElement txtUTRNo;

    @FindBy(xpath = "//input[@type='submit']")
    WebElement submit;

    public void payUsingNeftRtgs()
    {
        new WebDriverWait(driver,5).until(ExpectedConditions.visibilityOf(ddlMode));
        Select select = new Select(ddlMode);
        select.selectByValue("NEFTRTGS");

        new WebDriverWait(driver,5).until(ExpectedConditions.visibilityOf(txtUTRNo));
        txtUTRNo.sendKeys("dummyUTRNO");

        submit.click();
    }
}
