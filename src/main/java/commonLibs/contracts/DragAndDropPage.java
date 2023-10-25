package commonLibs.contracts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;

public class DragAndDropPage extends BasePage {
    @FindBy(id = "draggable")
    @CacheLookup
    private WebElement draggable;

    @FindBy(id = "droppable")
    @CacheLookup
    private WebElement droppable;

    public DragAndDropPage (WebDriver driver) {super(driver);}

    public void dragAndDrop(){
        Actions  action = new Actions(driver);

        action.dragAndDrop(draggable, droppable).build().perform();
        getText(droppable);
        checkColor(droppable);
    }

    public void checkColor(WebElement element){
        String color = element.getCssValue("color");
        System.out.println("Current color of element is " + Color.fromString(color).asHex());
    }

    public void getText(WebElement element){
        String color = element.getText();
        System.out.println("Current text for element is " + color);
    }
}
