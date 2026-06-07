 package $05_CRUD_With_BDD.copy;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class $01_TestToReadTheData {
     @Test
     public void getReqTest() {
    	 given()
    	     .get("http://49.249.29.4:8091/projects")
    	 .then()
    	     .assertThat().statusCode(200)
    	     .log().all();
    	 
    	 
     }
}
