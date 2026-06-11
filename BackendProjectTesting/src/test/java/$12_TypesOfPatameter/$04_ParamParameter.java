package $12_TypesOfPatameter;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
public class $04_ParamParameter {
    @Test
    public void paramParameterTest() {
        // can be used as query as well as form parameter depends on type of request get=>query or post=>formparameter
    	given()
    	  .param("teamSize", 1)
    	  .log().all()
    	.when()
    	  .get("http://49.249.29.4:8091/project")
    	.then()
    	  .log().all();
    }
}
