package com.nowbookit.stepdefinitions;

import com.nowbookit.common.BasePage;
import com.nowbookit.pageobject.RestaurantsPage;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebDriver;

public class RestaurantsSteps extends BasePage {
    RestaurantsPage restaurantsPage = new RestaurantsPage(driver);

    @And("User click on Venue Name {string}")
    public void userClickOnVenueName(String venueName) {
        restaurantsPage.clickOnVenueName(venueName);
    }
}
