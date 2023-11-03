package io.co.mercuryTravel.utils;

import commonLibs.utils.Constants;
import commonLibs.utils.ExcelDriver;
import org.testng.annotations.DataProvider;

public class TestDataProvider {
    @DataProvider
    public Object[][] getUserData() throws Exception {
        String workbookName = Constants.TESTDATA_DIRECTORY + "TestData.xlsx";
        String sheetName = "TestData";

        ExcelDriver excelDriver = new ExcelDriver();
        excelDriver.openWorkbook(workbookName);

        int rowsCount = excelDriver.getRowsCount(sheetName);
        int cellsCount = excelDriver.getCellsCountForRow(sheetName,0);

        Object[][] data = new Object[rowsCount + 1][ cellsCount + 1];

        for (int row=0; row <= rowsCount; row++){
            for (int cell=0; cell < cellsCount; cell++){
                data[row][cell] = excelDriver.getCellData(sheetName, row, cell);
            }
        }

        return data;
    }
}
