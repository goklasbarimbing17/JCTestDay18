package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;

    public LoginPage() {
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//input[@id='username']")
    WebElement username;
    @FindBy(xpath = "//input[@id='password']")
    WebElement password;
    @FindBy(xpath = "//button[@name='login']")
    WebElement btnLogin;
    @FindBy(xpath = "//p[contains(text(),'Hello')]")
    WebElement txtDashboardPage;
    @FindBy(xpath = "//h2[normalize-space()='Login']")
    WebElement txtLoginPage;
    @FindBy(xpath = "//ul[@role='alert']//li")
    WebElement alertInvalidCredential;
    @FindBy(xpath = "//a[normalize-space()='Logout']")
    WebElement btnLogout;

    public void login(String username, String password){
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        this.btnLogin.click();
    }
    public String getTextDashboardPage(){
        return this.txtDashboardPage.getText();
    }
    public String getInvalidCredential(){
        return this.alertInvalidCredential.getText();
    }
    public void logout(){
        this.btnLogout.click();
    }
    public void clearUsername(){
        this.username.sendKeys(Keys.CONTROL+"a"+Keys.DELETE);
    }
}
