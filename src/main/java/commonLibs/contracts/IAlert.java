package commonLibs.contracts;

import org.openqa.selenium.WebElement;

public interface IAlert {
    void acceptAlert() throws Exception;
    void declineAlert() throws Exception;
    String getMessageFromAlert() throws Exception;
    boolean checkAlertIsVisible(int waitTimeout) throws Exception;
}
