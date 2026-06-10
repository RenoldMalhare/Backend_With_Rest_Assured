package $09_AssertionOrResponseValidation;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;
public class $04_ResponseBodyFeatchingData {
    @Test
    public void responseBodyValidatiton() {
        Response resp = given().get("http://49.249.29.4:8091/projects-paginated");
        
        resp.then().log().all();
        
        resp.then().assertThat().body("numberOfElements", Matchers.greaterThanOrEqualTo(20));
        resp.then().assertThat().body("pageable.sort.unsorted", Matchers.equalTo(true));
//        resp.then().assertThat().body("content[0].projectId", Matchers.equalTo("NH_PROJ_406"));
    
        ArrayList<String> lst = resp.jsonPath().get("content.projectId"); 
        //we can get the value but we cannot put the conditions so we go for the dependency jsonPath jayway;
        System.out.println(lst);
    }
}
