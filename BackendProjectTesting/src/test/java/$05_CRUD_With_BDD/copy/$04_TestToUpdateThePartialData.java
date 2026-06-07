package $05_CRUD_With_BDD.copy;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class $04_TestToUpdateThePartialData {
	@Test
     public void putReqForProjectTest() {
    
    	 JSONObject jsonObj = new JSONObject();
       	 jsonObj.put("createdBy", "yellowColor");
     	 
       	 given()
       	    .contentType(ContentType.JSON)
       	    .body(jsonObj.toJSONString())
       	 .when()
       	    .patch("http://49.249.29.4:8091/project/NH_PROJ_262")
       	 .then()
       	    .assertThat().statusCode(200)
       	    .log().all();
   
//    	 RequestSpecification req = RestAssured.given();
//    	 req.contentType(ContentType.JSON);
//    	 req.body(jsonObj.toJSONString());
//    	 
//    	 Response resp = req.patch("http://49.249.29.4:8091/project/NH_PROJ_261");
//    	 resp.then().log().all();
//    	 resp.then().assertThat().statusCode(200);
    	 
     }
}
