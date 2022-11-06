package com.nowbookit.testng.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        tags = "@BookingThroughNewWalkInFlow or @BookingThroughBookingWidgetFlow",
        features = "classpath:features",
        glue = {"com.nowbookit.common", "com.nowbookit.stepdefinitions", "com.nowbookit.testng.runner"},
        plugin = {"pretty", "json:target/cucumber-reports/cucumber.json", "html:target/cucumber-reports/cucumberreport.html"},
        monochrome = true
)
public class RunCucumberTest extends AbstractTestNGCucumberTests {
}
