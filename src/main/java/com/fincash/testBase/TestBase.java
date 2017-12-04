package com.fincash.testBase;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public static final Logger log = Logger.getLogger(TestBase.class.getName());

    public WebDriver driver;
    String browser = "chrome";
    String url = "https://api.fincash.com";

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
            driver = new FirefoxDriver();
        }
        else if(browser.equalsIgnoreCase("chrome"))
        {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
            log.info("Creating the object of "+ driver);
            driver = new ChromeDriver();
        }
    }

    public void getUrl(String url)
    {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        log.info("Navigating to : "+ url);
        driver.get(url);


    }
}
