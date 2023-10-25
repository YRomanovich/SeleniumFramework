package commonLibs.contracts;

import org.openqa.selenium.WebElement;

public interface IAlert {
    public void acceptAlert() throws Exception;
    public void declineAlert() throws Exception;
    public String getMessageFromAlert() throws Exception;
    public boolean checkAlertIsVisible(int waitTimeout) throws Exception;
}
