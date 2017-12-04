package Experiment;

import com.fincash.testBase.TestBase;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

public class RoughWork extends TestBase {

    public static final Logger log = Logger.getLogger(RoughWork.class.getName());

    @Test
    public void roughWork()
    {
        init();
        log.info("This class is for rough work--- Logger");
        System.out.println("This class is for rough work");
    }
}
