package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.LocatorReader;

public class ProducutDetailsPage extends BasePage{

    private final By productNameLoc = By.xpath(LocatorReader.getLocator("ProducutDetailsPage", "productName"));
    private final By productPriceLoc = By.xpath(LocatorReader.getLocator("ProducutDetailsPage", "productPrice"));
    private final By productDescriptionLoc = By.xpath(LocatorReader.getLocator("ProducutDetailsPage", "productDescription"));
    private final By addToCartBtnLoc =  By.xpath(LocatorReader.getLocator("ProducutDetailsPage", "addToCartBtn"));

    public ProducutDetailsPage(WebDriver driver) {
        super(driver);
    }

    public WebElement productName(){
        return driver.findElement(productNameLoc);
    }

    public WebElement description(){
        return driver.findElement(productDescriptionLoc);
    }

    public WebElement productPrice(){
        return driver.findElement(productPriceLoc);
    }


    public WebElement addToCartBtn(){
        return driver.findElement(addToCartBtnLoc);
    }
}
