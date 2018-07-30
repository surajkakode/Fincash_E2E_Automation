package DocumentUpload;

import Registration.TC006_registration;
import com.fincash.testBase.TestBase;
import com.fincash.uiActions.*;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC011_UploadAllDocument extends TestBase {
    public static final Logger log = Logger.getLogger(TC006_registration.class.getName());
    Header header;
    Registration registration;

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

    @Test(priority = 0)
    public void uploadDocument() throws InterruptedException {
        header = new Header(driver);
        header.clickOnHeaderButton(header.login);
        LogIn logIn = new LogIn(driver);
        logIn.loginToApplication("suraj.kakode533@fincash.com","kakode92");

        DocumentUpload upload =new DocumentUpload(driver);
        upload.navigateToDocumentUploadPage();
        upload.uploadPicture("D:\\Testimonials.JPG");
        upload.uploadPan("D:\\Testimonials.JPG");
        upload.uploadProofOfForeignAddress(2,"D:\\Testimonials.JPG");
        upload.uploadProofOfIndianAddress(3,"D:\\Testimonials.JPG");
        upload.uploadPassport("D:\\Testimonials.JPG");
        upload.uploadSignature("D:\\Testimonials.JPG");
        upload.uploadCheque(1,"D:\\Testimonials.JPG");
        upload.proceedButton.click();
        Complete complete = new Complete(driver);
        Assert.assertEquals(complete.isSuccessful(),true);

    }
}
