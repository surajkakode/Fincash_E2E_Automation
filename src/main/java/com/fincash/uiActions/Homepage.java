package com.fincash.uiActions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {

    public static final Logger log = Logger.getLogger(Homepage.class.getName());
    WebDriver driver;

    public Homepage(WebDriver driver)
    {
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

    public void loginToApplication(String email, String password)
    {
        loginButton.click();
        log.info("Clicking on login button and object is : "+ loginButton.toString());

        userName.sendKeys(email);
        log.info("Entered Email = "+ email+ " and object is : "+ userName.toString());

        passWord.sendKeys(password);
        log.info("Entered password = "+ password+ " and object is : "+ passWord.toString());

        submitButton.click();
        log.info("Submitted form and object is :  "+ submitButton.toString());


    }
//    public String verifySnackbar() throws InterruptedException {
//      WebDriverWait wait = new WebDriverWait(driver, 10);
//       wait.until(ExpectedConditions.visibilityOf(snackbar));
//        Thread.sleep(1000);
//        String text = snackbar.getText();
//        System.out.println(text);
//        return text;
//    }


}
