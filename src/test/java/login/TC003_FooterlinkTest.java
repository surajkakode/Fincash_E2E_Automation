package login;

import com.fincash.testBase.TestBase;
import com.fincash.uiActions.Footer;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC003_FooterlinkTest extends TestBase {

    public static final Logger log = Logger.getLogger(TC003_FooterlinkTest.class.getName());
    Footer footer;

    @BeforeTest
    public void setup()
    {
        init();
    }

    @Test
    public void clickOnFooter() throws InterruptedException {
        log.info("Starting clickOnFooter Test");
        footer =new Footer(driver);
        footer.clickOnAllElementOfFooter();
        log.info("Ending clickOnFooter Test");
    }

    @AfterTest
    public void endTest()
    {
        driver.quit();
    }
}
