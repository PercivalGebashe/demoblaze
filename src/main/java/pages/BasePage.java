package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.LocatorReader;

public class BasePage {

    WebDriver driver;

    private final By loginBtnLoc =  By.xpath(LocatorReader.getLocator("BasePage", "loginBtn"));
    private final By logoutBtnLoc = By.xpath(LocatorReader.getLocator("BasePage", "logoutBtn"));
    private final By usernameTextFieldLoc = By.xpath(LocatorReader.getLocator("BasePage", "usernameTextField"));
    private final By passwordTextFieldLoc = By.xpath(LocatorReader.getLocator("BasePage", "passwordTextField"));
    private final By LoginModalCloseBtnLoc = By.xpath(LocatorReader.getLocator("BasePage", "LoginModalCloseBtn"));
    private final By loginModalLoginBtnLoc = By.xpath(LocatorReader.getLocator("BasePage", "loginModalLoginBtn"));
    private final By welcomeUserBtnLoc = By.xpath(LocatorReader.getLocator("BasePage", "welcomeUserBtn"));

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement loginBtn(){
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

    public WebDriver getDriver(){
        return driver;
    }

    public By getLoginBtnLoc() {
        return loginBtnLoc;
    }

    public By getLogoutBtnLoc() {
        return logoutBtnLoc;
    }

    public By getUsernameTextFieldLoc() {
        return usernameTextFieldLoc;
    }

    public By getPasswordTextFieldLoc() {
        return passwordTextFieldLoc;
    }

    public By getLoginModalCloseBtnLoc() {
        return LoginModalCloseBtnLoc;
    }

    public By getLoginModalLoginBtnLoc() {
        return loginModalLoginBtnLoc;
    }

    public By getWelcomeUserBtnLoc() {
        return welcomeUserBtnLoc;
    }
}
