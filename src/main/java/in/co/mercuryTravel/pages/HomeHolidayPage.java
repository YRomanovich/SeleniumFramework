package in.co.mercuryTravel.pages;

import commonLibs.implementation.CommonElement;
import commonLibs.implementation.DropdownControl;
import commonLibs.utils.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomeHolidayPage extends BasePage{
    @FindBy(name="holiday-category")
    private WebElement destinationField;
    @FindBy(name="pickUpDate")
    private WebElement startDateField;
    @FindBy(name="nights")
    private WebElement durationField;
    @FindBy(name="theme")
    private WebElement holidayTypeField;
    @FindBy(name="theme")
    private WebElement searchButton;

    CommonElement element;
    DropdownControl dropdown;

    public HomeHolidayPage(WebDriver driver) {
        super(driver);
        element = new CommonElement();
        dropdown = new DropdownControl();
    }

    public void enterDestination(String destinationText) throws Exception {
        element.setText(destinationField, destinationText);
    }

    public void enterStartDate(String startDateText) throws Exception {
        element.setText(startDateField, startDateText);
    }

    public void selectDuration(String durationText) throws Exception {
        dropdown.selectByVisibleText(durationField, durationText);
    }

    public void selectHolidayType(String holidayTypeText) throws Exception {
        dropdown.selectByVisibleText(holidayTypeField, holidayTypeText);
    }

    public String getDestination() throws Exception {
        return element.getText(destinationField);
    }

    public String getStartDate() throws Exception {
        return element.getText(startDateField);
    }

    public String getDuration() throws Exception {
        return dropdown.getCurrentValue(durationField);
    }

    public String getHolidayType() throws Exception {
        return dropdown.getCurrentValue(holidayTypeField);
    }

    public HomeHolidayPage clickSearchToStayOnHomePage() throws Exception{
        element.clickElement(searchButton);
        return new HomeHolidayPage(driver);
    }

    public HolidaySearchResultsPage clickSearchHolidayToGetSearchResults() throws Exception {
        element.clickElement(searchButton);
        return new HolidaySearchResultsPage(driver);
    }
}
