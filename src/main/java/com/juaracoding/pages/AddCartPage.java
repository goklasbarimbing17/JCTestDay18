package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import net.bytebuddy.implementation.bind.annotation.FieldProxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCartPage {
    private WebDriver driver;
    private Select selectObjek;

    public AddCartPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//i[@class='icon_bag_alt']")
    WebElement btnCart;
    @FindBy(xpath = "//a[normalize-space()='Return to shop']")
    WebElement btnReturnToShop;
    @FindBy(xpath = "//a[normalize-space()='continue shopping']" )
    WebElement btnContinueShop;
    @FindBy(xpath = "//div[@class='noo-product-item one noo-product-sm-4 not_featured post-1441 product type-product status-publish has-post-thumbnail product_cat-bodycon-dresses product_tag-bodycon-dresses product_tag-women has-featured last instock shipping-taxable purchasable product-type-variable']//div[@class='owl-item active']//img[@class='product-one-thumb']")
    WebElement btnProduct;
    @FindBy(xpath = "//select[@id='pa_color']")
    WebElement color;
    @FindBy(xpath = "//select[@id='pa_size']")
    WebElement size;
    @FindBy(xpath = "//*[@id=\"product-1441\"]/div[1]/div[2]/form/div/div[2]/div/div/button[2]/i")
    WebElement quantity;
    @FindBy(xpath = "//button[normalize-space()='Add to cart']")
    WebElement btnAddToCart;
    @FindBy(xpath = "//*[@id=\"noo-site\"]/div[2]/div/div/div[1]/div")
    WebElement txtAddProductToCart;
    @FindBy(xpath = "//a[normalize-space()='View cart']")
    WebElement btnViewCart;
    @FindBy(xpath = "//a[contains(text(),'black ribbed short sleeve lettuce hem midi dress -')]")
    WebElement txtProductName;

    public void btnCart(){
        this.btnCart.click();
    }
    public void btnShop(){
        if (btnContinueShop.isDisplayed()){
            this.btnContinueShop.click();
        }else {
            this.btnReturnToShop.click();
        }
    }
    public void btnProduct(){
        this.btnProduct.click();
    }
    public void selectProduct(String color, String size){
        //color
        selectObjek = new Select(this.color);
        selectObjek.selectByValue(color);
        //size
        selectObjek = new Select(this.size);
        selectObjek.selectByValue(size);
        this.btnAddToCart.click();
    }
    public void quantity(int quantity){
        for (int i = 1; i < quantity; i++) {
            this.quantity.click();
        }
    }
    public String getTextAddProductToCart(){
        return txtAddProductToCart.getText();
    }
    public void btnViewCart(){
        this.btnViewCart.click();
    }
    public String getTextProductName(){
        return this.txtProductName.getText();
    }
}
