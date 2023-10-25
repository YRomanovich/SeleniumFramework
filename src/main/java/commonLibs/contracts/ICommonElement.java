package commonLibs.contracts;

import org.openqa.selenium.WebElement;

public interface ICommonElement {
    String getText(WebElement element) throws Exception;
    void clickElement(WebElement element) throws Exception;
    String getAttribute(WebElement element, String attribute) throws Exception;
    String getCSSValue(WebElement element, String cssValue) throws Exception;
    boolean isElementEnabled(WebElement element) throws Exception;
    boolean isElementVisible(WebElement element) throws Exception;
    boolean isElementSelected(WebElement element) throws Exception;
    void setText(WebElement element, String text) throws Exception;
    void clearText(WebElement element) throws Exception;
    void changeCheckBoxesStatus(WebElement element, boolean status) throws Exception;
    int getXLocation(WebElement element) throws Exception;
    int getYLocation(WebElement element) throws Exception;
}
