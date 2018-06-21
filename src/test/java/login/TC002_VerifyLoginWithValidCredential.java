package login;

import com.fincash.testBase.TestBase;
import com.fincash.uiActions.Homepage;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC002_VerifyLoginWithValidCredential extends TestBase{

    public static final Logger log = Logger.getLogger(TC002_VerifyLoginWithValidCredential.class.getName());

    Homepage homepage;

    @BeforeTest
    public void setup()
    {
        init();
    }
    @Test
    public void verifyLoginWithValidCredential() throws InterruptedException {

        log.info("================ Starting verifyLoginWithValidCredential Test ");
        homepage = new Homepage(driver);
        homepage.loginToApplication("suraj.kakode@fincash.com","kakode92");
        Thread.sleep(5000);
        Assert.assertEquals(homepage.isLoginSuccess(),true);
        getScreenShot("SuccessLogin");
        log.info("================ Finished verifyLoginWithValidCredential Test ");
    }

    @AfterTest
    public void endTest()
    {
        driver.close();
    }

}
