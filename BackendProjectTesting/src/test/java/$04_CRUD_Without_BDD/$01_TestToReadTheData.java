package $04_CRUD_Without_BDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class $01_TestToReadTheData {
     @Test
     public void getReqTest() {
    	 Response resp = RestAssured.get("http://49.249.29.4:8091/projects");
    	 
//    	 System.out.print(resp.prettyPrint());
    	 System.out.println(resp.then().log().all());
         resp.then().assertThat().statusCode(200);
     }
}
