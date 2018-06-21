package com.fincash.uiActions;

import com.fincash.testBase.TestBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage extends TestBase{

    public static final Logger log = Logger.getLogger(Homepage.class.getName());
    WebDriver driver;


    public Homepage(WebDriver driver)
    {
        this.driver= driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//span[text()='LOG IN']")
    WebElement loginButton;

    @FindBy(css = "input[placeholder='Email Id']")
    WebElement userName;

    @FindBy(css = "input[type=password][placeholder='Password']")
    WebElement passWord;

    @FindBy(xpath = "//text()[contains(.,'LOGIN')]/ancestor::button[1]")
    WebElement submitButton;

//    @FindBy(xpath = "//button[text()='Retry']")
//    WebElement invalidUser;
//
//    @FindBy(xpath = "//simple-snack-bar[text()='Invalid Password']")
//    WebElement snackbar;

    public void loginToApplication(String email, String password) throws InterruptedException {
        loginButton.click();
        log.info("Clicking on login button and object is : " + loginButton.toString());
        waitForElement(driver,5000,userName);

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
