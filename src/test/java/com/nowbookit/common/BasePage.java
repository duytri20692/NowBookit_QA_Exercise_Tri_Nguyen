package com.nowbookit.common;

import org.openqa.selenium.WebDriver;

public class BasePage {
    public static WebDriver driver;
    private static String configPathFile = "src\\test\\resources\\testData\\Config.properties";
    protected static String baseURL = ReadPropertiesFileHelper.readPropertiesFile(configPathFile,"baseUrl");
    protected static String loginUser = ReadPropertiesFileHelper.readPropertiesFile(configPathFile,"loginUser");
    protected static String loginPass = ReadPropertiesFileHelper.readPropertiesFile(configPathFile,"loginPass");

}
