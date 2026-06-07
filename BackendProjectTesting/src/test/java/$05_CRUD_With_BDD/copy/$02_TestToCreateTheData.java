package $05_CRUD_With_BDD.copy;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class $02_TestToCreateTheData {
	@Test
     public void postReqForProjectTest() {
    
    	 JSONObject jsonObj = new JSONObject();
       	 jsonObj.put("createdBy", "yellow");
     	 jsonObj.put("projectName","yellow_project");
    	 jsonObj.put("status","Created");
    	 jsonObj.put("teamSize",0);
   
    	 given()
    	     .contentType(ContentType.JSON)
    	     .body(jsonObj.toJSONString())
    	     
    	 .when()
    	     .post("http://49.249.29.4:8091/addProject")
    	 
    	 .then().assertThat().statusCode(201)
    	     .log().all();	 
     }
}
