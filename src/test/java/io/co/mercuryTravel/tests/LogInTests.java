package io.co.mercuryTravel.tests;

import com.aventstack.extentreports.Status;
import in.co.mercuryTravel.pages.HomePage;
import in.co.mercuryTravel.pages.LogInPage;
import io.co.mercuryTravel.utils.TestDataProvider;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogInTests extends BaseTest{
    HomePage homePage;
    LogInPage logInPage;

    @Description("Test Case 10001: Log in with valid credentials")
    @Test(priority = 1, dataProvider="getUserData", dataProviderClass = TestDataProvider.class)
    public void verifyUserLogIn(String userName, String password, String expectedWelcomeText) throws Exception {
        homePage = new HomePage(getDriver());

        homePage.openCustomerLogInMenu();
        logInPage = homePage.clickLogIn();
        extentTest.log(Status.INFO, "Opened Log In dialog from Home page");

        extentTest.log(Status.INFO, String.format("Starting log in process for %s user", userName));
        logInPage.enterEmailAddress(userName);
        logInPage.enterPassword(password);
        homePage = logInPage.clickLogInButton();
        extentTest.log(Status.INFO, String.format("Logged in as %s user with %s password", userName, password));

        extentTest.log(Status.INFO, "Verifying that user is logged in");
        Assert.assertTrue(homePage.isUserLoggedIn());
        extentTest.log(Status.INFO, "Verifying that correct welcome text is displayed");
        Assert.assertEquals(homePage.getWelcomeText(), expectedWelcomeText);
    }
}
