package $09_AssertionOrResponseValidation;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class $01_ResponseHeaderValidation {
    @Test
    public void headerValidation() {
    	Response resp = given().get("http://49.249.29.4:8091/projects");
    	
    	resp.then().log().all();
    	resp.then().assertThat().statusLine("HTTP/1.1 200 ");
    	resp.then().statusCode(200);
    	resp.then().contentType(ContentType.JSON);
    	resp.then().header("X-Frame-Options", "DENY");
    }
}
