package Excel;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

public class Test1 {


    public static WebDriver driver;

        @BeforeMethod
        public void urlLaunch () {
        System.setProperty("webdriver.chrome ", "D:\\Selenium\\chromedriver\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://www.finology.in/");

        }

        @Test
        public void Test () throws IOException {

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div[3]/a[4]")));
            loginBtn.click();

            String mobileNumber = number(); // your number() method should be in ExcelReader class

            WebElement mobileInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mobile")));
            mobileInput.sendKeys(mobileNumber);

            WebElement continueBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnNext")));
            continueBtn.click();

            WebElement otpMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//*[@id=\"frmVerification\"]/div[1]/label")));

            Assert.assertEquals(otpMessage.getText().trim(), "Enter OTP recieved on your Email/Mobile");
        }

        @AfterMethod
        public void closeBrowser () {
            if (driver != null) {
                driver.quit();
            }
        }


        public String number () throws IOException {
            FileInputStream fis = new FileInputStream("NumberData.xlsx");
            Workbook obj = new XSSFWorkbook(fis);
            Sheet sheet = obj.getSheetAt(0);
            Row r = sheet.getRow(0);

            // Since we stored as text, we use getStringCellValue()
            String num = r.getCell(0).getStringCellValue();

            obj.close();
            fis.close();

            return num;
        }

}

