package $04_CRUD_Without_BDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class $02_TestToCreateTheData {
	@Test
     public void postReqForProjectTest() {
    
    	 JSONObject jsonObj = new JSONObject();
       	 jsonObj.put("createdBy", "Black");
     	 jsonObj.put("projectName","Black_Project");
    	 jsonObj.put("status","Created");
    	 jsonObj.put("teamSize",0);
   
    	 RequestSpecification req = RestAssured.given();
    	 req.contentType(ContentType.JSON);
    	 req.body(jsonObj.toJSONString());
    	 
    	 Response resp = req.post("http://49.249.29.4:8091/addProject");
    	 resp.then().log().all();
    	 resp.then().assertThat().statusCode(201);
    	 
     }
}
