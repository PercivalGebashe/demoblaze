package stepDefinitions;

import com.github.percivalgebashe.utils.LoggerUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.github.percivalgebashe.utils.WebDriverUtil;
import com.github.percivalgebashe.pages.ProductDetailsPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DemoBlazeStepDefinitions extends WebDriverUtil {

    @Given("I visit {string} website")
    public void getURL(String url) {

        getDriver().get(url);
        LoggerUtil.sendInfo(
                this.getClass().getName(),
                this.getClass().getMethods()[0].getName(),
                "Webpage Opened: " + url);

        WebDriver driver = getDriver();
        String actual = driver.getCurrentUrl();

        assertEquals(actual, url);
    }

    @When("I click the login button")
    public void login() {
        loginService.openLoginModal();

        LoggerUtil.sendInfo(
                this.getClass().getName(),
                "login",
                "Successfully clicked the login button");
    }

    @And("Enter my login details {string} and {string}")
    public void enterLoginDetails(String username, String password) {
        loginService.login(username, password);
        LoggerUtil.sendInfo(
                this.getClass().getName(),
                "enterLoginDetails",
                "Successfully entered login details");
    }

    @Then("I should be successfully logged in")
    public void loginSuccess() throws InterruptedException {
        By elementLoc = loginService.getLogoutBtnLoc();
        assertTrue(loginService.getWebElement(elementLoc).isDisplayed());
        LoggerUtil.sendInfo(
                this.getClass().getName(),
                "loginSuccess",
                "Successfully Login in");

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
        ProductDetailsPage page = new ProductDetailsPage(getDriver());
        String actualProductName = page.productName().getText();
        assertEquals(actualProductName, expectedProductName);

    }

    @When("I click the add to card button")
    public void clickAddToCart() {
        ProductDetailsPage page = new ProductDetailsPage(getDriver());
        By addToCartLoc = page.getAddToCartBtnLoc();
        productDetailsService.addToCart(addToCartLoc);
    }

    @Then("I should see alert {string}")
    public void iShouldSeeAlert(String alertMsg) {
        homeItemsService.switchToAlert();
        String actualAlertMsf = homeItemsService.getAlertText();
        homeItemsService.acceptAlert();
        assertEquals(actualAlertMsf, alertMsg);
    }
}
