package commonLibs.utils;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {

    public static void waitElementIsVisible(WebDriver driver, WebElement element, int  timeoutInSeconds){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));

        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitElementIsVisible(WebDriver driver, WebElement element, int timeoutInSeconds, int pollingTime){
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(timeoutInSeconds))
                .pollingEvery(Duration.ofSeconds(pollingTime))
                .ignoring(NoSuchElementException.class);

        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForFrameAndNavigateToIt(WebDriver driver, WebElement element, int timeoutInSeconds){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));

        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
    }

    public static void waitAlertIsVisible(WebDriver driver, int timeoutInSeconds){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));

        wait.until(ExpectedConditions.alertIsPresent());
    }


}
