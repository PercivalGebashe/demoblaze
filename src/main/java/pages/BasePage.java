package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.LocatorReader;

import java.time.Duration;
import java.util.List;

public class BasePage {

    WebDriver driver;

    private final By loginBtnLoc =  By.xpath(LocatorReader.getLocator("BasePage", "loginBtn"));
    private final By logoutBtnLoc = By.xpath(LocatorReader.getLocator("BasePage", "logoutBtn"));
    private final By usernameTextFieldLoc = By.xpath(LocatorReader.getLocator("BasePage", "usernameTextField"));
    private final By passwordTextFieldLoc = By.xpath(LocatorReader.getLocator("BasePage", "passwordTextField"));
    private final By LoginModalCloseBtnLoc = By.xpath(LocatorReader.getLocator("BasePage", "LoginModalCloseBtn"));
    private final By loginModalLoginBtnLoc = By.xpath(LocatorReader.getLocator("BasePage", "loginModalLoginBtn"));
    private final By welcomeUserBtnLoc = By.xpath(LocatorReader.getLocator("BasePage", "welcomeUserBtn"));
    private final By productCardsLoc = By.xpath(LocatorReader.getLocator("BasePage","ProductCards"));

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

    public List<WebElement> productCards(){
        return driver.findElements(productCardsLoc);
    }

    public WebElement getWebElement(By by) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public void swithToAlert(){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public void acceptAlert(){
        swithToAlert();
        getDriver().switchTo().alert().accept();
    }

    public String getAlertText(){
        return getDriver().switchTo().alert().getText();
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

    public By getProductCardsLoc() {
        return productCardsLoc;
    }
}
