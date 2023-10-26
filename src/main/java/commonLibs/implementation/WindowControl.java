package commonLibs.implementation;

import commonLibs.contracts.IWindowHandler;
import org.openqa.selenium.WebDriver;

import java.util.Set;

public class WindowControl implements IWindowHandler {
    private final WebDriver driver;

    public WindowControl(WebDriver driver){ this.driver = driver; }

    @Override
    public void switchToAnyWindow(String windowToSwitch) throws Exception {
        driver.switchTo().window(windowToSwitch);
    }

    @Override
    public void switchToAnyWindow(int indexOfWindow) throws Exception {
        String childWindowHandle = driver.getWindowHandles().toArray()[indexOfWindow].toString();
        driver.switchTo().window(childWindowHandle);
    }

    @Override
    public String getWindowHandle() throws Exception {
        return driver.getWindowHandle();
    }

    @Override
    public Set<String> getWindowHandles() throws Exception {
        return driver.getWindowHandles();
    }
}
