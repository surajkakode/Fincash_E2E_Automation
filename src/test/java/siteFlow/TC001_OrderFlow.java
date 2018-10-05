package siteFlow;

import com.fincash.testBase.TestBase;
import com.fincash.uiActions.*;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC001_OrderFlow extends TestBase {

    public static final Logger log = Logger.getLogger(TC001_OrderFlow.class.getName());

    Header header;
    ExploreFunds exploreFunds;
    Snackbar snackbar;
    Cart cart;
    LogIn logIn;
    InvestmentDetails investmentDetails;
    InvestmentSummary investmentSummary;
    BseStarMf bseStarMf;
    OrderComplete orderComplete;


    @BeforeTest
    public void setup()
    {

        init();
    }

    @Test
    public void addToCartButtonTest() throws InterruptedException {

        header = new Header(driver);
        header.clickOnHeaderButton(header.exploreFunds);
        exploreFunds=new ExploreFunds(driver);
        exploreFunds.clickOnAllAddToCart(9);
        snackbar =new Snackbar(driver);
        snackbar.getSnackbarmessage();
        snackbar.clickOnButton();
        cart= new Cart(driver);
        cart.clickOnInvestNow();
        logIn =new LogIn(driver);
        logIn.loginToApplication("b0pawan@gmail.com","asusW3jus");
        investmentDetails = new InvestmentDetails(driver);
        investmentDetails.proceed();
        investmentSummary= new InvestmentSummary(driver);
        investmentSummary.clickOnCheckbox();
        investmentSummary.clickOnRadio(investmentSummary.neftRtgs);
        investmentSummary.clickOnProceed();
        investmentSummary.clickOnProceedDialog();
        bseStarMf =new BseStarMf(driver);
        bseStarMf.payUsingNeftRtgs();
        orderComplete=new OrderComplete(driver);
        try {
            Assert.assertEquals(orderComplete.isSuccess(),true);
            log.info("Test Passed");
        } catch (Exception e) {
            e.printStackTrace();
            log.info("Test Failed");
        }

        log.info("================ Finished Test============= ");

    }
}