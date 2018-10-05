package com.fincash.shaadi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Shaadi {

    WebDriver driver;
    @Test
    public void registrationFlowIndia() throws InterruptedException {


        System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\Drivers\\geckodriver.exe");
        this.driver = new FirefoxDriver();
        driver.get("https://www.shaadi.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        WebElement loginButton = driver.findElement(By.xpath("//a[@type='login' and contains(text(),'Login')]"));
        loginButton.click();

        WebElement registrationButton = driver.findElement(By.xpath("//a[@type='registration' and contains(text(),'Sign Up Free')]"));
        new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(registrationButton));
        registrationButton.click();

        WebElement email;
        email= new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='text' and @name='email']")));
        email.clear();
        email.sendKeys("suraj.kakode1@shaadiTest.com");

        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        //password = new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='password' and @name='password1")));
        password.clear();
        password.sendKeys("surajkakode");


        ////a[@class='select2-choice']//span[@class='select2-chosen' and contains(text(),'Select')]
        WebElement select;
        select = new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='form_field_holder']//span[contains(text(),'Select') and @class='select2-chosen']")));
        select.click();

        List <WebElement> createProfileForDropdown = driver.findElements(By.xpath("//ul[@class='select2-results']/child::li"));
        createProfileForDropdown.get(1).click();

        //selectRadio("Male");
        WebElement radio = new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='radio' and @value='Male']")));
        radio.click();
        radio.click();

        driver.findElement(By.xpath("//a[contains(text(),'Next')]")).click();

        WebElement firstName ;
        firstName= new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='text' and @value='First Name']")));
        firstName.clear();
        firstName.sendKeys("Suraj");

        WebElement lastName = driver.findElement(By.xpath("//input[@type='text' and @value='Last Name']"));
        lastName.clear();
        lastName.sendKeys("kakode");

        WebElement day = driver.findElement(By.xpath("//span[@class='select2-chosen' and contains(text(),'Day')]"));
        day.click();
        List <WebElement> dayDropdown = driver.findElements(By.xpath("//ul[@class='select2-results']/child::li"));
        dayDropdown.get(12).click();


//        WebElement month =driver.findElement(By.xpath("//span[@class='select2-chosen' and contains(text(),'Month')]"));
//        month.click();
        List <WebElement> monthDropdown = driver.findElements(By.xpath("//ul[@class='select2-results']/child::li"));
        monthDropdown.get(8).click();

//        WebElement year = driver.findElement(By.xpath("//span[@class='select2-chosen' and contains(text(),'Year')]"));
//        year.click();
        List <WebElement> yearDropdown = driver.findElements(By.xpath("//ul[@class='select2-results']/child::li"));
        yearDropdown.get(6).click();

        WebElement religion = driver.findElement(By.xpath("//label[@for='community']/following-sibling::div"));
        religion.click();
        List <WebElement> religionDropdown = driver.findElements(By.xpath("//ul[@class='select2-results']/child::li"));
        religionDropdown.get(2).click();

        WebElement motherTongue = driver.findElement(By.xpath("//label[@for='mother_tongue']/following-sibling::div"));
        motherTongue.click();
        List <WebElement> motherTongueDropdown = driver.findElements(By.xpath("//ul[@class='select2-results']/child::li[3]//li"));
        motherTongueDropdown.get(6).click();

        WebElement country = driver.findElement(By.xpath("//label[@for='countryofresidence']/following-sibling::div"));
        country.click();
        List <WebElement> countryDropdown = driver.findElements(By.xpath("//ul[@class='select2-results']/child::li[3]//li"));
        countryDropdown.get(5).click();

        WebElement signUpButton = driver.findElement(By.xpath("//a[@id = 'btnSubmit' and contains(text(),'Sign Up')]"));
        signUpButton.click();

    }

    @Test
    public void registrationFlowUSA() throws InterruptedException {


        System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\Drivers\\geckodriver.exe");
        this.driver = new FirefoxDriver();
        driver.get("https://www.shaadi.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        WebElement loginButton = driver.findElement(By.xpath("//a[@type='login' and contains(text(),'Login')]"));
        loginButton.click();

        WebElement registrationButton = driver.findElement(By.xpath("//a[@type='registration' and contains(text(),'Sign Up Free')]"));
        new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(registrationButton));
        registrationButton.click();

        WebElement email;
        email= new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='text' and @name='email']")));
        email.clear();
        email.sendKeys("suraj.kakode1@shaadiTest.com");

        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        //password = new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='password' and @name='password1")));
        password.clear();
        password.sendKeys("surajkakode");


        ////a[@class='select2-choice']//span[@class='select2-chosen' and contains(text(),'Select')]
        WebElement select;
        select = new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='form_field_holder']//span[contains(text(),'Select') and @class='select2-chosen']")));
        select.click();

        List <WebElement> createProfileForDropdown = driver.findElements(By.xpath("//ul[@class='select2-results']/child::li"));
        createProfileForDropdown.get(1).click();

        //selectRadio("Male");
        WebElement radio = new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='radio' and @value='Male']")));
        radio.click();
        radio.click();

        driver.findElement(By.xpath("//a[contains(text(),'Next')]")).click();

        WebElement firstName ;
        firstName= new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='text' and @value='First Name']")));
        firstName.clear();
        firstName.sendKeys("Suraj");

        WebElement lastName = driver.findElement(By.xpath("//input[@type='text' and @value='Last Name']"));
        lastName.clear();
        lastName.sendKeys("kakode");

        WebElement day = driver.findElement(By.xpath("//span[@class='select2-chosen' and contains(text(),'Day')]"));
        day.click();
        List <WebElement> dayDropdown = driver.findElements(By.xpath("//ul[@class='select2-results']/child::li"));
        dayDropdown.get(12).click();


//        WebElement month =driver.findElement(By.xpath("//span[@class='select2-chosen' and contains(text(),'Month')]"));
//        month.click();
        List <WebElement> monthDropdown = driver.findElements(By.xpath("//ul[@class='select2-results']/child::li"));
        monthDropdown.get(8).click();

//        WebElement year = driver.findElement(By.xpath("//span[@class='select2-chosen' and contains(text(),'Year')]"));
//        year.click();
        List <WebElement> yearDropdown = driver.findElements(By.xpath("//ul[@class='select2-results']/child::li"));
        yearDropdown.get(6).click();

        WebElement religion = driver.findElement(By.xpath("//label[@for='community']/following-sibling::div"));
        religion.click();
        List <WebElement> religionDropdown = driver.findElements(By.xpath("//ul[@class='select2-results']/child::li"));
        religionDropdown.get(2).click();

        WebElement motherTongue = driver.findElement(By.xpath("//label[@for='mother_tongue']/following-sibling::div"));
        motherTongue.click();
        List <WebElement> motherTongueDropdown = driver.findElements(By.xpath("//ul[@class='select2-results']/child::li[3]//li"));
        motherTongueDropdown.get(6).click();

        WebElement country = driver.findElement(By.xpath("//label[@for='countryofresidence']/following-sibling::div"));
        country.click();
        List <WebElement> countryDropdown = driver.findElements(By.xpath("//ul[@class='select2-results']/child::li[3]//li"));
        countryDropdown.get(5).click();

        WebElement signUpButton = driver.findElement(By.xpath("//a[@id = 'btnSubmit' and contains(text(),'Sign Up')]"));
        signUpButton.click();

    }

}
