package commonLibs.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Base {

    public WebDriver driver;

    public WebDriver getDriver(String browserName){
        return setUpDriver(browserName);
    }

    public void closeBrowser(){
        driver.quit();
    }

    private WebDriver setUpDriver(String browserType){
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
        }

        driver.manage().window().maximize();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Constants.pageLoadTimeout));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.implicitWait));

        driver.get(Constants.URL);

        return driver;
    }
}
