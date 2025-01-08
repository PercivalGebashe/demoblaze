package service;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

import java.time.Duration;

public class LoginService extends BasePage {

    public LoginService(WebDriver driver) {
        super(driver);
    }

    public void openLoginModal(){
        super.loginBtn().click();
    }

    public void closeLoginModal(){
        super.LoginModalCloseBtn().click();
    }

    public void login(String username, String password){

//        openLoginModal();
        super.usernameTextField().sendKeys(username);
        super.passwordTextField().sendKeys(password);

        super.loginModalLoginBtn().click();
    }

    public void logout(){
        super.logoutBtn().click();
    }

    public void getUsername(){

    }

    public boolean elementIsDisplayed(By by) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(super.getDriver(), Duration.ofSeconds(5));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));
        return element.isDisplayed();
    }
}
