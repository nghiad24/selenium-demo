package com.nghia;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginFailureTest {

    @Test
    public void loginFailure() {

        ChromeOptions options = new ChromeOptions();

        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        WebDriver driver = new ChromeDriver(options);

        driver.get("https://www.saucedemo.com");

        driver.findElement(By.id("user-name"))
                .sendKeys("standard_user");

        driver.findElement(By.id("password"))
                .sendKeys("12345678");

        driver.findElement(By.id("login-button"))
                .click();

        Assert.assertFalse(
                driver.getCurrentUrl().contains("inventory")
        );

        driver.quit();
    }
}
