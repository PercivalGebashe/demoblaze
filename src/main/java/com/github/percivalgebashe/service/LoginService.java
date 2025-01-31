package com.github.percivalgebashe.service;

import org.openqa.selenium.WebDriver;
import com.github.percivalgebashe.pages.BasePage;

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
}
