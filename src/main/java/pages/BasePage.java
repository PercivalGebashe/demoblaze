package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.LocatorReader;

public class BasePage {

    WebDriver driver;

    By loginBtnLoc =  By.xpath(LocatorReader.getLocator("BasePage", "loginBtn"));
    By logoutBtnLoc = By.xpath(LocatorReader.getLocator("BasePage", "logoutBtn"));
    By usernameTextFieldLoc = By.xpath(LocatorReader.getLocator("BasePage", "usernameTextField"));
    By passwordTextFieldLoc = By.xpath(LocatorReader.getLocator("BasePage", "passwordTextField"));
    By LoginModalCloseBtnLoc = By.xpath(LocatorReader.getLocator("BasePage", "LoginModalCloseBtn"));
    By loginModalLoginBtnLoc = By.xpath(LocatorReader.getLocator("BasePage", "loginModalLoginBtn"));
    By welcomeUserBtnLoc = By.xpath(LocatorReader.getLocator("BasePage", "welcomeUserBtn"));

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement LoginBtn(){
        return driver.findElement(loginBtnLoc);
    }

    public WebElement logoutBtn(){
        return driver.findElement(logoutBtnLoc);
    }

    public WebElement usernameTextField(){
        return driver.findElement(usernameTextFieldLoc);
    }

    public WebElement passwordTextField(){
        return driver.findElement(passwordTextFieldLoc);
    }

    public WebElement LoginModalCloseBtn(){
        return driver.findElement(LoginModalCloseBtnLoc);
    }

    public WebElement loginModalLoginBtn(){
        return driver.findElement(loginModalLoginBtnLoc);
    }

    public WebElement WelcomeUser(){
        return driver.findElement(welcomeUserBtnLoc);
    }
}
