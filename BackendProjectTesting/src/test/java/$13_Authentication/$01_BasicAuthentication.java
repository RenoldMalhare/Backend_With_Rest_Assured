package $13_Authentication;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
public class $01_BasicAuthentication {
    @Test
    public void basicAuthTest() {
    	given()
    	   .auth().basic("rmgyantra", "rmgy@9999")
    	   .log().all()
    	.when()
    	  .get("http://49.249.29.4:8091")
    	.then()
    	  .log().all();
    }
}
