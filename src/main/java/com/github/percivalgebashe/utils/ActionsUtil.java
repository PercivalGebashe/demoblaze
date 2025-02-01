package com.github.percivalgebashe.utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ActionsUtil extends WebDriverUtil {

    private static Actions actions;

    static {
//        actions = new Actions(getDriver());
    }

    public static void clickElement(WebElement element){
        element = getWait().until(ExpectedConditions.elementToBeClickable(element));

        actions.moveToElement(element).click().perform();
    }

    public static void sendKeys(WebElement element, String text){
        element = wait.until(ExpectedConditions.elementToBeClickable(element));

        actions.moveToElement(element).sendKeys(text).perform();
    }
}
