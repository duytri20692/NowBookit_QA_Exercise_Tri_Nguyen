package com.nowbookit.stepdefinitions;

import com.nowbookit.common.BasePage;
import com.nowbookit.pageobject.RestaurantsDetailsPage;
import io.cucumber.java.en.And;

public class RestaurantsDetailsSteps extends BasePage {
    RestaurantsDetailsPage restaurantsDetailsPage = new RestaurantsDetailsPage(driver);

    @And("User click on open Restaurant button")
    public void userClickOnOpenRestaurantButton() {
        restaurantsDetailsPage.clickOnOpenRestaurantButton();
    }

    @And("User click on open Booking Widget")
    public void userClickOnOpenBookingWidget() {
        restaurantsDetailsPage.clickOnOpenBookingWidgetButton();
    }
}
