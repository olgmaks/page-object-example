package com.pages;

import org.openqa.selenium.*;

public class PasswordPage {

    private WebDriver driver;

    public PasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterPassword(String password) {
        driver.findElement(By.name("password")).sendKeys(password);
    }

    public void submitPassword() {
        WebElement passwordNext = driver.findElement(By.id("passwordNext"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", passwordNext);
    }

    public boolean isPasswordFieldVisible() {
        try {
            return driver.findElement(By.name("password")).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
