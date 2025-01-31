package com.github.percivalgebashe.service;

import com.github.percivalgebashe.pages.ProductDetailsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.github.percivalgebashe.pages.ProducutDetailsPage;

import java.time.Duration;

public class ProductDetailsService extends ProductDetailsPage {

    public ProductDetailsService(WebDriver driver) {
        super(driver);
    }

    public void addToCart(By by){

        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));
        element.click();
    }
}
