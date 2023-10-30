package in.co.mercuryTravel.pages;

import commonLibs.implementation.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    protected WebDriver driver;
    protected AlertControl alertControl;
    protected CommonElement commonElement;
    protected DropdownControl dropdownControl;
    protected FrameControl frameControl;
    protected MouseControl mouseControl;

    public BasePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);

        alertControl = new AlertControl(driver);
        commonElement = new CommonElement();
        dropdownControl = new DropdownControl();
        frameControl = new FrameControl(driver);
        mouseControl = new MouseControl(driver);
    }
}
