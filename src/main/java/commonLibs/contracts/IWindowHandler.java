package commonLibs.contracts;

import java.util.Set;

public interface IWindowHandler {
    void switchToAnyWindow(String windowToSwitch) throws Exception;
    void switchToAnyWindow(int indexOfWindow) throws Exception;
    String getWindowHandle() throws Exception;
    Set<String> getWindowHandles() throws Exception;
}
