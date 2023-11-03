package commonLibs.utils;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
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
            throw new Exception("File already exist... create a file with new name");
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

    public void openWorkbook(String filename) throws Exception{
        filename = filename.trim();

        excelFileName = filename;


    }
}
