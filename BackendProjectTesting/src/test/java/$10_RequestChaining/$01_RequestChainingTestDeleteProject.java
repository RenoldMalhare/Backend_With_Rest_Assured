package $10_RequestChaining;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import PojoUtility.PojoProjectForPostRequestType;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import java.util.Random;

public class $01_RequestChainingTestDeleteProject {
     @Test
     public void deleteProject() {
    	 Random r = new Random();
    	int rand = r.nextInt(5000);
    	 PojoProjectForPostRequestType proObj = new PojoProjectForPostRequestType( "Redi", "Created", 0, "Red_"+rand);
    	 //1. Api1 ===>  Add Project
    	 Response resp = given()
    			           .contentType(ContentType.JSON)
    			           .body(proObj)
    	                 .when()
    	                   .post("http://49.249.29.4:8091/addProject");
    	          resp.then()
    	                 .assertThat().statusCode(201)
    	                 .and()
    	                 .assertThat().body("msg", Matchers.equalTo("Successfully Added"))
    	                 .log().all();
    	          
    	 //Capture the project id form response;
    	 String projectId = resp.jsonPath().get("projectId");
    	 System.out.println(projectId);
    	 
    	 //2. Delete the project using project id
    	 
    	 Response resp1 = given()
    			           .delete("http://49.249.29.4:8091/project/"+projectId);
    			         resp1.then()
    			           .assertThat().statusCode(204)
    			           .log().all();
     }
}
