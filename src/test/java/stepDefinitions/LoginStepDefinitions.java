package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import service.LoginService;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginStepDefinitions extends TestBase{

    @Given("I visit {string} website")
    public void getURL(String expected) {
        System.out.println("\n********Entering Given*******");

        WebDriver driver = getDriver();
        String actual = driver.getCurrentUrl();

        assertEquals(actual, expected);
    }

    @When("I click the login button")
    public void login() {

        System.out.println("Setting up Login service");
        System.out.println("Login service: " + loginService);
        System.out.println("Success");
        loginService.openLoginModal();
    }

    @And("Enter my login details {string} and {string}")
    public void enterLoginDetails(String username, String password) {
        loginService.login(username, password);
    }

    @Then("I should be successfully logged in")
    public void loginSuccess() throws InterruptedException {
        By elementLoc = loginService.getLogoutBtnLoc();
        assertTrue(loginService.elementIsDisplayed(elementLoc));
    }

    @And("Greeted with the welcome message {string}")
    public void confirmLogin(String msg) {
        WebElement btn = loginService.WelcomeUser();

        assertEquals(btn.getText(), msg);
    }
}
