package com.fincash.uiActions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class InvestmentSummary {

    public static final Logger log = Logger.getLogger(InvestmentSummary.class.getName());

    WebDriver driver;

    public InvestmentSummary(WebDriver driver)
    {
        this.driver =driver;
        PageFactory.initElements(driver,this);
    }
    public final String neftRtgs = "NEFT/RTGS";
    public final String netBanking = "NET BANKING";

    @FindBy(tagName = "mat-checkbox")
    WebElement checkbox;

    @FindBy(tagName = "mat-dialog-container")
    WebElement dialog;

    @FindBy(tagName = "mat-radio-button")
    List<WebElement> radioButtons;

    @FindBy(xpath = "//button//span[contains(text(),'PROCEED')]")
    WebElement proceedButton;

    @FindBy(xpath = "//mat-dialog-container//button")
    WebElement proceedButtonDialog;

    @FindBy(xpath = "//mat-dialog-container//button")
    List <WebElement> mandateButton;

    public void clickOnRadio(String radioButtonName)
    {

        log.info(checkbox.isEnabled());
        if (radioButtonName.equals(netBanking))
            radioButtons.get(0).click();
        else if (radioButtonName.equals(neftRtgs))
            radioButtons.get(1).click();
        log.info("clicked on radio Button ");
    }

    public void clickOnCheckbox()
    {
        new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(checkbox));
        new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(checkbox));
        log.info(checkbox.isSelected());
        checkbox.click();
        log.info("clicked on checkbox and the status is :"+ checkbox.isSelected());
    }

    public void clickOnProceed()
    {
        new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(proceedButton));
        proceedButton.click();
    }

    public void waitForDialog()
    {
        new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(dialog));
        new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(proceedButtonDialog));
    }

    public void clickOnProceedDialog()
    {
        waitForDialog();
        proceedButtonDialog.click();
    }


        public void clickOnMandateButton(int buttonNumber)
        {
            /*
            *  0 for 50000
            *  1 for 10000 or entered amount
            * */
            mandateButton.get(buttonNumber).click();
            log.info("clicked on Button : "+ mandateButton.get(buttonNumber).getText());
        }

}
