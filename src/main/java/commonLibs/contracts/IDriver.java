package commonLibs.contracts;

import java.security.PublicKey;

public interface IDriver {
    public void navigateToFirstUrl(String url) throws Exception;
    public String getTitle() throws Exception;
    public String getCurrentUrl() throws Exception;
    public String getPageSource() throws Exception;
    public void navigateToUrl() throws Exception;
    public void navigateForward() throws Exception;
    public void navigateBackward() throws Exception;
    public void refreshPage() throws Exception;
    public void closeBrowser() throws Exception;
    public void closeAllBrowsers() throws Exception;
}
