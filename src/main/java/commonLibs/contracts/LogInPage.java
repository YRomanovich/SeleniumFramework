package commonLibs.contracts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LogInPage extends BasePage{
    @FindBy(name = "uid")
    @CacheLookup
    private WebElement userName;
    @FindBy(name = "password")
    @CacheLookup
    private WebElement password;
    @FindBy(name = "btnLogin")
    @CacheLookup
    private WebElement logInButton;

    @FindBy(id = "gdpr-consent-notice")
    @CacheLookup
    private WebElement iFrame;

    @FindBy(id = "save")
    @CacheLookup
    private WebElement saveCookies;

    public LogInPage(WebDriver driver){super(driver);}

    WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(5));

    public String getUserNameValue(){
        return this.userName.getText();
    }

    public String getPasswordValue(){
        return this.password.getText();
    }

    public void clickLogInButton(){
        logInButton.click();
    }

    public void acceptCookiesNotification(){
        WaitUtils.waitForFrameAndNavigateToIt(driver, this.iFrame, 10);
        saveCookies.click();
        driver.switchTo().defaultContent();
    }

    public ManagerPage logIn(String userName, String password){
        WaitUtils.waitElementIsVisible(driver, this.userName, 10);
        this.userName.clear();
        this.userName.sendKeys(userName);
        this.password.sendKeys(password);

        this.clickLogInButton();

        return new ManagerPage(driver);
    }

    public void logOut (){
        LogOutPage logOutPage = new LogOutPage(driver);
        logOutPage.logOut();
    }
}
