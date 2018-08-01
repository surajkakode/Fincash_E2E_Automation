package com.fincash.uiActions;

import com.fincash.testBase.TestBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogIn extends TestBase{

    public static final Logger log = Logger.getLogger(LogIn.class.getName());
    WebDriver driver;


    public LogIn(WebDriver driver)
    {
        this.driver= driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//span[text()='LOG IN']")
    WebElement loginButton;

    @FindBy(xpath = "//input[@placeholder='Email Id']")
    WebElement userName;

    @FindBy(css = "input[type=password][placeholder='Password']")
    WebElement passWord;

    @FindBy(xpath = "//text()[contains(.,'LOGIN')]/ancestor::button[1]")
    WebElement submitButton;

    @FindBy(xpath = "//div[contains(text(),'Forgot password?')]")
    WebElement forgotPassword;

//    @FindBy(xpath = "//button[text()='Retry']")
//    WebElement invalidUser;
//
//    @FindBy(xpath = "//simple-snack-bar[text()='Invalid Password']")
//    WebElement snackbar;

    public void loginToApplication(String email, String password) throws InterruptedException {

        new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfElementLocated(By.tagName("app-logintoinvest")));
        new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(userName));

        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", userName);
        userName.clear();
        userName.sendKeys(email);
        log.info("Entered Email = " + email + " and object is : " + userName.toString());

        this.passWord.clear();
        this.passWord.sendKeys(password);
        log.info("Entered password = " + password + " and object is : " + passWord.toString());

        submitButton.click();
        log.info("Submitted form and object is :  " + submitButton.toString());


    }

    public boolean isLoginSuccess()
    {
        String actualTitle = driver.getTitle();
        String expectedTitle = "Dashboard | Fincash.com";
        if(actualTitle.equals(expectedTitle))
            return true;
        else return false;
    }


}
