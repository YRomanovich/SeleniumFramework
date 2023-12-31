package commonLibs.implementation;

import commonLibs.contracts.IScreenshot;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class ScreenshotControl implements IScreenshot {
    private final TakesScreenshot screnshot;
    public ScreenshotControl(WebDriver driver) {
        screnshot = (TakesScreenshot) driver;
    }
    @Override
    public void captureAndSaveScreenshot(String pathFile) throws Exception {
        pathFile = pathFile.trim();

        File imgFile, tmpFile;

        imgFile = new File(pathFile);

        if(imgFile.exists()){
            throw new Exception("Image with this file name already exists.");
        }

        tmpFile = screnshot.getScreenshotAs(OutputType.FILE);

        FileUtils.moveFile(tmpFile, imgFile);

    }
}
