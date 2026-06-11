package $13_Authentication;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
public class $03_PreEmptiveAuthentication {
    @Test
    public void preemptiveAuthTest() {
    	given()
    	  .auth().preemptive().basic("rmgyantra", "rmgy@9999")
    	  .log().all()
    	.when()
    	  .get("http://49.249.29.4:8091")
    	.then()
    	  .log().all();
    }
}
