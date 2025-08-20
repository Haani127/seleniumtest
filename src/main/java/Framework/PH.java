package Framework;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class PH {

    public WebDriver driver;
@BeforeTest
public void beforeTest() {

}

@AfterTest
    public void afterTest() {
    if(driver != null){
        driver.quit();
    }
}
}
