package $13_Authentication;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
public class $05_Auth2_0_Test {
    @Test
    public void auth2point0(){
    	//Not executable because no access to params is given
		Response resp = given()
				          .formParam("client_id", "ninza-client")
				          .formParam("client_secret", "a;sldkfjlajsjdflkjalsdj")
				          .formParam("grant_type", "client_credentials")
				       .when()
				          .post("http://49.249.29.4:8091/auth/realms/ninza/protocol/openid-connect/token");
				 resp.then()
				       .log().all();
		// keyclock web tool will be used to generate the token; and capture the token 
				String token = resp.jsonPath().get("access_token");
    	 
    	
    	given()
    	  .auth().oauth2(token)
    	.when()
    	  .get("http://49.249.29.5:8091")
    	.then()
    	  .log().all();
    }
}
