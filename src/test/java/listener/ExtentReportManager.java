package listener;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.github.percivalgebashe.utils.ScreenShotUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ExtentReportManager implements ITestListener {

    private ExtentSparkReporter sparkReporter;
    private ExtentReports extent;
    private ExtentTest test;
    private static final Logger log = LogManager.getLogger(ExtentReportManager.class);

    @Override
    public void onTestStart(ITestResult result) {
        log.info("Test Started: " +
                "Test Method: " + result.getMethod().getMethodName());
        test = extent.createTest(result.getMethod().getMethodName());
        test.log(Status.INFO, "Test Started: " + result.getTestName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test = extent.createTest(result.getName());
        test.log(Status.PASS, "Test case passed: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        log.error("Test Failed: " +
                "Test Method: " + result.getMethod().getMethodName());

        WebDriver driver = (WebDriver) result.getAttribute("driver");
        if (driver != null) {
            System.out.println("Driver on fail: " + driver);
            test = extent.createTest(result.getName());
            test.log(Status.FAIL, "Test case failed: " + result.getName());
            test.log(Status.FAIL, "Test case fail cause: " + result.getThrowable().getMessage());
            String screenshotPath;
            try {
                screenshotPath = ScreenShotUtil.takeScreenShot(driver, result.getName());
                System.out.println("Path: " + screenshotPath);
                ScreenShotUtil.attachScreenShotToTest(screenshotPath, test);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        log.warn("Test Skipped: " +
                "Test Method: " + result.getMethod().getMethodName());
        test = extent.createTest(result.getName());
        test.log(Status.SKIP, "Test case skipped: " + result.getName());
    }

    @Override
    public void onStart(ITestContext context) {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+
                "\\reports\\extent-report-"+
                timestamp +
                 ".html");

        sparkReporter.config().setDocumentTitle("DemoBlaze Extent Report");
        sparkReporter.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
