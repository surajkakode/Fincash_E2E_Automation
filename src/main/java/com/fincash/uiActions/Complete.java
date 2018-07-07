package com.fincash.uiActions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Complete {
    public static final Logger log = Logger.getLogger(Complete.class.getName());
    WebDriver driver;

    public Complete (WebDriver driver)
    {
        this.driver =driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy (xpath = "//div[contains(text(),' Your Fincash registration is complete ')]")
    public WebElement success;

    public boolean isSuccessful()
    {
        new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(success));
        String actualText = success.getText();
        String expectedText = "Your Fincash registration is complete";
        if(actualText.equalsIgnoreCase(expectedText))
        {   log.info(success.getText());
            return true;}
        else return false;
    }
}
