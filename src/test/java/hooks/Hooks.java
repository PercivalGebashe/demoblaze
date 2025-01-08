package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import service.LoginService;
import stepDefinitions.TestBase;

public class Hooks extends TestBase {

    @Before // Initialize the driver before the scenario starts
    public void beforeScenario() {
        setup();
    }

    @After // Quit the driver after the scenario ends
    public void afterScenario() {
        tearDown();  // Calling the tearDown method from TestBase
    }
}
