package in.co.mercuryTravel.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogInPage extends BasePage{
    @FindBy(id = "sign_user_email")
    private WebElement userEmailField;
    @FindBy(id = "sign_user_password")
    private WebElement passwordField;
    @FindBy(xpath = "//button[text()='Log in']")
    private WebElement logInButton;
    @FindBy(xpath = "//u[text()='Forgot Password?']")
    private WebElement restPasswordLink;
    @FindBy(id = "myModalLabel")
    private WebElement title;
    @FindBy(xpath = "//*[@id='sign_user_password']//following-sibling::ul")
    private WebElement passwordFieldErrorText;
    @FindBy(xpath = "//*[@id='sign_user_password']//preceding-sibling::ul")
    private WebElement emailFieldErrorText;


    public LogInPage (WebDriver driver) { super(driver); }

    public void enterEmailAddress(String email) throws Exception{
        commonElement.setText(userEmailField, email);
    }

    public void enterPassword(String password) throws Exception{
        commonElement.setText(passwordField, password);
    }

    public HomePage clickLogInButton() throws Exception{
        commonElement.clickElement(logInButton);

        return new HomePage(driver);
    }

    public ForgotPasswordPage clickForgotPasswordLink() throws Exception{
        commonElement.clickElement(restPasswordLink);

        return new ForgotPasswordPage(driver);
    }

    public String getEmail() throws Exception{
        return commonElement.getText(userEmailField);
    }

    public String getPassword() throws Exception{
        return commonElement.getText(passwordField);
    }

    public String getPlaceholderTextEmailField() throws Exception{
        return commonElement.getAttribute(userEmailField, "placeholder");
    }

    public String getPlaceholderTextPasswordField() throws Exception{
        return commonElement.getAttribute(passwordField, "placeholder");
    }

    public String getTitle() throws Exception{
        return commonElement.getText(title);
    }

    public Boolean isErrorTextForEmailFieldPresented() throws Exception{
        return commonElement.isElementVisible(emailFieldErrorText);
    }

    public Boolean isErrorTextForPasswordFieldPresented() throws Exception{
        return commonElement.isElementVisible(passwordFieldErrorText);
    }
}
