package $05_CRUD_With_BDD.copy;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class $03_TestToUpdateTheFullData {
	@Test
     public void putReqForProjectTest() {
    
    	 JSONObject jsonObj = new JSONObject();
       	 jsonObj.put("createdBy", "black");
     	 jsonObj.put("projectName","black_project");
    	 jsonObj.put("status","Created");
    	 jsonObj.put("teamSize",0);
   
    	 given()
    	    .contentType(ContentType.JSON)
    	    .body(jsonObj.toJSONString())
    	 
    	 .when()
    	    .put("http://49.249.29.4:8091/project/NH_PROJ_154")
    	 
    	 .then()
    	    .assertThat().statusCode(200)
    	    .log().all();   	 
     }
}
