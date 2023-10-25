package commonLibs.contracts;

import org.openqa.selenium.WebElement;

import java.util.List;

public interface IDropdown {
    void selectByVisibleText(WebElement element, String visibleText) throws Exception;
    void selectByIndex(WebElement element, int index) throws Exception;
    void selectByValue(WebElement element, String value) throws Exception;
    String getCurrentValue(WebElement element) throws Exception;
    List<WebElement> getMultipleSelections(WebElement element) throws Exception;
    List<WebElement> getAllDropdownOptions(WebElement element) throws Exception;
}
