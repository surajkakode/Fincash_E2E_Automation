package com.fincash.uiActions;

import com.fincash.testBase.TestBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class DocumentUpload {

    public static final Logger log = Logger.getLogger(DocumentUpload.class.getName());
    WebDriver driver;

    public DocumentUpload(WebDriver driver)
    {
        this.driver =driver;
        PageFactory.initElements(this.driver,this);
    }

    @FindBy(className = "column-heading")
    WebElement column;

    @FindBy(xpath = "//input[@id='passport_photo']")
    WebElement passport_photo;

    @FindBy(xpath = "//input[@id='pan']")
    WebElement pan;

    @FindBy(tagName = "mat-option")
    List <WebElement> option;

    //mat-select[@id='mat-select-1']   for Proof of Foreign Address dropdown
    @FindBy(xpath = "//mat-select[@id='mat-select-1']/div/div[2]")
    WebElement proofOfForeignAddressDocBox;

    @FindBy(xpath = "//input[@id='proof_of_address11']")
    WebElement proofOfForeignAddress;

    @FindBy(xpath = "//input[@id='proof_of_address112']")
    WebElement proofOfForeignAddress2;

    //mat-select[@id='mat-select-1']   for Proof of Indian Address dropdown
    @FindBy(xpath = "//mat-select[@id='mat-select-2']")
    WebElement proofOfIndianAddressDocBox;

    @FindBy(xpath = "//input[@id='proof_of_address21']")
    WebElement proofOfIndianAddress;

    @FindBy(xpath = "//input[@id='proof_of_address211']")
    WebElement proofOfIndianAddress2;

    @FindBy(xpath = "//input[@id='passport11']")
    WebElement passport;

    @FindBy(xpath = "//input[@id='passport12']")
    WebElement passport2;

    @FindBy(xpath = "//input[@id='signature']")
    WebElement signature;

    @FindBy(xpath = "//mat-select[@id='mat-select-0']")
    WebElement chequeDocBox;

    @FindBy(xpath = "//input[@id='cheque']")
    WebElement cheque;

    @FindBy(tagName = "mat-slide-toggle")
    WebElement chequeSkipSlider;


    @FindBy(xpath = "//span[contains(text(),'PROCEED')]")
    public WebElement proceedButton;

    public void navigateToDocumentUploadPage() throws InterruptedException {
        Thread.sleep(5000);
        driver.get(TestBase.url+"/registration/upload");
    }

    public void uploadPicture(String path)
    {
        new WebDriverWait(driver,20).until(ExpectedConditions.visibilityOf(column));
        log.info("waiting for column");
        passport_photo.sendKeys(path);
        log.info("uploading file :" + path);
    }

    public void uploadPan(String path)
    {
        new WebDriverWait(driver,20).until(ExpectedConditions.visibilityOf(column));
        pan.sendKeys(path);
        log.info("uploading file :" + path);
    }

    public void uploadProofOfForeignAddress(int documentNo,String path)
    {
        new WebDriverWait(driver,20).until(ExpectedConditions.visibilityOf(column));

        proofOfForeignAddressDocBox.click();
        option.get(documentNo).click();
        proofOfForeignAddress.sendKeys(path);
        log.info("uploading file :" + path);
    }

    public void uploadProofOfForeignAddress(int documentNo,String path, String path2)
    {
        new WebDriverWait(driver,20).until(ExpectedConditions.visibilityOf(column));
        proofOfForeignAddressDocBox.click();
        option.get(documentNo).click();
        proofOfForeignAddress.sendKeys(path);
        if(proofOfForeignAddress2.isDisplayed()) {
            proofOfForeignAddress2.sendKeys(path2);
            log.info("uploading file :" + path);
        }
        else
        {
            //find icon and click  : code needed
            proofOfForeignAddress2.sendKeys(path2);
            log.info("uploading file :" + path);
        }

    }

    public void uploadProofOfIndianAddress(int documentNo,String path)
    {
        new WebDriverWait(driver,20).until(ExpectedConditions.visibilityOf(column));

        proofOfIndianAddressDocBox.click();
        new WebDriverWait(driver,5).until(ExpectedConditions.visibilityOfElementLocated(By.tagName("mat-option")));
        List <WebElement> option2 = driver.findElements(By.tagName("mat-option"));
        option2.forEach(s -> log.info(s.getText()));
        option2.get(documentNo).click();
        proofOfIndianAddress.sendKeys(path);
        log.info("uploading file :" + path);
    }

    public void uploadProofOfIndianAddress(int documentNo,String path, String path2)
    {
        new WebDriverWait(driver,20).until(ExpectedConditions.visibilityOf(column));
        proofOfIndianAddressDocBox.click();
        new WebDriverWait(driver,5).until(ExpectedConditions.visibilityOfElementLocated(By.tagName("mat-option")));
        List <WebElement> option2 = driver.findElements(By.tagName("mat-option"));
        option2.get(documentNo).click();
        proofOfIndianAddress.sendKeys(path);
        if(proofOfIndianAddress2.isDisplayed())
            proofOfIndianAddress2.sendKeys(path2);
        else
        {
            //find icon and click  : code needed
            proofOfIndianAddress2.sendKeys(path2);
        }
        log.info("uploading file :" + path);
    }

    public void uploadPassport(String path)
    {
        new WebDriverWait(driver,20).until(ExpectedConditions.visibilityOf(column));
        passport.sendKeys(path);
        log.info("uploading file :" + path);
    }

    public void uploadPassport(String path, String path2)
    {
        new WebDriverWait(driver,20).until(ExpectedConditions.visibilityOf(column));
        passport.sendKeys(path);
        log.info("uploading file :" + path);
        if(passport2.isDisplayed()) {
            passport2.sendKeys(path2);
            log.info("uploading file :" + path);
        }
        else
        {
            //find icon and click  : code needed
            passport2.sendKeys(path2);
            log.info("uploading file :" + path);
        }

    }
    public void uploadSignature(String path)
    {
        new WebDriverWait(driver,20).until(ExpectedConditions.visibilityOf(column));
        signature.sendKeys(path);
        log.info("uploading file :" + path);
    }

    public void uploadCheque(int documentNo,String path)
    {

        new WebDriverWait(driver,20).until(ExpectedConditions.visibilityOf(column));
        WebElement element = driver.findElement(By.xpath("//i[contains(text(),'Image of Cancelled Cheque with your Name on it for a/c no')]"));
        if(element.isDisplayed())
        {
            chequeDocBox.click();
            option.get(documentNo).click();
            cheque.sendKeys(path);
            log.info("uploading file :" + path);
        }
        else
        {
            chequeSkipSlider.click();
            chequeDocBox.click();
            option.get(documentNo).click();
            cheque.sendKeys(path);
            log.info("uploading file :" + path);
        }
    }

}
