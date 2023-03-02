package com.stepdefinitions;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.AddCartPage;
import com.juaracoding.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestAddCart {
    public static WebDriver driver;
    public LoginPage loginPage;
    public AddCartPage addCartPage;

    @BeforeClass
    public void setUp() {
        DriverSingleton.getInstance("chrome");
        driver = DriverSingleton.getDriver();
        loginPage = new LoginPage();
        addCartPage = new AddCartPage();
        driver.get("https://shop.demoqa.com/my-account/");
    }
    @AfterClass
    public void tearDown() {
        DriverSingleton.closeObjectInstance();
    }
    @Test
    public void testAddProductToCartValid() {
        loginPage.login("bimosakti", "BimoSakti123$");
        addCartPage.btnCart();
        addCartPage.btnShop();
        addCartPage.btnProduct();
        delay(2);
        addCartPage.quantity(2);
        addCartPage.selectProduct("black", "medium");
        delay(2);
        Assert.assertTrue(addCartPage.getTextAddProductToCart().contains("View cart\n"+
                "2 × “black ribbed short sleeve lettuce hem midi dress” have been added to your cart."));
        addCartPage.btnViewCart();
        delay(2);
        Assert.assertEquals(addCartPage.getTextProductName(),"BLACK RIBBED SHORT SLEEVE LETTUCE HEM MIDI DRESS - BLACK");
    }

    void delay(long second){
        try {
            Thread.sleep(second*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
