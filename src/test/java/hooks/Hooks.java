package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import service.LoginService;
import stepDefinitions.TestBase;

public class Hooks extends TestBase {

    @Before // Initialize the driver before the scenario starts
    public void beforeScenario() {
        System.out.println("Before Scenario: Initializing WebDriver...");
        setup();
//        LoginService service = new LoginService(getDriver());;// Calling the setup method from TestBase
    }

    @After // Quit the driver after the scenario ends
    public void afterScenario() {
        System.out.println("After Scenario: Quitting WebDriver...");
        tearDown();  // Calling the tearDown method from TestBase
    }
}
