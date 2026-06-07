package $05_CRUD_With_BDD.copy;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class $03_TestToUpdateTheFullData {
	@Test
     public void putReqForProjectTest() {
    
    	 JSONObject jsonObj = new JSONObject();
       	 jsonObj.put("createdBy", "Blue");
     	 jsonObj.put("projectName","Blue_Project");
    	 jsonObj.put("status","Created");
    	 jsonObj.put("teamSize",0);
   
    	 RequestSpecification req = RestAssured.given();
    	 req.contentType(ContentType.JSON);
    	 req.body(jsonObj.toJSONString());
    	 
    	 Response resp = req.put("http://49.249.29.4:8091/project/NH_PROJ_261");
    	 resp.then().log().all();
    	 resp.then().assertThat().statusCode(200);
    	 
     }
}
