package Experiment;

import com.fincash.testBase.TestBase;
import com.fincash.uiActions.*;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ExploreTest extends TestBase {

    public static final Logger log = Logger.getLogger(ExploreTest.class.getName());

    ExploreFunds exploreFunds;
    Header header;

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
//        exploreFunds.clickOnAllAddToCart();
//        exploreFunds.clickOnAllAddToCart();
        exploreFunds.clickOnAllAddToCart(9);
        exploreFunds.clickOnAllAddToCart(15);
        Snackbar snackbar =new Snackbar(driver);
        snackbar.getSnackbarmessage();
        snackbar.clickOnButton();
        //snackbar.clickOnCheckout();
        Cart cart = new Cart(driver);
        cart.clickOnInvestNow();
        LogIn logIn =new LogIn(driver);
        logIn.loginToApplication("b0pawan@gmail.com","asusW3jus");
        InvestmentDetails investmentDetails = new InvestmentDetails(driver);
//        Thread.sleep(5000);
        investmentDetails.proceed();
        InvestmentSummary investmentSummary= new InvestmentSummary(driver);
        investmentSummary.clickOnCheckbox();
        investmentSummary.clickOnRadio(investmentSummary.neftRtgs);
        investmentSummary.clickOnProceed();
        investmentSummary.clickOnProceedDialog();
        BseStarMf bseStarMf =new BseStarMf(driver);
        bseStarMf.payUsingNeftRtgs();
        OrderComplete orderComplete=new OrderComplete(driver);
        Assert.assertEquals(orderComplete.isSuccess(),true);

        log.info("================ Finished Test ");

    }
}
