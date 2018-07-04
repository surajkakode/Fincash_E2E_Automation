package KYC;

import com.fincash.testBase.TestBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PopupCheck extends TestBase {

    public static final Logger log = Logger.getLogger(PopupCheck.class.getName());
    @BeforeTest
    public void setup()
    {
        init();
    }

    @Test
            public void popupCheck()
    {

        driver.get("https://api.fincash.com/solutions/savings-plus/funds/cash");
        ngWebDriver.waitForAngularRequestsToFinish();
        driver.findElement(By.xpath("//label/div")).click();
        try {
          WebDriverWait wait = new WebDriverWait(driver, 2);
           wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button/span[contains(text(),'No')]")));
            //Thread.sleep(5000);
           // Alert alert = driver.switchTo().alert();
            driver.findElement(By.xpath("//button/span[contains(text(),'No')]")).click();
            //Assert.assertTrue(alert.getText().contains("Thanks."));
        } catch (Exception e) {
            //exception handling
            e.printStackTrace();
            log.info("exception caught");
        }

    }

}
