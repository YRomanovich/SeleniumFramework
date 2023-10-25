package commonLibs.implementation;

import commonLibs.contracts.IDropdown;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropdownControl implements IDropdown {

    private Select getSelect(WebElement element){
        return new Select(element);
    }
    @Override
    public void selectByVisibleText(WebElement element, String visibleText) throws Exception {
        getSelect(element).selectByVisibleText(visibleText);
    }

    @Override
    public void selectByIndex(WebElement element, int index) throws Exception {
        getSelect(element).selectByIndex(index);
    }

    @Override
    public void selectByValue(WebElement element, String value) throws Exception {
        getSelect(element).selectByValue(value);
    }

    @Override
    public String getCurrentValue(WebElement element) throws Exception {
        return getSelect(element).getAllSelectedOptions().toString();
    }

    @Override
    public List<WebElement> getMultipleSelections(WebElement element) throws Exception {
        return getSelect(element).getAllSelectedOptions();
    }

    @Override
    public List<WebElement> getAllDropdownOptions(WebElement element) throws Exception {
        return getSelect(element).getOptions();
    }
}
