package com.nowbookit.common;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Hooks extends BasePage{
    @Before
    public static void setupDriver() throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get(baseURL);
    }

    @After
    public static void quitDriver() throws Exception{
        driver.quit();
    }
}
