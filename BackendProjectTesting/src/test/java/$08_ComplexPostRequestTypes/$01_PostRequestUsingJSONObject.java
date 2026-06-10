package $08_ComplexPostRequestTypes;

import org.json.simple.JSONObject;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
public class $01_PostRequestUsingJSONObject {
	public static void main(String[] args) {
		JSONObject jObj = new JSONObject();
		jObj.put("createdBy", "Red");
		jObj.put("status", "Created");
		jObj.put("teamSize", 0);
		jObj.put("projectName", "Red_Project1");
		
		given()
		   .contentType(ContentType.JSON)
		   .body(jObj.toJSONString())
		   
		.when()
		   .post("http://49.249.29.4:8091/addProject")
		   
		.then()
		   .log().all()
		   .assertThat().statusCode(201);
	}
}
