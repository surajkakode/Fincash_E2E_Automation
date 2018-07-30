package Registration;

import com.fincash.testBase.TestBase;
import com.fincash.uiActions.Header;
import com.fincash.uiActions.LogIn;
import com.fincash.uiActions.Registration;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC006_registration extends TestBase {

    public static final Logger log = Logger.getLogger(TC006_registration.class.getName());
    Header header;
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
    public void setRegistration() throws InterruptedException {
        header = new Header(driver);
        header.clickOnHeaderButton(header.login);
        LogIn logIn = new LogIn(driver);
        logIn.loginToApplication("suraj.kakode533@fincash.com","kakode92");
        registration = new Registration(driver);
        registration.navigateToRegistrationPage();
        registration.openForm(1);
        registration.personalInformationForm("First Middle last","father full name", "mother full name","18/02/1990");
        registration.setTaxStatus(1);
        registration.clickOnRadioButton(2);
        registration.clickOnRadioButton(4);
        registration.submitFormNo(1);
        registration.proceedToUpload.click();
        log.info("Form submitted : "+registration.isFormSubmitted());
        Assert.assertEquals(registration.isFormSubmitted(),true);

    }
}
