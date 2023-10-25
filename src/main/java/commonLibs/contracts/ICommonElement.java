package commonLibs.contracts;

import org.openqa.selenium.WebElement;

public interface ICommonElement {
    public String getText(WebElement element) throws Exception;
    public void clickElement(WebElement element) throws Exception;
    public String getAttribute(WebElement element, String attribute) throws Exception;
    public String getCSSValue(WebElement element, String cssValue) throws Exception;
    public boolean isElementEnabled(WebElement element) throws Exception;
    public boolean isElementVisible(WebElement element) throws Exception;
    public boolean isElementSelected(WebElement element) throws Exception;
    public void setText(WebElement element, String text) throws Exception;
    public void clearText(WebElement element) throws Exception;
    public void changeCheckBoxesStatus(WebElement element, boolean status) throws Exception;
    public int getXLocation(WebElement element) throws Exception;
    public int getYLocation(WebElement element) throws Exception;
}
