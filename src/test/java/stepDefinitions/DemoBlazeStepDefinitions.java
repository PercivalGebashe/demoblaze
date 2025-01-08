package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.ProducutDetailsPage;
import service.HomeItemsService;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DemoBlazeStepDefinitions extends TestBase{

    @Given("I visit {string} website")
    public void getURL(String url) {

        getDriver().get(url);

        WebDriver driver = getDriver();
        String actual = driver.getCurrentUrl();

        assertEquals(actual, url);
    }

    @When("I click the login button")
    public void login() {
        loginService.openLoginModal();
    }

    @And("Enter my login details {string} and {string}")
    public void enterLoginDetails(String username, String password) {
        loginService.login(username, password);
    }

    @Then("I should be successfully logged in")
    public void loginSuccess() throws InterruptedException {
        By elementLoc = loginService.getLogoutBtnLoc();
        assertTrue(loginService.getWebElement(elementLoc).isDisplayed());
    }

    @And("Greeted with the welcome message {string}")
    public void confirmLogin(String msg) {
        WebElement btn = loginService.WelcomeUser();

        assertEquals(btn.getText(), msg);
    }

    @When("I click on the product {string}")
    public void iClickOnTheProduct(String productName) throws InterruptedException {
        homeItemsService.selectProduct(productName);
        assertTrue(true);

    }

    @Then("I should be on the product details page and see {string}")
    public void isOnProductsDetails(String expectedProductName) {
        ProducutDetailsPage page = new ProducutDetailsPage(getDriver());
        String actualProductName = page.productName().getText();
        assertEquals(actualProductName, expectedProductName);

    }

    @When("I click the add to card button")
    public void clickAddToCart() {
        ProducutDetailsPage page = new ProducutDetailsPage(getDriver());
        By addToCartLoc = page.getAddToCartBtnLoc();
        productDetailsService.addToCart(addToCartLoc);
    }
}
