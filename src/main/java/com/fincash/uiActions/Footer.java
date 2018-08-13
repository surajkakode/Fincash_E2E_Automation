package com.fincash.uiActions;

import com.fincash.testBase.TestBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Footer extends TestBase{
    public static final Logger log = Logger.getLogger(Footer.class.getName());
    WebDriver driver;

    public Footer(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//a[@routerlink = 'solutions/savings-plus']")    ////a[@routerlink = 'solutions/savings-plus']    //div[@class='wrapper']/div[1]/ul[1]/li[1]
    WebElement savingPlus;

    @FindBy(xpath = "//a[@routerlink = 'solutions/smart-sip']")
    WebElement smartSip;

    @FindBy(xpath = "//a[@routerlink = 'solutions/tax-saver']")
    WebElement taxSaver;

    @FindBy(xpath = "//a[@routerlink = 'explore']")
    WebElement exploreFund;


    public void clickOnFooter() throws InterruptedException {
        ////div[@class='wrapper']/div[1]/ul/li[1]

        log.info("clicking on Saving Plus");
        savingPlus.click();
        log.info("Navigating back");
        driver.navigate().back();

        log.info("clicking on Smart SIP");
        smartSip.click();
        log.info("Navigating back");
        driver.navigate().back();

        log.info("clicking on Tax saver");
        taxSaver.click();
        log.info("Navigating back");
        driver.navigate().back();

        log.info("clicking on explore Funds");
        exploreFund.click();
        log.info("Navigating back");
        driver.navigate().back();
    }

    public void clickOnAllElementOfFooter() {
        //     //div[@class='middle desktop']/div/div[2]/ul/li[1]/a   <<uniquely identify footer element
        int i = 1;
        int j = 1;
        for (i = 1; i <= 5; i++) {
            try {
                for (j = 1; j < 10; j++) {
                    driver.findElement(By.xpath("//div[@class='middle desktop']/div/div[" + i + "]/ul/li[" + j + "]/a")).click();
                    checkPageIsReady();
                    log.info(driver.getTitle());
                    driver.navigate().back();
                    checkPageIsReady();
                }
            } catch (Exception e) {
                log.error(e,e);
            }

        }
    }

}