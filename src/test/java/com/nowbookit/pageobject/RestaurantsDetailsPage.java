package com.nowbookit.pageobject;

import com.nowbookit.common.WebElementHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RestaurantsDetailsPage extends WebElementHelper {
    @FindBy(xpath = "//button[@ng-click=\"restaurantCtrl.openRestaurant()\"]")
    WebElement openRestaurantBtn;
    @FindBy(xpath = "//button[text() = 'Booking Widget']")
    WebElement bookingWidgetBtn;
    @FindBy(xpath = "//button[text() = 'Open Booking Widget']")
    WebElement openBookingWidgetBtn;

    public RestaurantsDetailsPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnOpenRestaurantButton(){
        waitElementVisibility(openRestaurantBtn, 10);
        openRestaurantBtn.click();
    }

    public void clickOnOpenBookingWidgetButton(){
        waitElementVisibility(bookingWidgetBtn, 5);
        bookingWidgetBtn.click();
        waitElementVisibility(openBookingWidgetBtn, 5);
        openBookingWidgetBtn.click();
    }
}
