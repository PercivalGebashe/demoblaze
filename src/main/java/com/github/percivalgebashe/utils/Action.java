package com.github.percivalgebashe.utils;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Action extends WebDriverUtil {

    private static final Actions actions;

    static {
        actions = new Actions(getDriver());
    }

    public static void click(WebElement element){
        actions.scrollToElement(element)
                .click(element)
                .perform();
    }

    public static void sendKeys(WebElement element, String keys){
        actions.scrollToElement(element)
                .sendKeys(element,Keys.CLEAR)
                .sendKeys(keys)
                .perform();
        actions.sendKeys(element,Keys.ENTER);
    }

    public static void clickEnter(WebElement element){
        actions.sendKeys(element, Keys.ENTER);
    }

    public static Actions getActions(){
        return actions;
    }
}
