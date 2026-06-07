package $05_CRUD_With_BDD.copy;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class $04_TestToUpdateThePartialData {
	@Test
     public void putReqForProjectTest() {
    
    	 JSONObject jsonObj = new JSONObject();
       	 jsonObj.put("createdBy", "BlueColor");
     	 
   
    	 RequestSpecification req = RestAssured.given();
    	 req.contentType(ContentType.JSON);
    	 req.body(jsonObj.toJSONString());
    	 
    	 Response resp = req.patch("http://49.249.29.4:8091/project/NH_PROJ_261");
    	 resp.then().log().all();
    	 resp.then().assertThat().statusCode(200);
    	 
     }
}
