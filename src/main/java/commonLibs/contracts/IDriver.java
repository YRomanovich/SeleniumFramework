package commonLibs.contracts;

public interface IDriver {
    void navigateToFirstUrl(String url) throws Exception;
    String getTitle() throws Exception;
    String getCurrentUrl() throws Exception;
    String getPageSource() throws Exception;
    void navigateToUrl(String url) throws Exception;
    void navigateForward() throws Exception;
    void navigateBackward() throws Exception;
    void refreshPage() throws Exception;
    void closeBrowser() throws Exception;
    void closeAllBrowsers() throws Exception;
}
