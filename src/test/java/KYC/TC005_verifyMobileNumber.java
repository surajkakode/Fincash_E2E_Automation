package KYC;

import com.fincash.testBase.TestBase;
import com.fincash.uiActions.Homepage;
import com.fincash.uiActions.KYC;
import com.fincash.uiActions.SignUp;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC005_verifyMobileNumber extends TestBase{

    public static final Logger log= Logger.getLogger(TC005_verifyMobileNumber.class.getName());

    SignUp signUp;
    KYC kyc;
    Homepage homepage;

    @BeforeTest
    public void setup()
    {
        init();
    }

    @Test(enabled = false)
    public void verifyMobileNumber() throws InterruptedException {
       // signUp = new SignUp(driver);
        //signUp.signUpToApplication("suraj.kakode622@fincash.com","kakode92","kakode92");

        homepage = new Homepage(driver);
        homepage.loginToApplication("suraj.kakode621@fincash.com","kakode92");


        Thread.sleep(5000);
        kyc = new KYC(driver);
        kyc.setMobileNumber("8892430032");
    }
    @Test(priority = 1)
    public void changeMobileNumber() throws InterruptedException {

//        homepage = new Homepage(driver);
//        homepage.loginToApplication("suraj.kakode621@fincash.com","kakode92");
//        Thread.sleep(5000);

        kyc = new KYC(driver);
        kyc.setCountry(0);
        kyc.setMobileNumber("8892430031");
//        kyc.dismissButton();
//        kyc.setMobileNumber("8892430032");
        kyc.acceptButton();
        kyc.setOTP("887799");


    }

    @Test(priority = 2)
    public void changePan() throws InterruptedException {
        // signUp = new SignUp(driver);
        //signUp.signUpToApplication("suraj.kakode622@fincash.com","kakode92","kakode92");
//
//        homepage = new Homepage(driver);
//        homepage.loginToApplication("suraj.kakode623@fincash.com","kakode92");
//
//
//        Thread.sleep(5000);
//        kyc = new KYC(driver);
        kyc.setPan("cgcpk5110f");
//        kyc.dismissButton();
//        kyc.setPan("cgcpk5110h");
        kyc.acceptButton();


    }

    @Test(enabled = false)
    public void proceedToEkyc()
    {
        kyc.proceedToEkyc();
        driver.getTitle();
        Assert.assertEquals(driver.getTitle(),"Aadhaar eKYC | Register Your Aadhaar Online");
    }

    @Test(priority = 4)
    public void proceedToReg()
    {
        kyc.proceedToReg();
        driver.getTitle();
        Assert.assertEquals(driver.getTitle(),"Registration | Fincash.com");
    }

    @Test(priority = 0,enabled = true)
    public void clickOnEachCountry() throws InterruptedException {
        homepage = new Homepage(driver);
        homepage.loginToApplication("suraj.kakode621@fincash.com","kakode92");
        Thread.sleep(5000);
        kyc = new KYC(driver);
        try {
            for (int i=0;i<250;i++)
            {
                kyc.setCountry(i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @AfterTest
    public void endTest()
    {
        driver.quit();
    }

}
