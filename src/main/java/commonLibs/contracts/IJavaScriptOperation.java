package commonLibs.contracts;

public interface IJavaScriptOperation {
    void executeJavaScript(String scriptToExecute) throws Exception;
    void scrollDown(int x, int y) throws Exception;
    String executeJavaScriptWithReturnedValue(String scriptToExecute) throws Exception;
}
