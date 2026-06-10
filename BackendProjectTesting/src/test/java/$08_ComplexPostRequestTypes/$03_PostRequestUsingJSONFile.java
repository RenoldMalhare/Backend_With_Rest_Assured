package $08_ComplexPostRequestTypes;

import static io.restassured.RestAssured.*;

import java.io.File;

import io.restassured.http.ContentType;

public class $03_PostRequestUsingJSONFile {
    public static void main(String[] args) {
		File jsonFile = new File(". /src/test/resources/jsonPostRequestType.json");
		
		given()
		  .contentType(ContentType.JSON)
		  .body(jsonFile)
		.when()
		  .post("http://49.249.29.4:8091/addProject")
		.then()
		  .log().all()
		  .assertThat().statusCode(201);
	}
}
