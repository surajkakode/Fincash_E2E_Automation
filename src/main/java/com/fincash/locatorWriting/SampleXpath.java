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

    /* printing list object

       listObject.forEach(s -> log.info(s.getText()));
     \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        -- 2nd highest order amount query
       select * from
        (select * from FCSOT order by SOTORDERAMOUNT desc limit 2)As anyName
            order by SOTORDERAMOUNT asc limit 1;

     */

    public void cclickonproducts(String product) {
        //button[contains(text(),'Women') and area-expended ='true' ]/following-sibling::ul/child::li/child::a[contains(text(),'"+product+"')]
        driver.findElement(By.xpath("//button[contains(text(),'Women') and area-expended ='true' ]/following-sibling::ul/child::li/child::a[contains(text(),'"+product+"')]")).click();
    }
}
