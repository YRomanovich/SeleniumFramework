import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.URL;

public class TestNGTests {

    WebDriver driver;

    @Test
    public void Test1() throws Exception{
        ChromeOptions chromeOptions = new ChromeOptions();

        URL url = new URL("http://192.168.0.176:4444");

        driver = new RemoteWebDriver(url,chromeOptions);

        driver.manage().window().maximize();

        driver.get("https://test.qatechhub.com/");

        driver.quit();
    }
}
