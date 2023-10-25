package commonLibs.contracts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MultipleBrowsers {
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

    WebDriver driver;
    WebDriverWait driverWait;

    public void invokeBrowser(String browserType) throws Exception {
         if (browserType.equalsIgnoreCase("chrome")){
             System.setProperty("webbriver.chrome.driver", Constants.DRIVERS_DIRECTORY + "chromedriver.exe");
             ChromeOptions chromeOptions = new ChromeOptions();
             chromeOptions.addArguments("--remote-allow-origins=*");

             driver = new ChromeDriver(chromeOptions);
         } else if (browserType.equalsIgnoreCase("edge")){
             System.setProperty("webbriver.edge.driver",Constants.DRIVERS_DIRECTORY + "msedgedriver.exe");

             driver = new EdgeDriver();
         } else if (browserType.equalsIgnoreCase("firefox")) {
             System.setProperty("webbriver.firefox.driver",Constants.DRIVERS_DIRECTORY + "gekodriver.exe");

             driver = new FirefoxDriver();
         } else {
             System.err.println("Invalid browser type - " + browserType);

             throw new Exception("Invalid browser type - " + browserType);
         }
         PageFactory.initElements(driver, this);
         driverWait = new WebDriverWait(driver, Duration.ofSeconds(5));

         driver.manage().window().maximize();
    }

    public String getUserNameValue(){
        return this.userName.getText();
    }

    public String getPasswordValue(){
        return this.password.getText();
    }

    public void clickLogInButton(){
        logInButton.click();
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public void printTitle() {
        System.out.println("Page Title - " + this.getTitle());
    }

    public void openPage (String url) { driver.get(url); }

    public void checkTitle(String title){
        String pageTitle = this.getTitle();

        if (pageTitle.equals(title)) System.out.println("Page title is " + title);
        else System.err.println("Incorrect page title - " + pageTitle + ". Expected title - " + title);
    }

    public void acceptCookiesNotification() {
        driver.switchTo().frame(iFrame);
        saveCookies.click();
    }

    public void logIn(String userName, String password){
        this.userName.clear();
        this.userName.sendKeys(userName);
        this.password.sendKeys(password);

        this.clickLogInButton();
    }
}
