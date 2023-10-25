package commonLibs.contracts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class ManagerPage extends BasePage {
    @FindBy(linkText = "New Customer")
    @CacheLookup
    private WebElement NewCustomerMenuItem;
    public ManagerPage(WebDriver driver){super(driver);}

    public NewCustomerPage openNewCustomerPage(){
        this.NewCustomerMenuItem.click();

        return new NewCustomerPage(driver);
    }
}
