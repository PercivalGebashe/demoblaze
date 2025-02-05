package com.github.percivalgebashe.utils;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.bidi.browsingcontext.BrowsingContext;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;

public class ScreenShotUtil {

    public static String takeScreenShot(WebDriver driver, String fileName) throws IOException {
        BrowsingContext browsingContext = new BrowsingContext(driver, driver.getWindowHandle());
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("-yyyy-MM-dd-ss"));
        fileName = fileName + timestamp + ".png";
        String screenShotDir = System.getProperty("user.dir")+"\\reports\\screenshots\\"+fileName;
        String screenshot = browsingContext.captureScreenshot();
        saveScreenshot(screenshot, screenShotDir);
        return screenShotDir;
    }

    public static void attachScreenShotToTest(String filePath, ExtentTest test) throws IOException {
        File file = new File(filePath);
        int maxRetries = 10; // Adjust this as needed
        int attempts = 0;

        // Wait until the file is fully written
        while (!file.canRead() && attempts < maxRetries) {
            try {
                Thread.sleep(500); // Small delay for the file to become readable
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Restore interrupted status
                throw new IOException("Thread interrupted while waiting for screenshot", e);
            }
            attempts++;
        }

        // Attach the screenshot if readable
        if (file.canRead()) {
            test.addScreenCaptureFromPath(filePath, "Failure Screenshot");
        } else {
            throw new IOException("Screenshot exists but is not readable: " + filePath);
        }
    }

    public static void saveScreenshot(String source, String target) throws IOException {
        var decodedSource = Base64.getDecoder().decode(source);
        try {
            Files.write(Paths.get(target), decodedSource);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}