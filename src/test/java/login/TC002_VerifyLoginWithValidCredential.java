package login;

import com.fincash.testBase.TestBase;
import com.fincash.uiActions.Header;
import com.fincash.uiActions.LogIn;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC002_VerifyLoginWithValidCredential extends TestBase{

    public static final Logger log = Logger.getLogger(TC002_VerifyLoginWithValidCredential.class.getName());

    LogIn logIn;
    Header header;

    @BeforeTest
    public void setup()
    {
        init();
    }
    @Test
    public void verifyLoginWithValidCredential() throws InterruptedException {

        log.info("================ Starting verifyLoginWithValidCredential Test ");

        header = new Header(driver);
        header.clickOnHeaderButton(header.login);        logIn = new LogIn(driver);
        logIn.loginToApplication("suraj.kakode@fincash.com","kakode92");
        Thread.sleep(5000);
        Assert.assertEquals(logIn.isLoginSuccess(),true);
        log.info("================ Finished verifyLoginWithValidCredential Test ");
    }

    @AfterTest
    public void endTest()
    {
        driver.close();
    }

}
