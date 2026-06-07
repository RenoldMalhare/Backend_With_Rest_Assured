package $04_CRUD_Without_BDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class $05_TestToDeleteTheData {
     @Test
     public void getReqTest() {
    	 Response resp = RestAssured.delete("http://49.249.29.4:8091/project/NH_PROJ_260");
    	 
//    	 System.out.print(resp.prettyPrint());
    	 System.out.println(resp.then().log().all());
         resp.then().assertThat().statusCode(204);
     }
}
