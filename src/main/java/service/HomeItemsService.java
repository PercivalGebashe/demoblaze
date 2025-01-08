package service;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

import java.time.Duration;
import java.util.List;

public class HomeItemsService extends BasePage {

    public HomeItemsService(WebDriver driver) {
        super(driver);
    }

    public void selectCategory(String category){

    }

    public void selectProduct(String productName) throws InterruptedException {
        // Validate input
        if (productName == null || productName.trim().isEmpty()) {
            throw new IllegalArgumentException("Product name cannot be null or empty.");
        }

        // Retrieve product cards
        List<WebElement> productCards = super.productCards();
        if (productCards == null || productCards.isEmpty()) {
            throw new IllegalStateException("No product cards found on the page.");
        }

        // Iterate through the product cards to find a match
        for (WebElement card : productCards) {
            // Use explicit wait to ensure the card is visible
            new WebDriverWait(getDriver(), Duration.ofSeconds(5))
                    .until(ExpectedConditions.visibilityOf(card));

            // Extract the product name from the card
            String cardText = card.getText();
            if (cardText == null || cardText.trim().isEmpty()) {
                continue; // Skip if the card text is empty
            }

            String actualName = cardText.split("\n")[0].trim(); // Extract and trim the product name
            if (productName.equalsIgnoreCase(actualName)) {
                // Locate the clickable 'a' element within the card
                WebElement clickableElement = card.findElement(By.tagName("a"));

                // Ensure the clickable element is interactable
                new WebDriverWait(getDriver(), Duration.ofSeconds(5))
                        .until(ExpectedConditions.elementToBeClickable(clickableElement));

                // Click on the anchor element
                clickableElement.click();
                return; // Exit the method after selecting the product
            }
        }

        // If no match is found, throw an exception or log the issue
        throw new NoSuchElementException("Product with name '" + productName + "' not found.");
    }

}
