package Experiment;

import Registration.TC006_registration;
import com.fincash.testBase.TestBase;
import com.fincash.uiActions.Header;
import com.fincash.uiActions.Homepage;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HeaderTest extends TestBase {

    public static final Logger log = Logger.getLogger(TC006_registration.class.getName());

    Header header;

    @BeforeTest
    public void setup()
    {
        init();
    }

//    @AfterTest
//    public void endTest()
//    {
//        driver.quit();
//    }

    @Test
    public void headeraTest() throws InterruptedException {
        Header header = new Header(driver);
        Homepage homepage = new Homepage(driver);

        homepage.loginToApplication("suraj.kakode533@fincash.com","kakode92");
        header.clickOnLogout();
    }
}
