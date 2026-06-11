package $12_TypesOfPatameter;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
public class $02_QueryParameter {
    @Test
    public void queryParamTest() {
    	//we can use dataprovider to pass the data here
        given()
          .queryParam("teamSize", 1)
        .when()
          .get("http://49.249.29.4:8091/project")
        .then()
          .log().all();
    }
}
