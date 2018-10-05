package login;

import com.fincash.testBase.TestBase;
import com.fincash.uiActions.Header;
import com.fincash.uiActions.LogIn;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
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

    @DataProvider(name = "Authentication")
    public static Object[][] credentials() {

        return new Object[][] { { "suraj.kakode@fincash.com", "kakode92" }, { "b0pawan@gmail.com", "asusW3jus" }};

    }

    @Test(dataProvider = "Authentication")
    public void verifyLoginWithValidCredential(String email, String password) throws InterruptedException {

        log.info("================ Starting verifyLoginWithValidCredential Test ");

        header = new Header(driver);
        header.clickOnHeaderButton(header.login);
        logIn = new LogIn(driver);
        logIn.loginToApplication(email,password);
        Assert.assertEquals(logIn.isLoginSuccess(),true);
        header.logout();
        log.info("================ Finished verifyLoginWithValidCredential Test ");
    }

    @AfterTest
    public void endTest()
    {
        driver.close();
    }

}
