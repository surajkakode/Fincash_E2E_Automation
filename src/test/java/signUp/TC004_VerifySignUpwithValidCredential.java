package signUp;

import com.fincash.testBase.TestBase;
import com.fincash.uiActions.Header;
import com.fincash.uiActions.SignUp;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC004_VerifySignUpwithValidCredential extends TestBase {

    public static final Logger log = Logger.getLogger(TC004_VerifySignUpwithValidCredential.class.getName());
    Header header;
    SignUp signUp;
    @BeforeTest
    public void setup()
    {
        init();
    }
    @Test
    public void verifySignUpWithInValidCredential() throws InterruptedException {

        log.info("================ Starting verifySignUpWithInValidCredential Test ");
        header = new Header(driver);
        header.clickOnHeaderButton(header.signUp);
        signUp = new SignUp(driver);
        signUp.signUpToApplication("suraj.kakode@fincash.com","kakode92","kakode92");
        Thread.sleep(5000);

        Assert.assertEquals(signUp.isLoginSuccess(),false);
        log.info("================ Finished verifySignUpWithInValidCredential Test ");
    }



    @Test
    public void nullCredential() throws InterruptedException {

        log.info("================ Starting nullCredential Test ");
        header = new Header(driver);
        header.clickOnHeaderButton(header.signUp);
        signUp = new SignUp(driver);
        signUp.signUpToApplication(" "," "," ");
        Thread.sleep(5000);
        Assert.assertEquals(signUp.isLoginSuccess(),false);
        log.info("================ Finished nullCredential Test ");

    }

    @Test
    public void passwordMismach() throws InterruptedException {

        log.info("================ Starting passwordMismach Test ");
        header = new Header(driver);
        header.clickOnHeaderButton(header.signUp);
        signUp = new SignUp(driver);
        signUp.signUpToApplication("suraj.kakode1001@fincash.com","123456789","987654321");
        Thread.sleep(5000);
        Assert.assertEquals(signUp.isLoginSuccess(),false);
        log.info("================ Finished passwordMismach Test ");

    }

    @Test
    public void verifySignUpWithValidCredential() throws InterruptedException {

        log.info("================ Starting verifySignUpWithValidCredential Test ");
        header = new Header(driver);
        header.clickOnHeaderButton(header.signUp);
        signUp = new SignUp(driver);
        signUp.signUpToApplication("suraj.kakode616@fincash.com","kakode92","kakode92");
        Thread.sleep(5000);
        Assert.assertEquals(signUp.isLoginSuccess(),true);
        log.info("================ Finished verifySignUpWithValidCredential Test ");
    }

    @AfterTest
    public void endTest()
    {
        driver.quit();
    }

}
