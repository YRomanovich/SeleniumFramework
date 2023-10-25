package commonLibs.contracts;

import org.openqa.selenium.WebElement;

import java.util.List;

public interface IDropdown {
    public void selectByVisibleText(WebElement element, String visibleText) throws Exception;
    public void selectByIndex(WebElement element, int index) throws Exception;
    public void selectByValue(WebElement element, String value) throws Exception;
    public String getCurrentValue(WebElement element) throws Exception;
    public List<WebElement> getMultipleSelections(WebElement element) throws Exception;
    public List<WebElement> getAllDropdownOptions(WebElement element) throws Exception;
}
