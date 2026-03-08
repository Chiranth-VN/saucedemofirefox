package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class App {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.gecko.driver", "/usr/bin/geckodriver");

        FirefoxOptions options = new FirefoxOptions();
        options.setBinary("/usr/bin/firefox");

        WebDriver driver = new FirefoxDriver(options);

        // Open SauceDemo
        driver.get("https://www.saucedemo.com");

        Thread.sleep(2000);

        // Enter username
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        // Enter password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        Thread.sleep(1000);

        // Click login
        driver.findElement(By.id("login-button")).click();

        Thread.sleep(3000);

        System.out.println("Login Successful. Page Title: " + driver.getTitle());

        driver.quit();
    }
}
