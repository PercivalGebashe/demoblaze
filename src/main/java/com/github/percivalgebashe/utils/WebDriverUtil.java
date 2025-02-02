package com.github.percivalgebashe.utils;

import com.github.percivalgebashe.service.HomeItemsService;
import com.github.percivalgebashe.service.LoginService;
import com.github.percivalgebashe.service.ProductDetailsService;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebDriverUtil {

    protected static WebDriver driver;
    protected static WebDriverWait wait;
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

        getDriver().manage().timeouts().implicitlyWait(
                Duration.ofSeconds(Long.parseLong(PropertiesReader.getProperty("implicitWait"))));



        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(
                Long.parseLong(PropertiesReader.getProperty("explicitWait"))
            )
        );

        initServices();
    }

    public static WebDriver getDriver(){
        return driver;
    }

    public void tearDown(){
        if(driver != null){
            driver.quit();
        }
    }

    private void initServices(){
        loginService = new LoginService(getDriver());
        homeItemsService = new HomeItemsService(getDriver());
        productDetailsService = new ProductDetailsService(getDriver());
    }

    public static WebDriverWait getWait() {
        return wait;
    }
}
