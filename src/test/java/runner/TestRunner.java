package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.TestNGCucumberRunner;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

@CucumberOptions(
        features = "src\\test\\resources\\features",
        glue = {"stepDefinitions", "hooks"},
//        tags = {"not @Ignore", "not @ignore"},
        plugin = {
                "pretty",
                "html:reports\\cucumber-reports\\cucumber-pretty.html",
                "testng:reports\\cucumber-reports\\testng.xml",
                "json:reports\\cucumber-reports\\CucumberTestReport.json",
                "rerun:reports\\cucumber-reports\\rerun.txt"
        }
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
