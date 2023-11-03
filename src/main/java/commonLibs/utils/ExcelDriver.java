package commonLibs.utils;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class ExcelDriver {
    private InputStream fileReader;
    private OutputStream fileWriter;
    private Workbook excelWorkbook;
    private String excelFileName;

    public void createWorkbook(String filename) throws Exception{
        filename = filename.trim();

        File file = new File(filename);

        if(file.exists()){
            throw new Exception("File already exists... create a file with new name");
        }

        if (filename.endsWith(".xls")) {
            excelWorkbook = new HSSFWorkbook();
        } else if (filename.endsWith(".xlsx")) {
            excelWorkbook = new XSSFWorkbook();
        } else {
            throw new Exception("Invalid file format - supported formats are .xls and .xlsx");
        }

        fileWriter = new FileOutputStream(filename);
        excelWorkbook.write(fileWriter);
        fileWriter.close();
        excelWorkbook.close();
    }

    public void openWorkbook(String filename) throws Exception {
        filename = filename.trim();

        excelFileName = filename;

        File file = new File(filename);

        if (!file.exists()) throw new Exception("File does not exist.");

        fileReader = new FileInputStream(filename);

        excelWorkbook = WorkbookFactory.create(fileReader);
    }

    public void createSheet(String sheetName) throws Exception {
        sheetName = sheetName.trim();

        Sheet sheet = excelWorkbook.getSheet(sheetName);

        if (sheet != null) throw new Exception("Sheet already exists.");

        excelWorkbook.createSheet(sheetName);
    }

    public int getRowsCount(String sheetName) throws Exception {
        sheetName = sheetName.trim();

        Sheet sheet = excelWorkbook.getSheet(sheetName);

        if (sheet == null) throw new Exception("Sheet does not exist.");

        return sheet.getLastRowNum();
    }

    public int getCellsCountForRow(String sheetName, int rowNumber) throws Exception {
        sheetName = sheetName.trim();

        Sheet sheet = excelWorkbook.getSheet(sheetName);

        if (sheet == null) throw new Exception("Sheet does not exist.");
        if (rowNumber < 0) throw new Exception("Invalid row number.");

        Row row = sheet.getRow(rowNumber);

        if (row == null){
            return 0;
        } else {
            return row.getLastCellNum();
        }
    }

    public String getCellData(String sheetName, int rowNumber, int cellNumber) throws Exception {
        sheetName = sheetName.trim();

        Sheet sheet = excelWorkbook.getSheet(sheetName);

        if (sheet == null) throw new Exception("Sheet does not exist.");
        if (rowNumber < 0 || cellNumber < 0) throw new Exception("Invalid row number.");

        Row row = sheet.getRow(rowNumber);

        if (row == null) return "";

        Cell cell = row.getCell(cellNumber);

        if (cell == null) return "";
        else { if (cell.getCellType() == CellType.NUMERIC) return String.valueOf(cell.getNumericCellValue());
               else return cell.getStringCellValue(); }
    }

    public void setCellData(String sheetName, int rowNumber, int cellNumber, String text) throws Exception {
        sheetName = sheetName.trim();

        Sheet sheet = excelWorkbook.getSheet(sheetName);

        if (sheet == null) throw new Exception("Sheet does not exist.");
        if (rowNumber < 0 || cellNumber < 0) throw new Exception("Invalid row number.");

        Row row = sheet.getRow(rowNumber);

        if (row == null) {
            sheet.createRow(rowNumber);

            row = sheet.getRow(rowNumber);
        }

        Cell cell = row.getCell(cellNumber);

        if (cell == null) {
            row.createCell(cellNumber);

            cell = row.getCell(cellNumber);
        }

        cell.setCellValue(text);
    }

    public void saveFile() throws Exception{
        fileWriter = new FileOutputStream(excelFileName);

        excelWorkbook.write(fileWriter);
        fileWriter.close();
    }

    public void saveAsFile(String fileName) throws Exception{
        fileName = fileName.trim();

        File file = new File(fileName);

        if (file.exists()) throw new Exception("File already exists...");

        fileWriter = new FileOutputStream(fileName);
        excelWorkbook.close();
        fileWriter.close();
    }

    public void closeWorkbook() throws Exception{
        fileReader.close();
        fileWriter.close();
        excelWorkbook.close();
    }
}
