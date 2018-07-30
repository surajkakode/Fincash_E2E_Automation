package Experiment;

import com.fincash.testBase.TestBase;
import com.fincash.uiActions.Cart;
import com.fincash.uiActions.ExploreFunds;
import com.fincash.uiActions.Header;
import com.fincash.uiActions.LogIn;
import org.apache.log4j.Logger;
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
        header.clickOnCart();
        Cart cart = new Cart(driver);
        cart.clickOnInvestNow();
        LogIn logIn =new LogIn(driver);
        logIn.loginToApplication("b0pawan@gmail.com","asusW3jus");

    }
}
