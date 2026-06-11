package $13_Authentication;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;
public class $04_BearerTokenAuthTest {
    @Test
    public void bearerTokenTest() {
    	JSONObject jsonObj = new JSONObject();
      	 jsonObj.put("email", "theobald2798+varney@gmail.com");
    	 jsonObj.put("password","Hellored1#");
   	     jsonObj.put("role","SHOPPER");
   	 
    	Response resp = given()
    			          .relaxedHTTPSValidation()
    			          .contentType(ContentType.JSON)
    			          .body(jsonObj)
    			        .when()
    			          .post("https://www.shoppersstack.com/shopping/users/login");
    	                     
    	
    	String token = resp.jsonPath().get("data.jwtToken");
    	int shopperId = resp.jsonPath().get("data.userId");
    	System.out.println(token);
    	
    	given()
    	  .relaxedHTTPSValidation()
    	  .auth().oauth2(token)
    	.when()
    	  .get("https://www.shoppersstack.com/shopping/shoppers/"+shopperId+"/address")
    	.then()
    	  .log().all();
    	
    }
}
