package com.fincash.uiActions;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Header {

    public static final Logger log = Logger.getLogger(Header.class.getName());
    WebDriver driver;


    public Header(WebDriver driver)
    {
        this.driver= driver;
        PageFactory.initElements(driver,this);
    }
    public final String solutions ="SOLUTIONS";
    public final String exploreFunds ="EXPLORE FUNDS";
    public final String calculators ="CALCULATORS";
    public final String login ="LOG IN";
    public final String signUp ="SIGN UP";

    public final String savingsPlus ="SavingsPlus";
    public final String smartSIP ="SmartSIP";
    public final String taxSaver ="TaxSaver";

    public final String taxCalculator ="Tax Calculator";
    public final String growthOfLumpsum ="Growth of Lumpsum";
    public final String growthOfSIP ="Growth of SIP";
    public final String retirementPlanning ="Retirement Planning";
    public final String higherEducation ="Higher Education";
    public final String marriageExpense ="Marriage Expense";
    public final String buyHouse ="Buy House";
    public final String buyVehicle ="Buy Vehicle";
    public final String anyOtherGoal ="Any other Goal";


    @FindBy(xpath = "//mat-toolbar//a[@href='/']")
    public WebElement fincashLogo;

    @FindBy(xpath = "//div[@class='mat-menu-content']")
    public WebElement menuContent;

    @FindBy(xpath = "//button[@mattooltip='Account']")
    public WebElement accountButton;

    @FindBy(xpath = "//button[@mattooltip='Dashboard']")
    public WebElement dashboardButton;

    @FindBy(xpath = "//button[@mattooltip='Report & Order']")
    WebElement quickReportAndOrder;

    @FindBy(xpath = "//mat-toolbar//div[@mattooltip='Cart']")
    WebElement cart;

    @FindBy(xpath = "//span[contains(text(),'Logout')]")
    WebElement logout;

    @FindBy(xpath = "//input[@placeholder='Search for Funds']")
    WebElement searchBox;

    @FindBy(tagName = "mat-option")
    List<WebElement> searchSuggestion;

    public void clickOnHeaderButton(String buttonName)
    {
        driver.findElement(By.xpath("//mat-toolbar//span[contains(text(),'"+buttonName+"')]")).click();
    }

    public void clickOnSubHeaderButton(String buttonName)
    {
        new WebDriverWait(driver,5).until(ExpectedConditions.visibilityOf(menuContent));
        driver.findElement(By.xpath("//div[@class='mat-menu-content']//a[contains(text(),'"+buttonName+"')] ")).click();
    }

    public void clickOnProductSolutions(String buttonName)
    {
        clickOnHeaderButton(solutions);
        new WebDriverWait(driver,5).until(ExpectedConditions.visibilityOf(menuContent));
        driver.findElement(By.xpath("//div[@class='mat-menu-content']//a[contains(text(),'"+buttonName+"')] ")).click();
    }

    public void clickOnCalculators(String buttonName)
    {
        clickOnHeaderButton(calculators);
        new WebDriverWait(driver,5).until(ExpectedConditions.visibilityOf(menuContent));
        driver.findElement(By.xpath("//div[@class='mat-menu-content']//a[contains(text(),'"+buttonName+"')] ")).click();
    }

    public void clickOnLogout()
    {
        new WebDriverWait(driver,5).until(ExpectedConditions.visibilityOf(accountButton));
        accountButton.click();
        new WebDriverWait(driver,5).until(ExpectedConditions.visibilityOf(logout));
        logout.click();
    }

    public void SearchFund(String fundName) throws InterruptedException {
        new WebDriverWait(driver,5).until(ExpectedConditions.visibilityOf(searchBox));
        searchBox.sendKeys(fundName);
        new WebDriverWait(driver,5).until(ExpectedConditions.visibilityOf(searchSuggestion.get(0)));
//        searchSuggestion.forEach(s->log.info(s.getText()));
    }
    public void clickOnSuggestedFund(int no)
    {
        new WebDriverWait(driver,5).until(ExpectedConditions.visibilityOf(searchSuggestion.get(0)));
        searchSuggestion.get(no);
    }
    public void isFundInSearchSuggestion()
    {
        //
    }

    public void clickOnCart()
    {   new WebDriverWait(driver,5).until(ExpectedConditions.visibilityOf(cart));
        cart.click();
    }

}
