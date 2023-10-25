package commonLibs.utils;

import commonLibs.utils.LogInPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

public class AlertDialog {
    private Alert alert;
    private final WebDriver driver;

    public AlertDialog(WebDriver driver){ this.driver = driver;}

    public LogInPage confirmLogOutAndReturnLogInPage(){
        alert = this.driver.switchTo().alert();
        alert.accept();

        return new LogInPage(driver);
    }

    public void confirmLogOut(){
        alert = this.driver.switchTo().alert();
        alert.accept();
    }
}
