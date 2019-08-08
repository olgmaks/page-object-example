package com.gmail.login;

import com.pages.InboxPage;
import com.pages.LoginPage;
import com.pages.PasswordPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTest {

    private static final String GMAIN_LOGIN_URL = "https://accounts.google.com/AccountChooser?service=mail&continue=https://mail.google.com/mail/";
    private static final String LOGIN = "babayagaga884@gmail.com";
    private static final String PASSWORD = "baba2015";

    private WebDriver driver;
    private LoginPage loginPage;
    private PasswordPage passwordPage;
    private InboxPage inboxPage;

    @BeforeMethod
    public void setUpBrowser() {
        // setup driver
        WebDriverManager.chromedriver().setup();

        // create driver
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        loginPage = new LoginPage(driver);
        passwordPage = new PasswordPage(driver);
        inboxPage = new InboxPage(driver);

        // Given
        // open login page
        driver.navigate().to(GMAIN_LOGIN_URL);
    }

    @AfterMethod
    public void tearDownBrowser() {
        // exit browser
        driver.quit();

        // close current window
//        driver.close();
    }

    @Test(description = "01.02.03 - Verify ability for user to login into mail box")
    public void testLogin_Positive() {

        // When
        // type user name
        loginPage.enterEmail(LOGIN);

        // And
        // click login button
        loginPage.submitEmail();

        // And
        // type password
        passwordPage.enterPassword(PASSWORD);

        // And
        // click submit password button
        passwordPage.submitPassword();

        // Then
        // account label present on the page
        Assert.assertTrue(
                inboxPage.getAccountInnerHtml(LOGIN).contains("span"), "Invalid account label content");
    }

    @Test(description = "01.02.03 - Verify inability for user to login with invalid email")
    public void login_with_invalid_email_Negative() {

        loginPage.enterEmail("google.com");

        loginPage.submitEmail();

        Assert.assertFalse(passwordPage.isPasswordFieldVisible(), "Password is visible but should not be");
    }

    @Test(description = "01.02.03 - Verify inability for user to login with invalid password")
    public void login_with_invalid_password_Negative() {

        loginPage.enterEmail(LOGIN);

        loginPage.submitEmail();

        passwordPage.enterPassword("qsfref");

        passwordPage.submitPassword();

        Assert.assertFalse(inboxPage.isAccountLabelVisible(LOGIN), "Inbox login success but should not be");
    }
}
