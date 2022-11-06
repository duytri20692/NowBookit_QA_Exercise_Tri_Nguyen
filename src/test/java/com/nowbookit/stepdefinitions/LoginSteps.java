package com.nowbookit.stepdefinitions;

import com.nowbookit.common.BasePage;
import com.nowbookit.pageobject.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class LoginSteps extends BasePage {
    LoginPage loginPage = new LoginPage(driver);

    @Given("User Login to NBI application with Username and Password")
    public void userLoginToNBIApplicationWithUsernameAndPassword() {
        loginPage.loginWithUserAndPass(loginUser,loginPass);
    }

    @When("User navigates to Admin Portal page")
    public void userNavigatesToAdminPortalPage() {
        loginPage.clickOnConfirmAdminPortalButton();
    }
}
