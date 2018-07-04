package Registration;

import com.fincash.testBase.TestBase;
import com.fincash.uiActions.Homepage;
import com.fincash.uiActions.Registration;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC008_BankAccount extends TestBase {
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
    public void setBankAccount() throws InterruptedException {
        Homepage homepage = new Homepage(driver);
        homepage.loginToApplication("suraj.kakode533@fincash.com","kakode92");

        registration = new Registration(driver);

        registration.openForm(3);
        registration.bankAccountForm("Account Holder name","987654321098", "987654321098");
        registration.setIfscBankBranch("vashi",1);
        registration.submitFormNo(3);



    }
}