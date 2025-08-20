package com.Testing;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com");
        System.out.println(driver.getTitle());
        System.out.println(driver.getTitle().length());
        driver.findElement(By.id("APjFqb")).sendKeys("Selenium software", Keys.ENTER);
        Thread.sleep(3000);
        
        driver.navigate().back();
        Thread.sleep(3000);
        driver.navigate().forward();
        if(driver.getTitle().equals("Selenium software")){
            driver.findElement(By.cssSelector("ul.mw-search-results li a")).click();
            Thread.sleep(3000);
        }
        System.out.println(driver.getPageSource());
        System.out.println(driver.getPageSource().length());
        driver.quit();
    }
}
