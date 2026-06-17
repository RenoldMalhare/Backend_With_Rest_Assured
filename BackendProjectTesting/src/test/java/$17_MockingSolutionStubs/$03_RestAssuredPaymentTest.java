package $17_MockingSolutionStubs;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
public class $03_RestAssuredPaymentTest {
    @Test
    public void test() {
    	JSONObject jObj = new JSONObject();
    	jObj.put("creditcard", "1234567891234");
    	jObj.put("cvv", "123");
    	jObj.put("cardName", "Red");
    	given()
    	  .body(jObj)
    	.when()
    	  .post("http://localhost:8889/credit-card")
    	.then()
    	  .log().all();
    }
}
