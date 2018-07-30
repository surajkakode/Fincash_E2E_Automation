package com.fincash.uiActions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

    public void changeInvestmentAmount(String investmentAmount)
    {
        this.investmentAmount.clear();
        this.investmentAmount.sendKeys(investmentAmount);
    }


}
