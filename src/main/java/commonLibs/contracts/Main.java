package commonLibs.contracts;

import org.openqa.selenium.WebDriver;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        WebDriver driver;
        LogInPage logInPage;

        Base base = new Base();
        driver = base.getDriver("chrome");

        logInPage = new LogInPage(driver);
        logInPage.logIn(Constants.USER_ID, Constants.PASSWORD);
        logInPage.logOut();

        base.closeBrowser();
    }
}