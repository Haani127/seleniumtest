package com.Testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Test8 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.medplusmart.com/");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("a.nav-link.pointer")).click();
        Thread.sleep(1000);
//        driver.findElement(By.cssSelector("a.nav-link.pointer:nth-of-type(7)")).click();
        List<WebElement> links = driver.findElements(By.cssSelector("a.nav-link.pointer"));
        links.get(7).click();

        Thread.sleep(3000);
        driver.quit();
    }
}
