package commonLibs.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigateForward(){
        driver.navigate().forward();
    }

    public void navigateBackward(){
        driver.navigate().back();
    }

    public void refreshPage(){
        driver.navigate().refresh();
    }
}
