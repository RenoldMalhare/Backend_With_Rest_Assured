package $13_Authentication;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
public class $02_DigestAuthentication {
    @Test
    public void digestAuthTest() {
    	given()
    	  .auth().digest("rmgyantra", "rmgy@9999")//here in the backend , using md5 algorithm it will be encripted
    	.when()
    	  .get("http://49.249.29.4:8091")
    	.then()
    	  .log().all();
    }
}
