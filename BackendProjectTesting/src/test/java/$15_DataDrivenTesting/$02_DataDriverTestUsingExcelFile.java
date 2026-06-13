package $15_DataDrivenTesting;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ExcelUtility.ReadDataFromExcel;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
public class $02_DataDriverTestUsingExcelFile {
     @Test(dataProvider = "getData")
     public void DDTTestUsingExcel(String proName, String status) {
    	 String jBody = "{\r\n"
    	 		+ "  \"createdBy\": \"RED\",\r\n"
    	 		+ "  \"projectName\": \""+proName+"\",\r\n"
    	 		+ "  \"status\": \""+status+"\",\r\n"
    	 		+ "  \"teamSize\": 0\r\n"
    	 		+ "}";
    	 
    	 Response resp = given()
    			           .contentType(ContentType.JSON)
    			           .body(jBody)
    			         .when()
    			           .post("http://49.249.29.4:8091/addProject");
    			  resp.then().log().all();
    	 
     }
     
     @DataProvider
     public Object[][] getData() throws EncryptedDocumentException, IOException {
    	 ReadDataFromExcel exlUti = new ReadDataFromExcel();
    	 int count = exlUti.getRowCount("data");
    	 Object[][] obj = new Object[count][2];
    	 
    	 for(int i=0; i<count; i++) {
    		 obj[i][0]= exlUti.getDataFromExcel("data", i+1, 0);
    		 obj[i][1]= exlUti.getDataFromExcel("data", i+1, 1);
    	 }
    	 
		 return obj;
    	 
     }
}
