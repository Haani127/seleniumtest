package Excel;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

public class logTesting2 {

    Logger log = Logger.getLogger(logTesting2.class);

    @Test
    public void test() {

        log.info("lowerfghj");
        log.error("lowerfghj");
    }


}
