package commonLibs.implementation;

import commonLibs.contracts.ICommonElement;
import org.openqa.selenium.WebElement;

public class CommonElement implements ICommonElement {

    @Override
    public String getText(WebElement element) throws Exception {
        return element.getText();
    }

    @Override
    public void clickElement(WebElement element) throws Exception {
        element.click();
    }

    @Override
    public String getAttribute(WebElement element, String attribute) throws Exception {
       return element.getAttribute(attribute);
    }

    @Override
    public String getCSSValue(WebElement element, String cssValue) throws Exception {
        return element.getCssValue(cssValue);
    }

    @Override
    public boolean isElementEnabled(WebElement element) throws Exception {
        return element.isEnabled();
    }

    @Override
    public boolean isElementVisible(WebElement element) throws Exception {
        return element.isDisplayed();
    }

    @Override
    public boolean isElementSelected(WebElement element) throws Exception {
        return element.isSelected();
    }

    @Override
    public void setText(WebElement element, String text) throws Exception {
        element.sendKeys(text);
    }

    @Override
    public void clearText(WebElement element) throws Exception {
        element.clear();
    }

    @Override
    public void changeCheckBoxesStatus(WebElement element, boolean status) throws Exception {
        boolean currentStatus = element.isSelected();

        if (status != currentStatus) element.click();
    }

    @Override
    public int getXLocation(WebElement element) throws Exception {
        return element.getLocation().x;
    }

    @Override
    public int getYLocation(WebElement element) throws Exception {
        return element.getLocation().y;
    }
}
