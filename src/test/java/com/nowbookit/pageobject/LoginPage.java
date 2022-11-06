package com.nowbookit.pageobject;

import com.nowbookit.common.WebElementHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends WebElementHelper {
    @FindBy(name = "username")
    WebElement emailTxt;
    @FindBy(name = "password")
    WebElement passTxt;
    @FindBy(xpath = "//button[@aria-label=\"login\"]")
    WebElement LoginBtn;
    @FindBy(xpath = "//button[@data-pendo=\"loginConfirmation-adminBtn\"]")
    WebElement AdminPortalConfirmBtn;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void inputEmail(String email){
        waitElementVisibility(emailTxt, 5);
        emailTxt.clear();
        emailTxt.sendKeys(email);
    }

    public void inputPass(String pass){
        passTxt.clear();
        passTxt.sendKeys(pass);
    }

    public void clickLogin(){
        LoginBtn.click();
    }

    public void clickOnConfirmAdminPortalButton(){
        waitElementVisibility(AdminPortalConfirmBtn, 10);
        AdminPortalConfirmBtn.click();
    }

    public void loginWithUserAndPass(String user, String pass){
        inputEmail(user);
        inputPass(pass);
        clickLogin();
    }
}
