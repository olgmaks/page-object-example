package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePageObject {

    @FindBy(xpath = "//*[@type='email']")
    private WebElement emailInput;

    @FindBy(id = "identifierNext")
    private WebElement submitEmailButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterEmail(String email) {
        emailInput.sendKeys(email);
    }

    public void submitEmail() {
        submitEmailButton.click();
    }

}
