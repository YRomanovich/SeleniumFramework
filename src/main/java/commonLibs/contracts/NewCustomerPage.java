package commonLibs.contracts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class NewCustomerPage extends BasePage {
    @FindBy(name = "name")
    @CacheLookup
    private WebElement customerNameField;

    @FindBy(name = "//input[@value='m']")
    @CacheLookup
    private WebElement genderCheckBoxM;

    @FindBy(xpath = "//input[@value='f']")
    @CacheLookup
    private WebElement genderCheckBoxF;

    @FindBy(name = "dob")
    @CacheLookup
    private WebElement dateOfBirthField;

    @FindBy(name = "addr")
    @CacheLookup
    private WebElement addressField;

    @FindBy(name = "city")
    @CacheLookup
    private WebElement cityField;

    @FindBy(name = "state")
    @CacheLookup
    private WebElement stateField;

    @FindBy(name = "pinno")
    @CacheLookup
    private WebElement pinField;

    @FindBy(name = "telephoneno")
    @CacheLookup
    private WebElement phoneField;

    @FindBy(name = "emailid")
    @CacheLookup
    private WebElement emailField;

    @FindBy(name = "password")
    @CacheLookup
    private WebElement passwordField;

    @FindBy(name = "sub")
    @CacheLookup
    private WebElement submitButton;

    public NewCustomerPage(WebDriver driver){super(driver);}

    public void enterName(String name){
        this.customerNameField.sendKeys(name);
    }

    public void selectMaleGender(){
        this.genderCheckBoxM.click();
    }

    public void selectFemaleGender(){
        this.genderCheckBoxF.click();
    }

    public void enterDayOfBirth(String date){
        this.dateOfBirthField.sendKeys(date);
    }

    public void enterAddress(String address){
        this.addressField.sendKeys(address);
    }

    public void enterCity(String city){
        this.cityField.sendKeys(city);
    }

    public void enterState(String state){
        this.stateField.sendKeys(state);
    }

    public void enterPin(Integer pin){
        this.pinField.sendKeys(String.valueOf(pin));
    }

    public void enterPhone(Integer phone){
        this.phoneField.sendKeys(String.valueOf(phone));
    }

    public void enterEmail(String email){
        this.emailField.sendKeys(email);
    }

    public void enterPassword(String password){
        this.passwordField.sendKeys(password);
    }

    public void submitForm(){
        this.submitButton.click();
    }

    public String getName(){
        return this.customerNameField.getText();
    }

    public String getDayOfBirth(){
        return this.dateOfBirthField.getText();
    }

    public String getAddress(){
        return this.addressField.getText();
    }

    public String getCity(){
        return this.cityField.getText();
    }

    public String getState(){
        return this.stateField.getText();
    }

    public String enterPin(){
        return this.pinField.getText();
    }

    public String getPhone(){
        return this.phoneField.getText();
    }

    public String getEmail(){
        return this.emailField.getText();
    }

    public String enterPassword(){
        return this.passwordField.getText();
    }
}
