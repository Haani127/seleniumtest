package Framework;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v136.page.model.Screenshot;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DC {

public WebDriver driver;
@BeforeTest
    public void beforeTest() {
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("https://magento.softwaretestingboard.com/");

}

@Test
public void Test1() throws InterruptedException {

    WebElement search = driver.findElement(By.id("search"));
    search.sendKeys("Shoe", Keys.ENTER);
    Thread.sleep(5000);
    WebElement result = driver.findElement(By.xpath("//span[@class=\"base\"]"));
    String text = result.getText();
    Thread.sleep(2000);
    Assert.assertEquals(text, "Search results for: 'Shoe'");
    TakesScreenshot ts = (TakesScreenshot) driver;

    try{

        File dest = new File("src\\main\\java\\Framework\\Screenshot\\screenshot.png");
        File src = ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, dest);
    }
    catch (Exception e){
        e.printStackTrace();
    }
}

@Test
public void Test2() throws IOException, InterruptedException {
    WebElement search = driver.findElement(By.id("search"));
    search.clear();
    FileInputStream fis = new FileInputStream("src/main/java/Framework/data/data.xlsx");
    Workbook wb = new XSSFWorkbook(fis);
    Sheet sheet = wb.getSheetAt(0);
    Row row = sheet.getRow(0);
    String itm = row.getCell(0).getStringCellValue();
    search.sendKeys(itm, Keys.ENTER);
    Thread.sleep(5000);
    WebElement result = driver.findElement(By.xpath("//span[@class=\"base\"]"));
    String text = result.getText();
    Assert.assertTrue(text.contains(itm), "Expected hoodie");
    TakesScreenshot ts = (TakesScreenshot) driver;

    try{
        File dest = new File("src\\main\\java\\Framework\\Screenshot\\screenshot2.png");
        File src = ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src,dest);
    }
    catch(Exception e){
        e.printStackTrace();
    }

}

@Test
public void Test3() throws InterruptedException {

    WebElement product = driver.findElement(By.className("product-image-photo"));
    product.click();
    Thread.sleep(5000);
    WebElement size = driver.findElement(By.xpath("(//div[@class=\"swatch-option text\"])[4]"));
    size.click();
    WebElement color = driver.findElement(By.xpath("//div[@class=\"swatch-option color\"]"));
    color.click();
    Thread.sleep(2000);
    WebElement cart = driver.findElement(By.id("product-addtocart-button"));
    TakesScreenshot ts = (TakesScreenshot) driver;


    try{
        File dest = new File("src\\main\\java\\Framework\\Screenshot\\screenshot3.png");
        File src = ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src,dest);

    }
    catch (Exception e){
        e.printStackTrace();
    }
}

@AfterTest
    public void afterTest() {
    if(driver != null){
        driver.quit();
    }
}

}
