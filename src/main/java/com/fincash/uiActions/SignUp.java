package com.fincash.uiActions;

import com.fincash.testBase.TestBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUp extends TestBase {

    public static final Logger log = Logger.getLogger(SignUp.class.getName());
    WebDriver driver;


    public SignUp(WebDriver driver)
    {
        this.driver= driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//span[text()='SIGN UP']")
    WebElement signUpButton;

    @FindBy(xpath = "//input[@placeholder='Email Id']")
    WebElement emailBox;

    @FindBy(xpath = "//input[@type='password' and @placeholder='Password']")
    WebElement passWord;

    @FindBy(xpath = "//input[@type='password' and @placeholder='Confirm Password']")
    WebElement confirmPassWord;

    @FindBy(xpath = "//button[@type='submit']/span/span")
    WebElement submitButton;

//    @FindBy(xpath = "//button[text()='Retry']")
//    WebElement invalidUser;
//
//    @FindBy(xpath = "//simple-snack-bar[text()='Invalid Password']")
//    WebElement snackbar;

    public void signUpToApplication(String email, String password, String confirmPass) throws InterruptedException {
     
        new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfElementLocated(By.tagName("app-logintoinvest")));
        checkPageIsReady();

        emailBox.clear();
        emailBox.sendKeys(email);
        log.info("Entered Email = " + email + " and object is : " + emailBox.toString());

        this.passWord.clear();
        this.passWord.sendKeys(confirmPass);
        log.info("Entered password = " + password + " and object is : " + passWord.toString());

        this.confirmPassWord.clear();
        this.confirmPassWord.sendKeys(password);
        log.info("Entered password = " + password + " and object is : " + confirmPassWord.toString());

        checkPageIsReady();
        submitButton.click();
        submitButton.click();
        log.info("Submitted form and object is :  " + submitButton.toString());


    }

    public boolean isLoginSuccess()
    {
        checkPageIsReady();
        String actualTitle = driver.getTitle();
        String expectedTitle = "KYC | Fincash.com";
        if(actualTitle.equals(expectedTitle))
            return true;
        else return false;
    }


}
