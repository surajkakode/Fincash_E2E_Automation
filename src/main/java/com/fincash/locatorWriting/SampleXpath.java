package com.fincash.locatorWriting;

import com.fincash.testBase.TestBase;
import org.openqa.selenium.By;

public class SampleXpath extends TestBase{

    // for clicking inside the navigation menu , use this type of xpath
    // button[contains(text(),'Women') and area-expended ='true' ]/following-sibling::ul/child::li/child::a[contains(text(),'Shorts')]


    public void clickonproducts(String product) {
        //button[contains(text(),'Women') and area-expended ='true' ]/following-sibling::ul/child::li/child::a[contains(text(),'"+product+"')]
        driver.findElement(By.xpath("//button[contains(text(),'Women') and area-expended ='true' ]/following-sibling::ul/child::li/child::a[contains(text(),'"+product+"')]")).click();
    }
}
