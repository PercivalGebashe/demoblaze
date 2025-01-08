package stepDefinitions;

import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import service.LoginService;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginStepDefinitions extends TestBase{

    LoginService service;

    @Given("I visit website")
    public void getURL() {
        System.out.println("\n********Entering Given*******");
//        WebDriver driver = super.getDriver();
//        System.out.println("\n********Got Web driver*******");
//        System.out.println("\n********Driver:" + driver + " Given*******");
//        driver.get(url);
//        System.out.println("\n********Opened link*******");
    }

    @When("I click the login button")
    public void login() {
        System.out.println("Setting up Login service");
        WebDriver driver = super.getDriver();
        System.out.println("Driver is: " + driver);
        service = new LoginService(driver);
        System.out.println("Success");
        service.openLoginModal();
    }

    @And("Enter my login details {string} and {string}")
    public void enterLoginDetails(String username, String password) {
        service.login(username, password);
    }

    @Then("I should be successfully logged in")
    public void loginSuccess() {
        WebElement btn = service.logoutBtn();
        assertTrue(btn.isDisplayed());
    }

    @And("Greeted with the welcome message {string}")
    public void confirmLogin(String msg) {
        WebElement btn = service.WelcomeUser();

        assertEquals(btn.getText(), msg);
    }
}
