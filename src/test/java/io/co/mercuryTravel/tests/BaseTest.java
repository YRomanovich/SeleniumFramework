package io.co.mercuryTravel.tests;

import commonLibs.implementation.CommonDriver;
import commonLibs.utils.Constants;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;

public class BaseTest {
    private static CommonDriver driver;

    @BeforeMethod(alwaysRun = true)
    public static void beforeMethod(@Optional("firefox") String browser) throws Exception {
        driver = new CommonDriver(browser);
        driver.setPageLoadTime(60);
        driver.setElementDetectionTimeout(10);
        driver.navigateToFirstUrl(Constants.URL);
    }

    @AfterMethod(alwaysRun = true)
    public static void afterMethod() throws Exception {
        driver.closeBrowser();
    }
}
