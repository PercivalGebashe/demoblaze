package com.github.percivalgebashe.utils;

import com.aventstack.extentreports.ExtentTest;
import com.github.percivalgebashe.pages.BasePage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScreenShotUtil {

    public static String takeScreenShot(WebDriver driver, String fileName) throws IOException {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("-yyyy-MM-dd-ss"));
        fileName = fileName + timestamp + ".png";
        String screenShotDir = System.getProperty("user.dir")+"\\reports\\screenshots\\"+fileName;
        TakesScreenshot takesScreenshot =(TakesScreenshot)driver;
        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(sourceFile, new File(screenShotDir));
        return screenShotDir;
    }

    public static void attachScreenShotToTest(String filePath, ExtentTest test)
        throws IOException {
        test.addScreenCaptureFromPath(filePath, "Failure Screenshot");
    }
}
