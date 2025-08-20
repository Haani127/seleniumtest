package com.Testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test4 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.shoppersstop.com/");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"headerId\"]/div/div/div[1]/div[1]/div/p")).click();
        Thread.sleep(2000);
        driver.quit();
    }
}
