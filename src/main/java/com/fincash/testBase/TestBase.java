package com.fincash.testBase;


import com.fincash.customListener.WebEventListener;
import com.paulhammant.ngwebdriver.NgWebDriver;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class TestBase {

    public static final Logger log = Logger.getLogger(TestBase.class.getName());

    public static WebDriver dr;
    public static EventFiringWebDriver driver;
    public WebEventListener eventListener;
    public static NgWebDriver ngWebDriver;
    public static String url = null;

    Properties properties =new Properties();
    public static ExtentReports extent;
    public static ExtentTest test;
    public ITestResult result;


    public void loadData() throws IOException {
        try {
            File file= new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\fincash\\config\\properties");
            FileInputStream fileInputStream = new FileInputStream(file);
            properties.load(fileInputStream);
        } catch (IOException e) {
            log.info(e,e);
        }
    }
    static {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
        extent = new ExtentReports(System.getProperty("user.dir")+"\\src\\main\\java\\com\\fincash\\reports\\test" + formater.format(calendar.getTime()) + ".html", false);
    }

    public void init()
    {
        try {
            loadData();
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.url = properties.getProperty("url");
        selectBrowser(properties.getProperty("browser"));
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
            this.dr = new FirefoxDriver();
            driver = new EventFiringWebDriver(dr);
            eventListener = new WebEventListener();
            //driver.register(eventListener);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//            driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
        }
        else if(browser.equalsIgnoreCase("chrome"))
        {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
            log.info("Creating the object of "+ driver);
            this.dr = new ChromeDriver();
            driver = new EventFiringWebDriver(dr);
            eventListener = new WebEventListener();
          //  driver.register(eventListener);
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
public String captureScreen(String fileName) {
    if (fileName == "") {
        fileName = "blank";
    }
    File destFile = null;
    Calendar calendar = Calendar.getInstance();
    SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");

    File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

    try {
        String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath() + "\\src\\main\\java\\com\\fincash\\screenshots\\failedScreenshots\\failure_screenshots";
        destFile = new File((String) reportDirectory + fileName + "_" + formater.format(calendar.getTime()) + ".png");
        FileUtils.copyFile(scrFile, destFile);
        // This will help us to link the screen shot in testNG report
        Reporter.log("<a href='" + destFile.getAbsolutePath() + "'> <img src='" + destFile.getAbsolutePath() + "' height='100' width='100'/> </a>");
    } catch (IOException e) {
        e.printStackTrace();
    }
    return destFile.toString();
}

    public void log(String data) {
        log.info(data);
        Reporter.log(data);
        test.log(LogStatus.INFO, data);
    }

    public void getresult(ITestResult result) {
        if (result.getStatus() == ITestResult.SUCCESS) {
            test.log(LogStatus.PASS, result.getName() + " test is pass");
        } else if (result.getStatus() == ITestResult.SKIP) {
            test.log(LogStatus.SKIP, result.getName() + " test is skipped and skip reason is:-" + result.getThrowable());
        } else if (result.getStatus() == ITestResult.FAILURE) {
            test.log(LogStatus.ERROR, result.getName() + " test is failed" + result.getThrowable());
            String screen = captureScreen("");
            test.log(LogStatus.FAIL, test.addScreenCapture(screen));
        } else if (result.getStatus() == ITestResult.STARTED) {
            test.log(LogStatus.INFO, result.getName() + " test is started");
        }
    }

    @AfterMethod()
    public void afterMethod(ITestResult result) {
        getresult(result);
    }

    @BeforeMethod()
    public void beforeMethod(Method result) {
        test = extent.startTest(result.getName());
        test.log(LogStatus.INFO, result.getName() + " test Started");
    }

    @AfterClass(alwaysRun = true)
    public void endTest() {
        closeBrowser();
    }

    public void closeBrowser() {
        //driver.quit();
        log.info("browser closed");
        extent.endTest(test);
        extent.flush();
    }
}
