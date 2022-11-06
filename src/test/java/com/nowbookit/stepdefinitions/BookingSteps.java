package com.nowbookit.stepdefinitions;

import com.nowbookit.common.BasePage;
import com.nowbookit.pageobject.BookingsPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class BookingSteps extends BasePage {
    BookingsPage bookingsPage = new BookingsPage(driver);

    @And("User should see the Booking page displaying")
    public void userShouldSeeTheBookingPageDisplaying() {
        Assert.assertTrue(bookingsPage.isBookingPageDisplaying(), "Booking Page does not display!");
    }

    @And("User click on New Walk In button")
    public void userClickOnNewWalkInButton() {
        bookingsPage.clickOnNewWalkInButton();
    }

    @And("User select table option is {string}")
    public void userSelectTableOptionIs(String tableOption) {
        bookingsPage.selectTableOption(tableOption);
    }

    @And("User click on Customer Walk in tab and input Name is {string}")
    public void userClickOnCustomerWalkInTabAndInputNameIs(String name) {
        bookingsPage.inputCustomerWalkInName(name);
    }

    @And("User input Booking note is {string}")
    public void userInputBookingNoteIs(String bookingNote) {
        bookingsPage.inputBookingNote(bookingNote);
    }

    @And("User click on Save button")
    public void userClickOnSaveButton() {
        bookingsPage.clickOnSaveButton();
    }

    @And("User open created booking with name is {string}")
    public void userOpenCreatedBookingWithNameIs(String createdName) {
        bookingsPage.openCreatedBookingSlot(createdName);
    }

    @Then("Users should see that the information they have entered is displayed correctly")
    public void usersShouldSeeThatTheInformationTheyHaveEnteredIsDisplayedCorrectly(DataTable table) {
        Assert.assertEquals(bookingsPage.getTableSeaterName().trim(), table.cell(1,1).trim());
        Assert.assertEquals(bookingsPage.getBookingNoteInSummaryTab().trim(), table.cell(2,1).trim());
        Assert.assertEquals(bookingsPage.getNameInDetailTab().trim(), table.cell(3,1).trim());
        Assert.assertEquals(bookingsPage.getBookingNoteInNotesBookingTab().trim(), table.cell(2,1).trim());
    }

    @And("User cancel above booking")
    public void userCancelAboveBooking() {
        bookingsPage.cancelABooking();
    }

    @Then("Users should see that the information they have entered by booking widget is displayed correctly")
    public void usersShouldSeeThatTheInformationTheyHaveEnteredByBookingWidgetIsDisplayedCorrectly(DataTable table) {
        Assert.assertEquals(bookingsPage.getNumberOfBookedPeople().trim(), table.cell(1,1).trim());
        Assert.assertEquals(bookingsPage.getTimeBooked().trim(), table.cell(2,1).trim());
        Assert.assertTrue(bookingsPage.getCustomerBookedInfo().trim().contains(table.cell(3,1).trim()));
        Assert.assertTrue(bookingsPage.getCustomerBookedInfo().trim().contains(table.cell(4,1).trim()));
        Assert.assertTrue(bookingsPage.getCustomerBookedInfo().trim().contains(table.cell(5,1).trim()));
        Assert.assertTrue(bookingsPage.getCustomerBookedInfo().trim().contains(table.cell(7,1).trim()));
        Assert.assertTrue(bookingsPage.getEmailBookedInChangesTab().trim().contains(table.cell(6,1).trim()));
    }
}
