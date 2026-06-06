package $00_sample;

import org.testng.annotations.Test;
import io.restassured.response.Response;
import io.restassured.RestAssured;
public class SampleTest {
	@Test
	public void restAssuredTest() {
		Response  resp = RestAssured.get("petstore.swagger.io/v2/pet/findByStatus");
	    System.out.println(resp.prettyPrint());	
	}
}
