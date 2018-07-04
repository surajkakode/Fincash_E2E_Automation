package Registration;

import com.fincash.testBase.TestBase;
import com.fincash.uiActions.Homepage;
import com.fincash.uiActions.Registration;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC007_AddressDetails extends TestBase {
    public static final Logger log = Logger.getLogger(TC006_registration.class.getName());

    Registration registration;

    @BeforeTest
    public void setup()
    {
        init();
    }

    @AfterTest
    public void endTest()
    {
        driver.quit();
    }

    @Test(priority = 0)
    public void setAddressDetails() throws InterruptedException {
        Homepage homepage = new Homepage(driver);
        homepage.loginToApplication("suraj.kakode533@fincash.com","kakode92");

        registration = new Registration(driver);

        registration.openForm(2);
        registration.setAddressType(2);
        registration.addressDetailsform("address line 1","address line 2", "123456","landmark","city","District");
        registration.setState(5);
        registration.setCountry(0);
        registration.submitFormNo(2);

    }
}
