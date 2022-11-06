package com.nowbookit.pageobject;

import com.nowbookit.common.WebElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RestaurantsPage extends WebElementHelper {
    @FindBy(xpath = "//tr[@ng-show=\"!restaurantsCtrl.tableData.isLoading\"]")
    WebElement tableData;

    public RestaurantsPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnVenueName(String venueName){
        waitElementVisibility(tableData, 5);
        WebElement venueNameEle = driver.findElement(By.xpath("//td[text() = '" + venueName +"']"));
        venueNameEle.click();
    }
}
