package com.Testing;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome " , "D:\\Selenium\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://placement.skcet.ac.in/login");
        driver.manage().window().maximize();
        driver.findElement(By.id("email")).sendKeys("727723euit127@skcet.ac.in",Keys.ENTER);
        Thread.sleep(5000);
        driver.findElement(By.id("password")).sendKeys("Haani@5002", Keys.ENTER);
        Thread.sleep(10000);
        System.out.println(driver.getTitle());
        driver.quit();
    }
}