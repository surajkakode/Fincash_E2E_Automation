package Registration;

import com.fincash.testBase.TestBase;
import com.fincash.uiActions.Header;
import com.fincash.uiActions.LogIn;
import com.fincash.uiActions.Registration;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC009_Fatca extends TestBase{

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
    public void setFatca() throws InterruptedException {
        header = new Header(driver);
        header.clickOnHeaderButton(header.login);
        LogIn logIn = new LogIn(driver);
        logIn.loginToApplication("suraj.kakode533@fincash.com","kakode92");
        header.waitForLogin();
        registration = new Registration(driver);
        registration.navigateToRegistrationPage();
        registration.openForm(4);
        registration.setIncome(2);
        registration.setOccupation(2);
        registration.setSourceOfWealth(2);
        registration.setNationality(2);
        registration.setBirthCountry(2);
        registration.setBirthCity("birth city");
        registration.setTaxCountry(2);
        registration.clickOnRadioButton(7);
        registration.clickOnRadioButton(9);
        registration.submitFormNo(4);

    }
}
