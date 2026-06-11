package $10_RequestChaining;

import java.util.Random;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import PojoUtility.EmployeePojo;
import PojoUtility.PojoProjectForPostRequestType;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
public class $02_RequestChainingAddEmployTest {
    @Test
    public void addEmployee() {
    	Random r = new Random();
    	int rand = r.nextInt(5000);
    	
    	PojoProjectForPostRequestType proObj = new PojoProjectForPostRequestType("Black", "Created", 0, "Black_"+rand);
    	//Api1 ===> Create a project
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
    	
    	String projectName = resp.jsonPath().get("projectName");
    	System.out.println(projectName);
    	
    	//Api2 ---> add a employee to the project
    	EmployeePojo empObj = new EmployeePojo("QA Engineer", "10/03/2000", "red@gmail.com", "Red Mal", 5.0d,
    			"9998885556", projectName, "ROLE_EMPLOYEE", "Red@10");
    	Response resp1 = given()
    			           .contentType(ContentType.JSON)
    			           .body(empObj)
    			         .when()
    			           .post("http://49.249.29.4:8091/employees");
    	resp1.then()
    	       .assertThat().statusCode(201)
    	       .log().all();
    }
}
