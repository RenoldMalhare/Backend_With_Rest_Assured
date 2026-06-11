package $12_TypesOfPatameter;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
public class $03_FormParam {
    @Test
    public void formParamTest() {
    	//used for authentication a well client id  , client secret etc.
    	given()
    	  .formParam("teamSize", 1)
    	  .log().all()
    	.when()
    	  .post("http://49.249.29.4:8091/project")
    	.then()
    	  .log().all();
    }
}
