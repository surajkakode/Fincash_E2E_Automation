package DocumentUpload;

import Registration.TC006_registration;
import com.fincash.testBase.TestBase;
import com.fincash.uiActions.Complete;
import com.fincash.uiActions.DocumentUpload;
import com.fincash.uiActions.Homepage;
import com.fincash.uiActions.Registration;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC001_nullDocument extends TestBase {
    public static final Logger log = Logger.getLogger(TC006_registration.class.getName());

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
        Homepage homepage = new Homepage(driver);
        homepage.loginToApplication("suraj.kakode533@fincash.com","kakode92");

        DocumentUpload upload =new DocumentUpload(driver);
        upload.navigateToDocumentUploadPage();
        upload.uploadPicture(" ");
        upload.uploadPan(" ");
        upload.uploadProofOfForeignAddress(2," ");
        upload.uploadProofOfIndianAddress(3," ");
        upload.uploadPassport(" ");
        upload.uploadSignature(" ");
        upload.uploadCheque(1,"");
        upload.proceedButton.click();
        Complete complete = new Complete(driver);
        Assert.assertEquals(complete.isSuccessful(),false);

    }
}

