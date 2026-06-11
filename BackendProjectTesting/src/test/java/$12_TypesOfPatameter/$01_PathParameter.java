package $12_TypesOfPatameter;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
public class $01_PathParameter {
    @Test
    public void pathParamTest() {
        given()
          .pathParam("projectId", "NH_PROJ_203")
        .when()
          .get("http://49.249.29.4:8091/project/{projectId}")
        .then()
          .log().all();
    }
}
