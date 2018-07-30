package com.fincash.uiActions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ExploreFunds {

    public static final Logger log = Logger.getLogger(ExploreFunds.class.getName());
    WebDriver driver;


    public ExploreFunds(WebDriver driver)
    {
        this.driver= driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy (tagName = "app-add-to-cart-icon-button")
    List <WebElement> addToCart ;

    public void clickOnAllAddToCart()
    {
        for (int i =0;i<addToCart.size();i++)
        {
            addToCart.get(i).click();
        }
    }

    public void clickOnAllAddToCart(int fundNumber)
    {
        if (fundNumber<=addToCart.size())
         addToCart.get(fundNumber).click();
        else
            log.info("List size is : "+addToCart.size()+" ");
    }

}
