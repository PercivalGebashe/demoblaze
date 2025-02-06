package com.github.percivalgebashe.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class JSExecutors extends WebDriverUtil {

    public static void sendKeys(WebElement target, String text) {
        JavascriptExecutor jse = getExecutor();
        jse.executeScript("arguments[0].value='" + text + "';", target);
    }

    public static void scrollTo(WebElement element){
        JavascriptExecutor jse = getExecutor();
        jse.executeScript("arguments[0].scrollIntoView();", element);
    }

    public static void click(WebElement element){
        JavascriptExecutor jse = getExecutor();
        jse.executeScript("arguments[0].click();", element);
    }

    private static JavascriptExecutor getExecutor(){
        return (JavascriptExecutor) getDriver();
    }
}