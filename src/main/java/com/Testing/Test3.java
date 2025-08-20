package com.Testing;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Test3 {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        try{
        driver.get("https://www.google.com");
        driver.manage().window().maximize();
        WebElement searchBox1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
        searchBox1.sendKeys("chrome.com");
        searchBox1.sendKeys(Keys.ENTER);
        Thread.sleep(9000);

        WebElement searchBox2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
        searchBox2.clear();
        searchBox2.sendKeys("example.com");
        searchBox2.sendKeys(Keys.ENTER);

        WebElement firstlink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//h3)[1]/ancestor::a")));
        firstlink.click();

            try {
                WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("loginBtn")));
                loginBtn.click();

                WebElement emailField = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("email")));
                emailField.sendKeys("test@example.com");

                WebElement passField = driver.findElement(By.name("password"));
                passField.sendKeys("123456");

                WebElement submitLogin = driver.findElement(By.xpath("//button[@type='submit']"));
                submitLogin.click();

                System.out.println("Login attempted.");
            }
            catch(Exception e){
                System.out.println("Login failed.");

                WebElement registerBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("registerBtn")));
                registerBtn.click();

                WebElement nameField = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("name")));
                nameField.sendKeys("Test User");

                WebElement emailReg = driver.findElement(By.name("email"));
                emailReg.sendKeys("test@example.com");

                WebElement passReg = driver.findElement(By.name("password"));
                passReg.sendKeys("123456");

                WebElement registerSubmit = driver.findElement(By.xpath("//button[@type='submit']"));
                registerSubmit.click();

                System.out.println("Registration attempted.");


            }

        } catch (Exception e) {
            System.out.println("Test failed: " + e.getMessage());
        } finally {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException ignored) {}

            driver.quit();
        }
    }
}