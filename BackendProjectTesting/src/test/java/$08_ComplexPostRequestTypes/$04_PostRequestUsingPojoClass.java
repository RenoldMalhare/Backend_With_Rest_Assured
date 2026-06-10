package $08_ComplexPostRequestTypes;

import org.testng.annotations.Test;

import PojoUtility.PojoProjectForPostRequestType;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class $04_PostRequestUsingPojoClass {
    @Test
    public void pojoPostRequest() {
//    	PojoProjectForPostRequestType pojoPro = new PojoProjectForPostRequestType("Blank", "Created",0, "blank_Project");
    	
    	given()
    	  .contentType(ContentType.JSON)
//    	  .body(pojoPro)
    	.when()
    	  .post("http://49.249.29.4:8091/addProject")
    	.then()
    	  .log().all()
    	  .assertThat().statusCode(201);
    }
}
