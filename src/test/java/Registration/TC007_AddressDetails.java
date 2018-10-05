package Registration;

import com.fincash.testBase.TestBase;
import com.fincash.uiActions.Header;
import com.fincash.uiActions.LogIn;
import com.fincash.uiActions.Registration;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC007_AddressDetails extends TestBase {
    public static final Logger log = Logger.getLogger(TC006_registration.class.getName());

    Registration registration;
    Header header;

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
        header = new Header(driver);
        header.clickOnHeaderButton(header.login);
        LogIn logIn = new LogIn(driver);
        logIn.loginToApplication("suraj.kakode533@fincash.com","kakode92");
        header.waitForLogin();
        registration = new Registration(driver);
        registration.navigateToRegistrationPage();
        registration.openForm(2);
        registration.setAddressType(2);
        registration.addressDetailsform("address line 1","address line 2", "123456","landmark","city","District");
        registration.setState(5);
        registration.setCountry(0);
        registration.submitFormNo(2);

    }
}
