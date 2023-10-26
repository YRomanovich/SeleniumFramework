package commonLibs.implementation;

import commonLibs.contracts.IJavaScriptOperation;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class JavaScriptControl implements IJavaScriptOperation {

    private final JavascriptExecutor jsEngine;

    public JavaScriptControl(WebDriver driver){
        jsEngine = (JavascriptExecutor) driver;
    }

    @Override
    public void executeJavaScript(String scriptToExecute) throws Exception {
        jsEngine.executeScript(scriptToExecute);
    }

    @Override
    public void scrollDown(int x, int y) throws Exception {
        String jsCommand = String.format("window.scrollBy(%d,%d)", x,y);
        jsEngine.executeScript(jsCommand);
    }

    @Override
    public String executeJavaScriptWithReturnedValue(String scriptToExecute) throws Exception {
        return jsEngine.executeScript(scriptToExecute).toString();
    }
}
