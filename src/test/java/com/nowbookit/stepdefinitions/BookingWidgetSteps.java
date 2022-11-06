package com.nowbookit.stepdefinitions;

import com.nowbookit.common.BasePage;
import com.nowbookit.models.User;
import com.nowbookit.pageobject.BookingsWidgetPage;
import com.nowbookit.pageobject.RestaurantsDetailsPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class BookingWidgetSteps extends BasePage {
    BookingsWidgetPage bookingsWidgetPage = new BookingsWidgetPage(driver);
    RestaurantsDetailsPage restaurantsDetailsPage = new RestaurantsDetailsPage(driver);

    @And("User should see the Booking Widget page displaying")
    public void userShouldSeeTheBookingWidgetPageDisplaying() {
        Assert.assertTrue(bookingsWidgetPage.isBookingWidgetPageDisplaying(), "Booking Widget Page does not display!");
    }

    @And("User click Plus button to add {string} people")
    public void userClickPlusButtonToAddPeople(String numberOfPeople) {
        bookingsWidgetPage.addNumberOfPeople(Integer.parseInt(numberOfPeople.trim()));
    }

    @And("User select service is {string}")
    public void userSelectServiceIs(String serviceName) {
        bookingsWidgetPage.selectServiceByName(serviceName);
    }

    @And("User select time is {string}")
    public void userSelectTimeIs(String time) {
        bookingsWidgetPage.selectATime(time);
    }

    @And("User click on Next button")
    public void userClickOnNextButton() {
        bookingsWidgetPage.clickOnNextButton();
    }

    @And("User click on Book Now button")
    public void userClickOnBookNowButton() {
        bookingsWidgetPage.clickOnNextButton();
        driver.close();
    }

    @And("User input detail information")
    public void userInputDetailInformation(DataTable dataTable) {
        User user = new User(dataTable.cell(1, 1), dataTable.cell(2, 1),
                dataTable.cell(3, 1), dataTable.cell(4, 1), dataTable.cell(5, 1));
        bookingsWidgetPage.inputUserDetailInfo(user);
    }

    @And("User back to the Restaurants detail page and click on open Restaurant button")
    public void userBackToTheRestaurantsDetailPageAndClickOnOpenRestaurantButton() {
        bookingsWidgetPage.backToTheRestaurantsDetailPage();
        restaurantsDetailsPage.clickOnOpenRestaurantButton();
    }
}
