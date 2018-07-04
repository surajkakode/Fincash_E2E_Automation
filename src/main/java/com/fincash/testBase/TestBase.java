package com.fincash.testBase;


import com.paulhammant.ngwebdriver.NgWebDriver;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;


public class TestBase {

    public static final Logger log = Logger.getLogger(TestBase.class.getName());

    public static WebDriver driver;
    public static NgWebDriver ngWebDriver;
    String browser = "firefox";
    public static String url = "https://api.fincash.com";  //http://10.1.0.103:81/

    public void init()
    {
        selectBrowser(browser);
        getUrl(url);
        String log4jConfPath = "log4j.properties";
        PropertyConfigurator.configure(log4jConfPath);

    }

    public void selectBrowser(String browser)
    {
        if(browser.equalsIgnoreCase("firefox"))
        {
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\Drivers\\geckodriver.exe");
            log.info("Creating the object of "+ driver);
            this.driver = new FirefoxDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//            driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
        }
        else if(browser.equalsIgnoreCase("chrome"))
        {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
            log.info("Creating the object of "+ driver);
            this.driver = new ChromeDriver();
//            ngWebDriver = new NgWebDriver((JavascriptExecutor) driver);
//            //ngWebDriver.waitForAngularRequestsToFinish();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
    }

    public void getUrl(String url)
    {
        driver.manage().window().maximize();
        log.info("Navigating to : "+ url);
        driver.get(url);
        //ngWebDriver.waitForAngularRequestsToFinish();
    }

    public static void waitForElement(WebDriver driver) throws InterruptedException {


            try {
                log.info("inside waitForElement");
                new WebDriverWait(driver,20).until(ExpectedConditions.invisibilityOfElementLocated(By.tagName("mat-progress-spinner")));
            } catch (Exception e) {
                log.info("inside catch");
                e.printStackTrace();
                Thread.sleep(2000);

            }
    }

    public void getScreenShot(String name) {

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");


        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        try {
            String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath() + "\\src\\main\\java\\com\\fincash\\screenshots\\";
            File destFile = new File((String) reportDirectory + name + "_" + formater.format(calendar.getTime()) + ".png");
            FileUtils.copyFile(scrFile, destFile);
            // This will help us to link the screen shot in testNG report
           Reporter.log("<a href='" + destFile.getAbsolutePath() + "'> <img src='" + destFile.getAbsolutePath() + "' height='100' width='100'/> </a>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void checkPageIsReady() {

        JavascriptExecutor js = (JavascriptExecutor)driver;


        //Initially bellow given if condition will check ready state of page.
        if (js.executeScript("return document.readyState").toString().equals("complete")){
            log.info("Page Is loaded.");
            return;
        }

        //This loop will rotate for 25 times to check If page Is ready after every 1 second.
        //You can replace your value with 25 If you wants to Increase or decrease wait time.
        for (int i=0; i<25; i++){
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e) {}
            //To check page ready state.
            if (js.executeScript("return document.readyState").toString().equals("complete")){
                break;
            }
        }
    }
//    public boolean waitForJStoLoad() {
//
//        WebDriverWait wait = new WebDriverWait(driver, 30);
//
//        // wait for jQuery to load
//        ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
//            @Override
//            public Boolean apply(WebDriver driver) {
//                try {
//                    return ((Long)executeJavaScript("return jQuery.active") == 0);
//                }
//                catch (Exception e) {
//                    return true;
//                }
//            }
//        };
//
//        // wait for Javascript to load
//        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
//            @Override
//            public Boolean apply(WebDriver driver) {
//                return executeJavaScript("return document.readyState")
//                        .toString().equals("complete");
//            }
//        };
//
//        return wait.until(jQueryLoad) && wait.until(jsLoad);
//    }
}
