package $10_RequestChaining;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
public class $03_GetPayrollInfo {
    @Test
    public void getPayrollInfo() {
    	Response resp =  given()
    			           .formParam("client_id", "ninza-client")
    			           .formParam("client_secret", "gPQBf1Yxew5OMccMhzos1GefIyiSnXzM")
    			           .formParam("grant_type", "client_credentials")
    			         .when()
    			           .post("http://49.249.29.4:8180/auth/realms/ninza/protocol/openid-connect/token");
    	         resp.then().log().all();
    	         String token = resp.jsonPath().getString("access_token");
    	         
    	 given()
    	   .auth().oauth2(token)
    	   .get("http://49.249.29.4:8091/admin/payrolls")
    	   .then()
    	   .log().all();
    	 
    }
}
