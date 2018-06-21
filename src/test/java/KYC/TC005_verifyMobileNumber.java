package KYC;

import com.fincash.testBase.TestBase;
import com.fincash.uiActions.Homepage;
import com.fincash.uiActions.KYC;
import com.fincash.uiActions.SignUp;
import org.apache.log4j.Logger;
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
        homepage.loginToApplication("suraj.kakode622@fincash.com","kakode92");


        Thread.sleep(5000);
        kyc = new KYC(driver);
        kyc.setMobileNumber("8892430032");
    }
    @Test
    public void changeMobileNumber() throws InterruptedException {
        // signUp = new SignUp(driver);
        //signUp.signUpToApplication("suraj.kakode622@fincash.com","kakode92","kakode92");

        homepage = new Homepage(driver);
        homepage.loginToApplication("suraj.kakode622@fincash.com","kakode92");


        Thread.sleep(5000);
        kyc = new KYC(driver);
        kyc.setMobileNumber("8892430031");
        ngWebDriver.waitForAngularRequestsToFinish();
        Thread.sleep(5000);
        kyc.dismissAlert();
        kyc.setMobileNumber("8892430032");
        Thread.sleep(5000);
        kyc.acceptAlert();

    }

//    @AfterTest
//    public void endTest()
//    {
//        driver.quit();
//    }

}
