package commonLibs.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class LogOutPage extends BasePage {
    @FindBy(linkText = "Log Out")
    @CacheLookup
    private WebElement logOutMenuItem;
    public LogOutPage (WebDriver driver) {super(driver);}

    AlertDialog alertDialog;

    public void logOut(){
        this.logOutMenuItem.click();

        WaitUtils.waitAlertIsVisible(driver, 10);
        alertDialog.confirmLogOut();
    }
}
