package commonLibs.contracts;

import org.openqa.selenium.WebElement;

public interface IMouseOperation {
    void dragAndDrop(WebElement source, WebElement target) throws Exception;
    void moveToElement(WebElement element) throws Exception;
    void rightClick(WebElement element) throws Exception;
    void doubleClick(WebElement element) throws Exception;
    void moveToElementAndClick(WebElement element) throws Exception;
}
