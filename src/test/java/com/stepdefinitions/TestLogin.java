package com.stepdefinitions;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestLogin {
    public static WebDriver driver;
    public LoginPage loginPage;

    @BeforeClass
    public void setUp() {
        DriverSingleton.getInstance("chrome");
        driver = DriverSingleton.getDriver();
        loginPage = new LoginPage();
        driver.get("https://shop.demoqa.com/my-account/");
    }
    @AfterClass
    public void tearDown() {
        DriverSingleton.closeObjectInstance();
    }
    @Test
    public void testLoginValid() {
        loginPage.login("bimosakti", "BimoSakti123$");
        Assert.assertEquals(loginPage.getTextDashboardPage(), "Hello bimosakti (not bimosakti? Log out)");
        loginPage.logout();
    }
    @Test (priority = 1)
    public void testLoginInvalidUsername(){
        loginPage.login("bimosaktiiii", "BimoSakti123$");
        Assert.assertEquals(loginPage.getInvalidCredential(), "ERROR: The username or password you entered is incorrect. Lost your password?");
    }
    @Test (priority = 2)
    public void testLoginInvalidPassword(){
        loginPage.login("bimosakti", "BimoSakti3$");
        Assert.assertEquals(loginPage.getInvalidCredential(), "ERROR: The username or password you entered is incorrect. Lost your password?");
    }
    @Test (priority = 3)
    public void testLoginInvalidUsernameNull(){
        loginPage.clearUsername();
        loginPage.login("", "BimoSakti123$");
        Assert.assertEquals(loginPage.getInvalidCredential(), "Error: Username is required.");
    }
    @Test (priority = 4)
    public void testLoginInvalidPasswordNull(){
        loginPage.login("bimosakti", "");
        Assert.assertEquals(loginPage.getInvalidCredential(), "Error: The password field is empty.");
    }
    @Test (priority = 5)
    public void testLoginInvalidUsernamePasswordNull(){
        loginPage.clearUsername();
        loginPage.login("", "");
        Assert.assertEquals(loginPage.getInvalidCredential(), "Error: Username is required.");
    }
}
