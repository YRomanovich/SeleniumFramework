package commonLibs.contracts;

import org.openqa.selenium.WebElement;

public interface IFrame {
    void switchToFrame(WebElement element) throws Exception;
    void switchToFrame(int index) throws Exception;
    void switchToFrame(String id) throws Exception;
    void switchToParentPage() throws Exception;
}
