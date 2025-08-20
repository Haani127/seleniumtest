package com.Testing;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Set;

public class Test7 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.in/");
        WebElement hellosignIn = driver.findElement(By.id("nav-link-accountList-nav-line-1"));
        Actions action = new Actions(driver);
        action.moveToElement(hellosignIn).perform();
        driver.findElement(By.className("nav-action-inner")).click();
        driver.navigate().back();
        driver.findElement(By.cssSelector("input[type = 'text']")).sendKeys("Vivo v25" , Keys.ENTER);

        WebElement firstWin = driver.findElement(By.xpath("(//div[@data-asin and @data-asin != ''])[1]"));
        firstWin.click();
        WebElement firstLink = firstWin.findElement(By.xpath(".//a"));
        firstLink.click();
        String getWindow =  driver.getWindowHandle();
        driver.switchTo().window(getWindow);

        WebElement price = driver.findElement(By.id("btf_arenas"));
        System.out.println(price.getText());
        Thread.sleep(5000);
        driver.quit();
    }
}
