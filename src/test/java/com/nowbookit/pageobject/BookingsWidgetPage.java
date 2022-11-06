package com.nowbookit.pageobject;

import com.nowbookit.common.WebElementHelper;
import com.nowbookit.models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;

public class BookingsWidgetPage extends WebElementHelper {
    @FindBy(xpath = "//span[text() = 'Booking']")
    WebElement bookingWidgetPageProcess;
    @FindBy(xpath = "//button[@data-testid=\"plusBtn\"]")
    WebElement plusBtn;
    @FindBy(xpath = "//button[@data-testid=\"nextBtn\"]")
    WebElement nextBtn;
    @FindBy(id = "firstName")
    WebElement firstNameTxt;
    @FindBy(id = "lastName")
    WebElement lastNameTxt;
    @FindBy(name = "phone")
    WebElement mobileTxt;
    @FindBy(id = "email")
    WebElement emailTxt;
    @FindBy(id = "company")
    WebElement companyTxt;
    @FindBy(xpath = "//span[text()=\"I agree to the terms and conditions\"]")
    WebElement termsAndConCbx;

    ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());

    public BookingsWidgetPage(WebDriver driver) {
        super(driver);
    }

    public boolean isBookingWidgetPageDisplaying(){
        driver.switchTo().window(tabs2.get(1));
        waitElementVisibility(bookingWidgetPageProcess, 20);
        return bookingWidgetPageProcess.isDisplayed();
    }

    public void addNumberOfPeople(int number){
        waitElementVisibility(plusBtn, 10);
        for(int i = 0; i < number; i++){
            plusBtn.click();
        }
    }

    public void selectServiceByName(String name){
        sleepInSeconds(2);
        WebElement serviceNameCbx = driver.findElement(By.xpath("//span[text()='" + name + "']"));
        serviceNameCbx.click();
    }

    public void selectATime(String time){
        sleepInSeconds(1);
        WebElement timeBtn = driver.findElement(By.xpath("//span[text()='" + time + "']"));
        timeBtn.click();
    }

    public void clickOnNextButton(){
        waitElementVisibility(nextBtn, 5);
        nextBtn.click();
        sleepInSeconds(1);
    }

    public void inputUserDetailInfo(User user){
        waitElementVisibility(firstNameTxt, 5);
        firstNameTxt.clear();
        firstNameTxt.sendKeys(user.getFirstName());
        lastNameTxt.clear();
        lastNameTxt.sendKeys(user.getLastName());
        mobileTxt.clear();
        mobileTxt.sendKeys(user.getMobile());
        emailTxt.clear();
        emailTxt.sendKeys(user.getEmailAddress());
        if(companyTxt != null){
            companyTxt.clear();
            companyTxt.sendKeys(user.getCompany());
        }
        termsAndConCbx.click();
        nextBtn.click();
    }

    public void backToTheRestaurantsDetailPage(){
        driver.switchTo().window(tabs2.get(0));
    }
}
