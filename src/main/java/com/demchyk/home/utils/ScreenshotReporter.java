package com.demchyk.home.utils;

import com.demchyk.home.core.DriverProvider;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import java.io.File;
import java.io.IOException;
import java.time.Instant;

public class ScreenshotReporter implements ITestListener {
    private Logger logger = Logger.getLogger(ScreenshotReporter.class);
    private static final String SCREEN_PATH = "target/surefire-reports/";

    private WebDriver driver;

    @Override
    public void onTestStart(ITestResult iTestResult) {

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        logger.error("*** Error in method: " + iTestResult.getName() + " failed ***");
        String methodName = iTestResult.getName().trim();
        takeScreenshot(methodName + methodName.hashCode());
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }

    private void takeScreenshot(String methodName) {
        driver = DriverProvider.getDriver();
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String fileLocation = SCREEN_PATH + methodName + Instant.now().toEpochMilli() + ".PNG";
        File newFile = new File(fileLocation);
        try {
            FileUtils.copyFile(file, new File(String.valueOf(newFile)));
            logger.error("Screenshot location: " + newFile.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        String url = newFile.getAbsolutePath().replace(System.getProperty("user.dir") + "\\target\\surefire-reports\\","");
        Reporter.log("<td><img scr=\"" + url + "\" height=\"150\"> </td>");
    }
}

