package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InboxPage extends BasePageObject{

    public InboxPage(WebDriver driver) {
        super(driver);
    }

    public String getAccountInnerHtml(String email) {
        WebElement accountLabel = driver.findElement(By.xpath("//a[contains(@aria-label, '" + email + "')]"));
        String innerHTML = accountLabel.getAttribute("innerHTML");
        return innerHTML;
    }

    public boolean isAccountLabelVisible(String email) {

        try {
            return driver.findElement(By.xpath("//a[contains(@aria-label, '" + email + "')]")).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
