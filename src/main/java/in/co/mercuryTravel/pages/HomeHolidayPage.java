package in.co.mercuryTravel.pages;

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


    public HomeHolidayPage(WebDriver driver) {
        super(driver);
    }

    public void enterDestination(String destinationText) throws Exception {
        commonElement.setText(destinationField, destinationText);
    }

    public void enterStartDate(String startDateText) throws Exception {
        commonElement.setText(startDateField, startDateText);
    }

    public void selectDuration(String durationText) throws Exception {
        dropdownControl.selectByVisibleText(durationField, durationText);
    }

    public void selectHolidayType(String holidayTypeText) throws Exception {
        dropdownControl.selectByVisibleText(holidayTypeField, holidayTypeText);
    }

    public String getDestination() throws Exception {
        return commonElement.getText(destinationField);
    }

    public String getStartDate() throws Exception {
        return commonElement.getText(startDateField);
    }

    public String getDuration() throws Exception {
        return dropdownControl.getCurrentValue(durationField);
    }

    public String getHolidayType() throws Exception {
        return dropdownControl.getCurrentValue(holidayTypeField);
    }

    public HomeHolidayPage clickSearchToStayOnHomePage() throws Exception{
        commonElement.clickElement(searchButton);
        return new HomeHolidayPage(driver);
    }

    public HolidaySearchResultsPage clickSearchHolidayToGetSearchResults() throws Exception {
        commonElement.clickElement(searchButton);
        return new HolidaySearchResultsPage(driver);
    }
}
