package $08_ComplexPostRequestTypes;

import java.util.HashMap;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
public class $02_PostRequestUsingHashMap {
    public static void main(String[] args) {
	    HashMap<String, Object> map = new HashMap<>();
	    
	    map.put("createdBy", "Red2");
		map.put("status", "Created");
		map.put("teamSize", 0);
		map.put("projectName", "Red_Project2");	
	    
		given()
		  .contentType(ContentType.JSON)
		  .body(map)
		.when()
		  .post("http://49.249.29.4:8091/addProject")
		.then()
		  .log().all()
		  .assertThat().statusCode(201);
    }
}
