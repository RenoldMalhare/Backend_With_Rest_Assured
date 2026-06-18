package GenericUtility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcel {
    public String getDataFromExcel(String sheetName, int rows, int cell) throws EncryptedDocumentException, IOException {
    	FileInputStream fis = new FileInputStream("./src/test/resources/ProjectData.xlsx");
        Workbook wb = WorkbookFactory.create(fis);
        Sheet sh= wb.getSheet(sheetName);
        Row row= sh.getRow(rows);
        Cell cel = row.getCell(cell);
        String data = cel.getStringCellValue();
        return data;
    }
    
    public int getRowCount(String sheetName) throws EncryptedDocumentException, IOException {
    	FileInputStream fis = new FileInputStream("./src/test/resources/ProjectData.xlsx");
        Workbook wb = WorkbookFactory.create(fis);
        Sheet sh= wb.getSheet(sheetName);
        int row= sh.getLastRowNum();    
        return row;
    }
}
