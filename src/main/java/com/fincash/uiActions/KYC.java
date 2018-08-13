package com.fincash.uiActions;

import com.fincash.util.NgSelect;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class KYC {

    public static final Logger log = Logger.getLogger(KYC.class.getName());

    WebDriver driver;

    public KYC(WebDriver driver)
    {
        this.driver =driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(tagName = "mat-select")
    WebElement country;

    @FindBy(tagName = "mat-option")
    public List <WebElement> countryList;

    @FindBy(xpath = "//input[@placeholder='Enter your mobile number']")
    WebElement mobileNumberBox;

    @FindBy(xpath = "//mat-select[@formcontrolname='code']")
    WebElement selectCountry;

    @FindBy(xpath = "//span[contains(text(),'Send OTP')]")
    WebElement sendOTPbutton;

    @FindBy(xpath = "//input[@placeholder='Enter OTP']")
    WebElement otpBox;

    @FindBy(xpath = "//button[@type='submit']/span[contains(text(),Submit)]")
    WebElement submitOTP;


    @FindBy(xpath = "//input[@placeholder='Enter your PAN']")
    WebElement panBox;


    @FindBy(xpath = "//div/a[@class='yes-button']")
    WebElement yesProceedToEkyc;

    @FindBy(xpath = "//div/a[@class='no-button']")
    WebElement noProceedToReg;

    public void setCountry(int no)
    {
        new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(country));
        country.click();
        log.info("clicking on : "+countryList.get(no).getText());
        countryList.get(no).click();

    }

    public void setMobileNumber (String mobileNumber)
    {
        mobileNumberBox.clear();
        mobileNumberBox.sendKeys(mobileNumber);
        log.info("mobile number filled with "+mobileNumber);

        sendOTPbutton.click();
        log.info("clicked on Send OTP button");
    }
    public void acceptButton()
    {
        log.info("inside accept");
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button/span[contains(text(),'Yes')]")));
        driver.findElement(By.xpath("//button/span[contains(text(),'Yes')]")).click();
        log.info("clicked on Yes button");
    }
    public void dismissButton()
    {
        log.info("inside dismiss");
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button/span[contains(text(),'No')]")));
        driver.findElement(By.xpath("//button/span[contains(text(),'No')]")).click();
        log.info("clicked on No button");
    }

    public void setOTP(String otp)
    {
        otpBox.clear();
        otpBox.sendKeys(otp);
        otpBox.submit();
    }

    public void setPan(String pan)
    {
        panBox.clear();
        panBox.sendKeys(pan);
        panBox.submit();
        log.info("Clicked on Submit button and the object is : "+ panBox);
    }

    public void proceedToEkyc()
    {
        new WebDriverWait(driver, 20).until(ExpectedConditions.invisibilityOfElementLocated(By.tagName("mat-progress-spinner")));
        yesProceedToEkyc.click();
        log.info("Clicked on Yes button and the object is : "+ yesProceedToEkyc);
    }
    public void proceedToReg()
    {
        new WebDriverWait(driver, 20).until(ExpectedConditions.invisibilityOfElementLocated(By.tagName("mat-progress-spinner")));
        noProceedToReg.click();
        log.info("Clicked on No button and the object is : "+ noProceedToReg);
    }
}
