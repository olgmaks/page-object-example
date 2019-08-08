package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePageObject {

    protected WebDriver driver;

    public BasePageObject(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }
}
