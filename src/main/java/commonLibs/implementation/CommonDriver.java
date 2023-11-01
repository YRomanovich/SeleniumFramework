package commonLibs.implementation;

import commonLibs.contracts.IDriver;
import commonLibs.utils.ConfigFileUtils;
import commonLibs.utils.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.Properties;

public class CommonDriver implements IDriver {
    private final WebDriver driver;
    private int pageLoadTime;
    private int elementDetectionTimeout;
    static Properties configProperties;

    static {
        try {
            configProperties = ConfigFileUtils.readProperties(Constants.CONFIG_DIRECTORY);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public CommonDriver(String browserType) throws Exception {
        pageLoadTime = Integer.parseInt(configProperties.getProperty("pageLoadTimeout"));
        elementDetectionTimeout = Integer.parseInt(configProperties.getProperty("implicitWait"));

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
            throw new Exception("Invalid Browser Type");
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setPageLoadTime(int pageLoadTime) {
        this.pageLoadTime = pageLoadTime;
    }

    public void setElementDetectionTimeout(int elementDetectionTimeout) {
        this.elementDetectionTimeout = elementDetectionTimeout;
    }

    @Override
    public void navigateToFirstUrl(String url) throws Exception {
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageLoadTime));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(elementDetectionTimeout));

        driver.get(configProperties.getProperty("url"));
    }

    @Override
    public String getTitle() throws Exception {
        return driver.getTitle();
    }

    @Override
    public String getCurrentUrl() throws Exception {
        return driver.getCurrentUrl();
    }

    @Override
    public String getPageSource() throws Exception {
        return driver.getPageSource();
    }

    @Override
    public void navigateToUrl(String url) throws Exception {
        driver.navigate().to(url);
    }

    @Override
    public void navigateForward() throws Exception {
        driver.navigate().forward();
    }

    @Override
    public void navigateBackward() throws Exception {
        driver.navigate().back();
    }

    @Override
    public void refreshPage() throws Exception {
        driver.navigate().refresh();
    }

    @Override
    public void closeBrowser() throws Exception {
        if(driver != null) driver.close();
    }

    @Override
    public void closeAllBrowsers() throws Exception {
        if(driver != null) driver.quit();
    }
}
