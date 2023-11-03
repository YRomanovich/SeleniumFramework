package io.co.mercuryTravel.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import commonLibs.implementation.CommonDriver;
import commonLibs.implementation.ScreenshotControl;
import commonLibs.utils.ConfigFileUtils;
import commonLibs.utils.Constants;
import commonLibs.utils.DateUtils;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.util.Properties;

public class BaseTest {
    private static CommonDriver driver;
    static ExtentHtmlReporter htmlReporter;
    static ExtentReports extentReports;
    static ExtentTest extentTest;
    private static String reportFilePath;
    static Properties configProperties;
    static ScreenshotControl screenshotControl;


    static {
        try {
            configProperties = ConfigFileUtils.readProperties(Constants.CONFIG_DIRECTORY);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @BeforeSuite
    public static void beforeSuite() throws Exception {
        initializeReport();
    }

    @BeforeMethod(alwaysRun = true)
    public static void beforeMethod(@Optional("firefox") String browser) throws Exception {
        extentTest = extentReports.createTest("Setup - Set up WebDriver and pre-requisites");

        extentTest.log(Status.INFO, "WebDriver set up is started...");
        driver = new CommonDriver(browser);
        extentTest.log(Status.INFO, "WebDriver set up is finished.");
        screenshotControl = new ScreenshotControl((WebDriver) driver);
    }

    @AfterMethod(alwaysRun = true)
    public static void afterMethod(ITestResult result) throws Exception {
        String screenshotFilePath = String.format(Constants.SCREENSHOTS_DIRECTORY + "%s-%s.jpg"
                ,result.getTestName()
                ,DateUtils.getCurrentTimeAndDate());

        if (result.getStatus() == ITestResult.FAILURE){
            screenshotControl.captureAndSaveScreenshot(screenshotFilePath);
            extentTest.addScreenCaptureFromPath(screenshotFilePath);

            extentTest.log(Status.INFO, "Screenshot is taken and saved to " + screenshotFilePath);
            extentTest.log(Status.FAIL, result.getTestName());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            extentTest.log(Status.PASS, result.getTestName());
        } else {
            extentTest.log(Status.SKIP, result.getTestName());
        }

        driver.closeBrowser();
    }

    @AfterSuite
    public static void afterSuite() throws Exception {
        extentReports.flush();
        extentTest.log(Status.INFO, "Report is created and placed to " + reportFilePath);
    }

    private static void initializeReport(){
        reportFilePath = Constants.REPORTS_DIRECTORY
                + configProperties.getProperty("reportFileName")
                + String.format("%s.html", DateUtils.getCurrentTimeAndDate());

        htmlReporter = new ExtentHtmlReporter(reportFilePath);
        extentReports = new ExtentReports();

        extentReports.attachReporter(htmlReporter);

        htmlReporter.config().setDocumentTitle("Selenium Framework Project");
        htmlReporter.config().setReportName("Selenium Framework Report");
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setTheme(Theme.DARK);
        extentTest.log(Status.INFO, "Reporting is set up and started");
    }
}
