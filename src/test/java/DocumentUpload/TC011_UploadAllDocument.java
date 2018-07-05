package DocumentUpload;

import Registration.TC006_registration;
import com.fincash.testBase.TestBase;
import com.fincash.uiActions.DocumentUpload;
import com.fincash.uiActions.Homepage;
import com.fincash.uiActions.Registration;
import org.apache.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC011_UploadAllDocument extends TestBase {
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
    public void uploadDocument() throws InterruptedException {
        Homepage homepage = new Homepage(driver);
        homepage.loginToApplication("suraj.kakode533@fincash.com","kakode92");

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

    }
}
