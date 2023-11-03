package excelTests;

import commonLibs.utils.Constants;
import commonLibs.utils.ExcelDriver;
import org.testng.annotations.Test;

public class ExcelTests {

    @Test
    public void verifyTestExcelDriverUtil() throws Exception{
        ExcelDriver excelDriver = new ExcelDriver();

        String excelWorkbook = Constants.TESTDATA_DIRECTORY + "ExcelWorkbook.xlsx";
        String sheetName = "TestData";

        excelDriver.createWorkbook(excelWorkbook);
        excelDriver.openWorkbook(excelWorkbook);
        excelDriver.createSheet(sheetName);

        excelDriver.setCellData(sheetName, 0, 0, "Test1");
        excelDriver.setCellData(sheetName, 1, 0, "Test2");
        excelDriver.setCellData(sheetName, 2, 0, "Test3");

        excelDriver.saveFile();
        excelDriver.closeWorkbook();
    }
}
