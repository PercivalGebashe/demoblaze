package stepDefinitions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.edge.EdgeDriver;
import service.HomeItemsService;
import service.LoginService;
import service.ProductDetailsService;
import utils.PropertiesReader;

import java.util.concurrent.TimeUnit;

public class TestBase {

    protected static WebDriver driver;
    protected static LoginService loginService;
    protected static HomeItemsService homeItemsService;
    protected static  ProductDetailsService productDetailsService;

    public void setup(){
        String browser = PropertiesReader.getProperty("browser"); //to be fetched from file
        boolean headless = PropertiesReader.getProperty("headless").equalsIgnoreCase("true");
        switch(browser.toLowerCase()) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions ffoptions = new FirefoxOptions();
                if (headless) {
                    ffoptions.addArguments("--headless");
                }
                driver = new FirefoxDriver(ffoptions);
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions ieoptions = new EdgeOptions();
                if (headless) {
                    ieoptions.addArguments("--headless");
                }
                driver = new EdgeDriver(ieoptions);
                break;

            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions coptions = new ChromeOptions();
                if (headless) {
                    coptions.addArguments("--headless");
                }
                driver = new ChromeDriver(coptions);
                break;
        }
        getDriver().manage().window().maximize();

        getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        initServices();
    }

    public static WebDriver getDriver(){
        return driver;
    }

    public void tearDown(){
        driver.quit();
    }

    private void initServices(){
        loginService = new LoginService(getDriver());
        homeItemsService = new HomeItemsService(getDriver());
        productDetailsService = new ProductDetailsService(getDriver());

    }
}
