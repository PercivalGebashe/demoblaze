package stepDefinitions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.edge.EdgeDriver;
import service.LoginService;
import utils.PropertiesReader;

import java.util.concurrent.TimeUnit;

public class TestBase {

    protected static WebDriver driver;
    protected static LoginService loginService;

    public void setup(){
        System.out.println("\nEntering Setup in TestBase\n");
        String browser = PropertiesReader.getProperty("browser"); //to be fetched from file
        System.out.println("\nBrowser: " + browser + "\n");
        boolean headless = PropertiesReader.getProperty("headless").equalsIgnoreCase("true");
        System.out.println("\nHeadlesss: " + headless + "\n");
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
                System.out.println("\nSetting up driver to Chrome Driver\n");
                WebDriverManager.chromedriver().setup();
                ChromeOptions coptions = new ChromeOptions();
                if (headless) {
                    coptions.addArguments("--headless");
                }
                driver = new ChromeDriver(coptions);
                break;
        }
        System.out.println("\nDriver Initialized: " + driver + "\n");
        getDriver().get("https://www.demoblaze.com/");
        getDriver().manage().window().maximize();

        getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        initServices();
    }

    public static WebDriver getDriver(){
        System.out.println("++++++Getting Driver: " + driver + "++++++++");

        return driver;
    }

    public void tearDown(){
        System.out.println("******Tearing Down******");
        driver.quit();
    }

    private void initServices(){
        loginService = new LoginService(getDriver());
    }
}
