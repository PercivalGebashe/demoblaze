package com.github.percivalgebashe.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.github.percivalgebashe.utils.LocatorReader;

public class ProductDetailsPage extends BasePage{

    private final By productNameLoc = By.xpath(LocatorReader.getLocator("ProductDetailsPage", "productName"));
    private final By productPriceLoc = By.xpath(LocatorReader.getLocator("ProductDetailsPage", "productPrice"));
    private final By productDescriptionLoc = By.xpath(LocatorReader.getLocator("ProductDetailsPage", "productDescription"));
    private final By addToCartBtnLoc =  By.xpath(LocatorReader.getLocator("ProductDetailsPage", "addToCartBtn"));

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    public WebElement productName(){
        return driver.findElement(productNameLoc);
    }

    public WebElement description(){
        return driver.findElement(productDescriptionLoc);
    }

    public WebElement productPrice(){
        return driver.findElement(productPriceLoc);
    }


    public WebElement addToCartBtn(){
        return driver.findElement(addToCartBtnLoc);
    }

    public By getProductNameLoc() {
        return productNameLoc;
    }

    public By getProductPriceLoc() {
        return productPriceLoc;
    }

    public By getProductDescriptionLoc() {
        return productDescriptionLoc;
    }

    public By getAddToCartBtnLoc() {
        return addToCartBtnLoc;
    }
}
