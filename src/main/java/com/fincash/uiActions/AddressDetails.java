package com.fincash.uiActions;


import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressDetails {

    public static final Logger log = Logger.getLogger(AddressDetails.class.getName());

//    WebDriver driver= null;
//
//    public AddressDetails(WebDriver driver)
//    {
//        this.driver =driver;
//        PageFactory.initElements(driver,this);
//    }

    @FindBy(xpath = "//input[@placeholder='Address line 1']")
    WebElement address1;

    @FindBy(xpath = "//input[@placeholder='Address line 2']")
    WebElement address2;

    @FindBy(xpath = "//input[@placeholder='Pin Code']")
    WebElement pinCode;

    @FindBy(xpath = "//input[@placeholder='Near landmark']")
    WebElement landmark;

    @FindBy(xpath = "//input[@placeholder='City']")
    WebElement city;

    @FindBy(xpath = "//input[@placeholder='District']")
    WebElement district;



    public void addressDetailsform(String address1,String address2,String pinCode,String landmark, String city,String district)
    {
        this.address1.clear();
        this.address1.sendKeys(address1);
        log.info("Entered "+address1+" And the object is : "+this.address1);

        this.address2.clear();
        this.address2.sendKeys(address2);
        log.info("Entered "+address2+" And the object is : "+this.address2);

        this.pinCode.clear();
        this.pinCode.sendKeys(pinCode);
        log.info("Entered "+pinCode+" And the object is : "+this.pinCode);

        this.landmark.clear();
        this.landmark.sendKeys(landmark);
        log.info("Entered "+landmark+" And the object is : "+this.landmark);

        this.city.clear();
        this.city.sendKeys(city);
        log.info("Entered "+city+" And the object is : "+this.city);

        this.district.clear();
        this.district.sendKeys(district);
        log.info("Entered "+district+" And the object is : "+this.district);

    }
}
