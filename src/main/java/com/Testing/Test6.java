package com.Testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test6 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.automationtesting.in/Alerts.html");
        Thread.sleep(4000);

        driver.findElement(By.xpath("//*[@id=\"OKTab\"]/button")).click();
        Thread.sleep(2000);

        driver.switchTo().alert().accept();

        driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/ul/li[2]/a")).click();
        Thread.sleep(4000);

        driver.findElement(By.xpath("//*[@id=\"CancelTab\"]/button")).click();
        Thread.sleep(4000);

        driver.switchTo().alert().dismiss();
        Thread.sleep(4000);

    }
}
