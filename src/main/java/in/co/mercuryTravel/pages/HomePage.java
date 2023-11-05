package in.co.mercuryTravel.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
    @FindBy(linkText = "User Login")
    private WebElement logInMenuItem;
    @FindBy(linkText = "User Login")
    private WebElement welcomeText;
    @FindBy(id = "Register")
    private WebElement registerMenuItem;
    @FindBy(linkText = "Customer Login")
    private WebElement customerLogInMenu;

    public HomePage(WebDriver driver) { super(driver); }

    public boolean isUserLoggedIn(){
        boolean isDisplayed = true;

        try {
            customerLogInMenu.isDisplayed();
        } catch (NoSuchElementException e) {
            isDisplayed = false;
        }
        return isDisplayed;
    }

    public String getWelcomeText(){
        return welcomeText.getText();
    }

    public void openCustomerLogInMenu()  throws Exception{
        mouseControl.moveToElement(customerLogInMenu);
    }

    public LogInPage clickLogIn() throws Exception{
        mouseControl.moveToElementAndClick(logInMenuItem);

        return new LogInPage(driver);
    }

    public RegisterPage clickRegister() throws Exception{
        mouseControl.moveToElementAndClick(registerMenuItem);

        return new RegisterPage(driver);
    }
}
