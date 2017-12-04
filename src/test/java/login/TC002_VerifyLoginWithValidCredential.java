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
    public void verifyLoginWithInValidCredential() throws InterruptedException {

        log.info("================ Starting verifyLoginWithValidCredential Test ");
        homepage = new Homepage(driver);
        homepage.loginToApplication("suraj.kakode@fincash.com","kakode92");
        Thread.sleep(5000);
        String actualTitle = driver.getTitle();
        log.info("Actual Title :"+ driver.getTitle());
        String ExpectedTitle = "Dashboard | Fincash.com";
        //boolean result = homepage.isLoggedIn();
        log.info("Actual Title :"+ actualTitle + " Expected is : "+ ExpectedTitle);
        Assert.assertEquals(actualTitle,ExpectedTitle);
        log.info("================ Finished verifyLoginWithValidCredential Test ");
    }

    @AfterTest
    public void endTest()
    {
        driver.close();
    }

}
