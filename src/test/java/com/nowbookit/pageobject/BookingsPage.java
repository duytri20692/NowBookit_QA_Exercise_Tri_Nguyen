package com.nowbookit.pageobject;

import com.nowbookit.common.WebElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;

public class BookingsPage extends WebElementHelper {
    @FindBy(xpath = "//h2[text() = 'Bookings']")
    WebElement bookingPageHeader;
    @FindBy(xpath = "//button[@data-e2e=\"icon-buttonwalkIn\"]")
    WebElement newWalkInBtn;
    @FindBy(xpath = "//md-select[@ng-model=\"bookingNew.tableId\"]")
    WebElement tableDropdown;
    @FindBy(xpath = "//input[@name=\"firstName\"]")
    WebElement customerWalkInNameTxt;
    @FindBy(xpath = "//label[text() = 'Booking Notes']/..//textarea")
    WebElement bookingNoteTxt;
    @FindBy(xpath = "//*[text() = 'Save']")
    WebElement saveBtn;
    @FindBy(xpath = "//div[@id=\"table-seater-checkbox\"]//span")
    WebElement tableSeaterName;
    @FindBy(xpath = "//textarea[contains(@class, \"BookingOverview-MuiInputBase\")]")
    WebElement bookingNoteInSummaryTab;
    @FindBy(xpath = "//label[text()='Name']/..//input")
    WebElement nameInDetailTab;
    @FindBy(xpath = "//label[text() = 'Booking Notes']/..//div[@class=\"display\"]")
    WebElement bookingNoteInNotesBookingTab;
    @FindBy(xpath = "//md-select[@placeholder=\"Status\"]")
    WebElement bookingStatus;
    @FindBy(xpath = "//md-option[@value=\"Cancelled\"]")
    WebElement cancelOptionStatus;
    @FindBy(xpath = "//input[@ng-model=\"editBooking.booking.people\"]")
    WebElement numberOfBookedPeople;
    @FindBy(id = "time-selector")
    WebElement timeBooked;
    @FindBy(xpath = "//button[@ng-if=\"editBooking.customer\"]")
    WebElement customerBookedInfo;
    @FindBy(xpath = "//span[@ng-if=\"vm.comment\"]")
    WebElement customerBookedEmail;

    ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());

    public BookingsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isBookingPageDisplaying(){
        driver.switchTo().window(tabs2.get(1));
        waitElementVisibility(bookingPageHeader, 50);
        return bookingPageHeader.isDisplayed();
    }

    public void clickOnNewWalkInButton(){
        waitElementVisibility(newWalkInBtn, 5);
        newWalkInBtn.click();
    }

    public void selectTableOption(String tableOption){
        waitElementVisibility(tableDropdown, 5);
        tableDropdown.click();
        sleepInSeconds(1);
        WebElement tableOptionEle = driver.findElement(By.xpath("" +
                "(//div[contains(@id,'select_container_')])[2]//md-option/div[@class='md-text' and contains(text(), '"+ tableOption +"')]"));
        tableOptionEle.click();
    }

    public void inputCustomerWalkInName(String name){
        selectTabWithName("Customer");
        waitElementVisibility(customerWalkInNameTxt, 5);
        customerWalkInNameTxt.clear();
        customerWalkInNameTxt.sendKeys(name);
    }

    private void selectTabWithName(String tabName){
        WebElement tabEle = driver.findElement(By.xpath("//md-tab-item/span[contains(text(), '" + tabName + "')]"));
        tabEle.click();
    }

    public void inputBookingNote(String note){
        selectTabWithName("Notes");
        waitElementVisibility(bookingNoteTxt, 5);
        bookingNoteTxt.clear();
        bookingNoteTxt.sendKeys(note);
    }

    public void clickOnSaveButton(){
        saveBtn.click();
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ESCAPE).perform();
    }

    public void openCreatedBookingSlot(String createdBookingName){
        sleepInSeconds(2);
        WebElement createdNameEle = driver.findElement(By.xpath("//*[text() = '"+ createdBookingName + "']"));
        createdNameEle.click();
    }

    public String getTableSeaterName(){
        waitElementVisibility(tableSeaterName, 5);
        return tableSeaterName.getText();
    }

    public String getBookingNoteInSummaryTab(){
        selectTabWithNameInTheConfirmPopup("summary");
        waitElementVisibility(bookingNoteInSummaryTab, 5);
        return bookingNoteInSummaryTab.getText();
    }

    public String getNameInDetailTab(){
        selectTabWithNameInTheConfirmPopup("details");
        waitElementVisibility(nameInDetailTab, 5);
        return nameInDetailTab.getAttribute("value");
    }

    public String getBookingNoteInNotesBookingTab(){
        selectTabWithNameInTheConfirmPopup("notes");
        waitElementVisibility(bookingNoteInNotesBookingTab, 5);
        return bookingNoteInNotesBookingTab.getText();
    }

    private void selectTabWithNameInTheConfirmPopup(String tabName){
        sleepInSeconds(1);
        WebElement tabEle = driver.findElement(By.xpath("//md-tab-item//div[@data-e2e-tab-label=\"" + tabName + "\"]"));
        tabEle.click();
    }

    public void cancelABooking(){
        bookingStatus.click();
        cancelOptionStatus.click();
        saveBtn.click();
        sleepInSeconds(2);
    }

    public String getNumberOfBookedPeople(){
        waitElementVisibility(numberOfBookedPeople, 5);
        return numberOfBookedPeople.getAttribute("value");
    }

    public String getTimeBooked(){
        return timeBooked.getText();
    }

    public String getCustomerBookedInfo(){
        return customerBookedInfo.getText();
    }

    public String getEmailBookedInChangesTab(){
        selectTabWithNameInTheConfirmPopup("changes");
        waitElementVisibility(customerBookedEmail, 5);
        return customerBookedEmail.getText();
    }
}
