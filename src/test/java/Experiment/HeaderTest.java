package Experiment;

import Registration.TC006_registration;
import com.fincash.testBase.TestBase;
import com.fincash.uiActions.Header;
import com.fincash.uiActions.LogIn;
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
        LogIn logIn = new LogIn(driver);

        logIn.loginToApplication("suraj.kakode533@fincash.com","kakode92");
        header.clickOnLogout();
        header.SearchFund("sbi blue chip");

        header.clickOnHeaderButton(header.calculators);
        header.clickOnSubHeaderButton(header.higherEducation);

        header.clickOnProductSolutions(header.smartSIP);
        Thread.sleep(3000);
        header.clickOnCalculators(header.higherEducation);
    }
}
