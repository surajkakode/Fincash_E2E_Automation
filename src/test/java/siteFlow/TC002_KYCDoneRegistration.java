package siteFlow;

import com.fincash.testBase.TestBase;
import com.fincash.uiActions.Header;
import com.fincash.uiActions.LogIn;
import com.fincash.uiActions.Registration;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.log4testng.Logger;

public class TC002_KYCDoneRegistration extends TestBase {

    public static final Logger log = Logger.getLogger(TC002_KYCDoneRegistration.class.getClass());
    Header header;
    Registration registration;
    LogIn logIn;
    @BeforeTest
    public void setup()
    {
        init();
    }


    @Test(priority = 0)
    public void setRegistration() throws InterruptedException {
        header = new Header(driver);
        header.clickOnHeaderButton(header.login);
         logIn = new LogIn(driver);
        logIn.loginToApplication("suraj.kakode533@fincash.com","kakode92");
        header.waitForLogin();
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
        try {
            Assert.assertTrue(registration.isFormSubmitted());
        } catch (AssertionError e) {
            log.error(e,e);
        }
        log.info("running");
        registration.openForm(2);
        registration.setAddressType(2);
        registration.addressDetailsform("address line 1","address line 2", "123456","landmark","city","District");
        registration.setState(5);
        registration.setCountry(0);
        registration.submitFormNo(2);

        registration.openForm(3);
        registration.bankAccountForm("Account Holder name xyx","987654321098", "987654321098");
        registration.setIfscBankBranch("vashi",1);
        registration.submitFormNo(3);

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

        registration.openForm(5);
        registration.setNomineeName("Nominee name");
        registration.setNomineeRelation(2);
        registration.submitFormNo(5);
        registration.clickOnIAgreeCheckBox();
        registration.proceedToUpload.click();
        log.info("Form submitted : "+registration.isFormSubmitted());
        Assert.assertTrue(registration.isFormSubmitted());


}}
