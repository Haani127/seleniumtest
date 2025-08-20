package com.Testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test5 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.medplusmart.com/");
        driver.manage().window().maximize();
        Thread.sleep(4000);

        driver.findElement(By.cssSelector("#app > header > nav > ul > div.nav-scroll.d-flex > li:nth-child(1) > a\n")).click();
        Thread.sleep(4000);
        driver.findElement(By.cssSelector("#app > header > nav > ul > div.nav-scroll.d-flex > li:nth-child(8) > a\n")).click();
        Thread.sleep(4000);


    }
}
