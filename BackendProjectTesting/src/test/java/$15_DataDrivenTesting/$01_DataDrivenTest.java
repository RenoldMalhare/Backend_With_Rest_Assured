package $15_DataDrivenTesting;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class $01_DataDrivenTest {
     @Test(dataProvider = "getData")
     public void DDTest(String proName, String status) {
//    	 String proName = "Red_Aura";
//    	 String status = "Created";
    	 String body = "{\r\n"
    	 		+ "  \"createdBy\": \"Red\",\r\n"
    	 		+ "  \"projectName\": \""+proName+"\",\r\n"
    	 		+ "  \"status\": \""+status+"\",\r\n"
    	 		+ "  \"teamSize\": 0\r\n"
    	 		+ "}";
    	 
    	 Response resp = given()
    			           .contentType(ContentType.JSON)
    			           .body(body)
    			         .when()
    			           .post("http://49.249.29.4:8091/addProject");
    			  resp.then().log().all();		  
     }
     
     @DataProvider
     public Object[][] getData(){
    	 Object[][] objData = new Object[2][2];
    	 objData[0][0]= "bw";
    	 objData[0][1]= "Created";
    	 
    	 objData[1][0]= "e";
    	 objData[1][1]= "Created";
		 return objData;
     }
}
