package login;

import com.fincash.testBase.TestBase;
import com.fincash.uiActions.Homepage;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class TC001_VerifyLoginWithInvalidCredential extends TestBase {

    public static final Logger log = Logger.getLogger(TC001_VerifyLoginWithInvalidCredential.class.getName());

    Homepage homepage;

    @BeforeTest
    public void setup()
    {
        init();
    }

    @Test
    public void nullCredential() throws InterruptedException {

        log.info("================ Starting nullCredential Test ");
        homepage = new Homepage(driver);
        homepage.loginToApplication("","");
        Thread.sleep(5000);

        Assert.assertEquals(homepage.isLoginSuccess(),false);
        log.info("================ Finished nullCredential Test ");
    }
    @Test
    public void verifyLoginWithInValidCredential() throws InterruptedException {

        log.info("================ Starting verifyLoginWithInValidCredential Test ");
        homepage = new Homepage(driver);
        homepage.loginToApplication("suraj.kakode@fincaswh.com","kakode922");
        Thread.sleep(5000);

        Assert.assertEquals(homepage.isLoginSuccess(),false);
        log.info("================ Finished verifyLoginWithInValidCredential Test ");
    }

    @Test
    public void verifyLoginWithValidCredential() throws InterruptedException {

        log.info("================ Starting verifyLoginWithValidCredential Test ");
        homepage = new Homepage(driver);
        homepage.loginToApplication("suraj.kakode@fincash.com","kakode92w");
        Thread.sleep(5000);
        Assert.assertEquals(homepage.isLoginSuccess(),true);
        log.info("================ Finished verifyLoginWithValidCredential Test ");
    }

//    @AfterTest
//    public void endTest()
//    {
//        driver.quit();
//    }

}
