package com.fincash.uiActions;

import com.fincash.testBase.JSWaiter;
import com.fincash.testBase.TestBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Registration extends AddressDetails{
    public static final Logger log = Logger.getLogger(Registration.class.getName());
    WebDriver driver= null;

    public Registration(WebDriver driver)
    {
        this.driver =driver;
        PageFactory.initElements(driver,this);
    }


    @FindBy(xpath = "//input[@placeholder='Name (As on PAN card)']")
    WebElement panName;

    @FindBy(xpath = "//input[@placeholder='Father/Spouse Name']")
    WebElement fatherName;

    @FindBy(xpath = "//input[@placeholder='Mother Name']")
    WebElement motherName;

    @FindBy(xpath = "//input[@placeholder='Aadhaar No.']")
    WebElement aadharNo;

    @FindBy(xpath = "//input[@placeholder='Date of Birth(dd/mm/yyyy)']")
    WebElement dateOfBirth;

    @FindBy (xpath = "//input[@placeholder='Name as on Cheque Book']")
    WebElement holderName;

    @FindBy (xpath = "//input[@placeholder='Bank Account Number']")
    WebElement accountNumber;

    @FindBy (xpath = "//input[@placeholder='Confirm Bank Account Number']")
    WebElement confirmAccountNumber;

    @FindBy(xpath = "//input[@placeholder='Birth City']")
    WebElement birthCity;

    @FindBy(xpath = "//input[@placeholder='Nominee Name']")
    WebElement nomineeName;

    @FindBy(xpath = "//mat-select[@formcontrolname='taxStatus']")
    WebElement taxStatus;

    @FindBy(xpath = "//mat-select[@formcontrolname='addressType']")
    WebElement addressType;

    @FindBy(xpath = "//mat-select[@formcontrolname='state']")
    WebElement state;

    @FindBy(xpath = "//mat-select[@formcontrolname='country']")
    WebElement country;

    @FindBy(xpath = "//mat-select[@formcontrolname='accountType']")
    WebElement accountType;

    @FindBy (xpath = "//input[@placeholder='Enter IFSC or Bank or Branch name (e.g. ICICI Vashi)']")
    WebElement ifscBankBranch;

    @FindBy(xpath = "//mat-select[@formcontrolname='income']")
    WebElement income;

    @FindBy(xpath = "//mat-select[@formcontrolname='occupation']")
    WebElement occupation;

    @FindBy(xpath = "//mat-select[@formcontrolname='sourceOfWealth']")
    WebElement sourceOfWealth;

    @FindBy(xpath = "//mat-select[@formcontrolname='nationality']")
    WebElement nationality;

    @FindBy(xpath = "//mat-select[@formcontrolname='birthCountry']")
    WebElement birthCountry;

    @FindBy(xpath = "//mat-select[@formcontrolname='taxCountry']")
    WebElement taxCountry;

    @FindBy(xpath = "//mat-select[@formcontrolname='nomineeRelation']")
    WebElement nomineeRelation;


    @FindBy(tagName = "mat-option")
    List <WebElement> Option;

    @FindBy(tagName = "mat-radio-button")  //(xpath = "//input[@type='radio']/following-sibling::div")
    List <WebElement> radioButtons;

    @FindBy(xpath = "//mat-checkbox/label/div")
    List <WebElement> checkBox;

    @FindBy(xpath = "//button[@type='submit']")
    List <WebElement> saveButtons;

    @FindBy(xpath = "//span[contains(text(),'Personal Information')]")
    WebElement form1;

    @FindBy(xpath = "//span[contains(text(),'Address Details')]")
    WebElement form2;

    @FindBy(xpath = "//span[contains(text(),'Bank Account')]")
    WebElement form3;

    @FindBy(xpath = "//span[contains(text(),'FATCA')]")
    WebElement form4;

    @FindBy(xpath = "//span[contains(text(),'Nominee')]")
    WebElement form5;

    //div[@fxhide.lt-md='true']/child::button/child::span[contains(text(),'Proceed to Upload ')]

    @FindBy(xpath = "//div[@fxhide.lt-md='true']/child::button/child::span[contains(text(),'Proceed to Upload ')]")
    public WebElement proceedToUpload;

    @FindBy(xpath = "//div[@fxhide.gt-sm='true']/child::button/child::span[contains(text(),'Proceed to Upload ')]")
    public WebElement proceedToUploadOnMobile;


    public void navigateToRegistrationPage() throws InterruptedException {
        Thread.sleep(5000);
        driver.get(TestBase.url+"/registration");
    }
    public void openForm(String formName)
    {
        /* formname : basic, kyc, bank, other, nominee*/
        driver.findElement(By.xpath("//"+formName+"-section/div")).click();
    }

    public void openForm(int formNameNo) throws InterruptedException {
        /* formName : basic, kyc, bank, other, nominee*/

        WebDriverWait wait = new WebDriverWait(driver,50);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.tagName("mat-dialog-container")));

        if (formNameNo==1)
            form1.click();
        else if (formNameNo==2){
            form2.click();//    //span[contains(text(),'Address Details')]
          }
        else if (formNameNo==3)
            form3.click();
        else if (formNameNo==4)
            form4.click();
        else if (formNameNo==5)
            form5.click();
    }


    public void personalInformationForm(String name, String fatherName, String motherName, String dob)
    {
        this.panName.clear();
        this.panName.sendKeys(name);
        log.info("Entered "+name+" And the object is : "+this.panName);

        this.fatherName.clear();
        this.fatherName.sendKeys(fatherName);
        log.info("Entered "+fatherName+" And the object is : "+this.fatherName);

        this.motherName.clear();
        this.motherName.sendKeys(motherName);
        log.info("Entered "+motherName+" And the object is : "+this.motherName);

        this.dateOfBirth.clear();
        this.dateOfBirth.sendKeys(dob);
        log.info("Entered "+dob+" And the object is : "+this.dateOfBirth);
    }

    public void bankAccountForm(String holderName,String accountNumber,String confirmAccountNumber)
    {
        this.holderName.clear();
        this.holderName.sendKeys(holderName);
        log.info("Entered "+holderName+" And the object is : "+this.holderName);

        this.accountNumber.clear();
        this.accountNumber.sendKeys(accountNumber);
        log.info("Entered "+accountNumber+" And the object is : "+this.accountNumber);

        this.confirmAccountNumber.clear();
        this.confirmAccountNumber.sendKeys(confirmAccountNumber);
        log.info("Entered "+confirmAccountNumber+" And the object is : "+this.confirmAccountNumber);
    }

    public void setBirthCity(String birthCity)
    {
        this.birthCity.clear();
        this.birthCity.sendKeys(birthCity);
        log.info("Entered "+birthCity+" And the object is : "+this.birthCity);
    }

    public void setNomineeName(String nomineeName)
    {
        this.nomineeName.clear();
        this.nomineeName.sendKeys(nomineeName);
        log.info("Entered "+nomineeName+" And the object is : "+this.nomineeName);
    }
    public void clickOnCheckBox(int no)
    {   /*
            for
            My correspondence address is same as above -0
            I agree to the Terms & Conditions and the Privacy Policy (DesktopView)-1
            I agree to the Terms & Conditions and the Privacy Policy (MobileView)-2*/
        log.info("Check Box "+checkBox.get(no).getText() +" is selected ="+checkBox.get(no).isSelected());
        checkBox.get(no).click();
        log.info("Check Box "+checkBox.get(no).getText() +" is selected ="+checkBox.get(no).isSelected());
    }
    public void clickOnRadioButton(int no) throws InterruptedException {
       /*For Marital Status
        single - 0
        married - 1
        other - 2

        For Gender
        Male - 3
        Female -4
        Other - 5

        Politically Exposed
        Yes- 6
        No -7

        Politically related
        Yes -8
        No - 9       */
        radioButtons.get(no).click();
        log.info("Radio button "+radioButtons.get(no).getText() +" is enabled ="+radioButtons.get(no).isEnabled());

    }

    public void submitFormNo(int no)
    {
       /*For
       Personal Information - 0
       Address Details -1
       Bank Account -2
       Fatca -3
       Nominee -4         */
       --no;
        saveButtons.get(no).click();
        log.info("Clicked on submit button.");
    }

    public boolean isFormSubmitted()
    {
        List <WebElement> errorMessage = driver.findElements(By.tagName("mat-hint"));
        if(errorMessage.isEmpty())
        {
            log.info("No Error/s on Page");
            return true;
        }
        else
        {
            log.info("Below are the Error/s on Page");
            errorMessage.forEach(s -> log.info(s.getText()));
            return false;
        }
    }

    public void setTaxStatus(int no){
        /*  for
          Indivisual -0
          NRI -1
          NRo -2     */
        taxStatus.click();
        Option.forEach(s -> log.info(s.getText()));
        log.info("Option "+Option.get(no).getText() +" is selected ");
        Option.get(no).click();

    } public void setAddressType(int no){
        /*  for
              */
        addressType.click();
        Option.forEach(s -> log.info(s.getText()));
        log.info("Option "+Option.get(no).getText() +" is selected ");
        Option.get(no).click();

    } public void setState(int no){
        /*  for
            */
        state.click();
        Option.forEach(s -> log.info(s.getText()));
        log.info("Option "+Option.get(no).getText() +" is selected ");
        Option.get(no).click();

    } public void setCountry(int no){
        /*  for
          */
        country.click();
        Option.forEach(s -> log.info(s.getText()));
        log.info("Option "+Option.get(no).getText() +" is selected ");
        Option.get(no).click();

    } public void setAccountType(int no){
        /*  for
            */
        accountType.click();
        Option.forEach(s -> log.info(s.getText()));
        log.info("Option "+Option.get(no).getText() +" is selected ");
        Option.get(no).click();

    }public void setIfscBankBranch(String ifscBankBranch,int no){
        /*  for
            */
        try {
            this.ifscBankBranch.clear();
            this.ifscBankBranch.sendKeys(ifscBankBranch);
            new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfElementLocated(By.tagName("mat-option")));
            Option.forEach(s -> log.info(s.getText()));
            log.info("Option "+Option.get(no).getText() +" is selected ");
            Option.get(no).click();

        } catch (Exception e) {
            e.printStackTrace();

        }

    }public void setIncome(int no){
        /*  for
           */
        income.click();
        Option.forEach(s -> log.info(s.getText()));
        log.info("Option "+Option.get(no).getText() +" is selected ");
        Option.get(no).click();


    } public void setOccupation(int no){
        /*  for
           */
        occupation.click();
        Option.forEach(s -> log.info(s.getText()));
        log.info("Option "+Option.get(no).getText() +" is selected ");
        Option.get(no).click();


    } public void setSourceOfWealth(int no){
        /*  for
           */
        sourceOfWealth.click();
        Option.forEach(s -> log.info(s.getText()));
        log.info("Option "+Option.get(no).getText() +" is selected ");
        Option.get(no).click();


    } public void setNationality(int no){
        /*  for
             */
        nationality.click();
        Option.forEach(s -> log.info(s.getText()));
        log.info("Option "+Option.get(no).getText() +" is selected ");
        Option.get(no).click();

    } public void setBirthCountry(int no){
        /*  for
            */
        birthCountry.click();
        Option.forEach(s -> log.info(s.getText()));
        log.info("Option "+Option.get(no).getText() +" is selected ");
        Option.get(no).click();

    } public void setTaxCountry(int no){
        /*  for
             */
        taxCountry.click();
        Option.forEach(s -> log.info(s.getText()));
        log.info("Option "+Option.get(no).getText() +" is selected ");
        Option.get(no).click();

    } public void setNomineeRelation(int no){
        /*  for
           */
        nomineeRelation.click();
        Option.forEach(s -> log.info(s.getText()));
        log.info("Option "+Option.get(no).getText() +" is selected ");
        Option.get(no).click();

    }
}
