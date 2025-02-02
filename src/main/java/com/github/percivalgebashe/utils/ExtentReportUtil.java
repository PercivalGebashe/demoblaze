package com.github.percivalgebashe.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ExtentReportUtil {
    @Getter
    private static ExtentReports extent;
    private static ExtentTest test;
    private static ExtentSparkReporter spark;


    public static void init() {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        spark = new ExtentSparkReporter(System.getProperty("user.dir")+
                "\\reports\\extent-report-"+
                timestamp +
                ".html");

        spark.config().setDocumentTitle("DemoBlaze Extent Report");
        spark.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(spark);
    }


}
