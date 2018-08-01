package com.fincash.uiActions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InvestmentDetails {

    public static final Logger log = Logger.getLogger(InvestmentDetails.class.getName());

    WebDriver driver;

    public InvestmentDetails(WebDriver driver)
    {
        this.driver =driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@type='number']")
    WebElement investmentAmount;

    @FindBy(xpath = "//button[@type='submit']//span[contains(text(),'SUMMARY & CHECKOUT')]")
    WebElement submitButton;

    public void changeInvestmentAmount(String investmentAmount)
    {
        this.investmentAmount.clear();
        this.investmentAmount.sendKeys(investmentAmount);
    }

    public void proceed()
    {
        new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(submitButton));
        new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(submitButton));
        log.info(submitButton.isDisplayed());
        submitButton.click();
        log.info("clicked on proceed button");
    }
}
