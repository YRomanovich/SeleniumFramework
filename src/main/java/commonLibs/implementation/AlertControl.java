package commonLibs.implementation;

import commonLibs.contracts.IAlert;
import commonLibs.utils.WaitUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

public class AlertControl implements IAlert {

    private final WebDriver driver;

    public AlertControl(WebDriver driver){ this.driver = driver; }

    private Alert getAlert(){ return driver.switchTo().alert();}

    @Override
    public void acceptAlert() throws Exception { getAlert().accept(); }

    @Override
    public void declineAlert() throws Exception { getAlert().dismiss(); }

    @Override
    public String getMessageFromAlert() throws Exception { return getAlert().getText(); }

    @Override
    public boolean checkAlertIsVisible(int waitTimeout) throws Exception {
        try{
            WaitUtils.waitAlertIsVisible(driver, waitTimeout);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
