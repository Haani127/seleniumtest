package Excel;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

public class logTesting {
    Logger log = Logger.getLogger(logTesting.class);

    @Test
    public void test() {
        log.info("Logging testing");
        log.error("Logging error");
        log.warn("Logging warn");
    }
}
