package $05_CRUD_With_BDD.copy;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
public class $05_TestToDeleteTheData {
     @Test
     public void getReqTest() {
    	 
    	 given()
    	   .delete("http://49.249.29.4:8091/project/NH_PROJ_262")
    	 .then()
    	   .assertThat().statusCode(204)
    	   .log().all(); 
     }
}
