package $16_DataSimulation;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
      String testDataPath = $01_DataSimulationForTransaction.path;
      public String getDataFromExcel(String sheetName, int rows, int cell) throws EncryptedDocumentException, IOException {
      	FileInputStream fis = new FileInputStream(testDataPath);
          Workbook wb = WorkbookFactory.create(fis);
          Sheet sh= wb.getSheet(sheetName);
          Row row= sh.getRow(rows);
          Cell cel = row.getCell(cell);
          String data = cel.getStringCellValue();
          return data;
      }
      
      public int getRowCount(String sheetName) throws EncryptedDocumentException, IOException {
      	FileInputStream fis = new FileInputStream(testDataPath);
          Workbook wb = WorkbookFactory.create(fis);
          Sheet sh= wb.getSheet(sheetName);
          int row= sh.getLastRowNum();    
          return row;
      }
      
      public void setDataInExcel(String sheetName, int rows, int cell, String value) throws EncryptedDocumentException, IOException {
        	FileInputStream fis = new FileInputStream(testDataPath);
            Workbook wb = WorkbookFactory.create(fis);
            Sheet sh= wb.getSheet(sheetName);
            Row row= sh.getRow(rows);
            Cell cel = row.getCell(cell);
            cel.setCellValue(value);
            
            FileOutputStream fos = new FileOutputStream(testDataPath);
            wb.write(fos);
            wb.close();
        }
}
