 package $09_AssertionOrResponseValidation;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
public class $03_ResponseBodyValidation {
    @Test
    public void responseBodyValidatiton() {
        Response resp = given().get("http://49.249.29.4:8091/projects-paginated");
        
        resp.then().log().all();
        
        //fetching the data form the response body
        int dataCount = resp.jsonPath().get("numberOfElements");
        System.out.println(dataCount);
        
        boolean data = resp.jsonPath().get("pageable.sort.unsorted");
        System.out.println(data);
        
        String data1 = resp.jsonPath().get("content[0].projectId");
        System.out.println(data1);
        
        resp.then().assertThat().body("numberOfElements", Matchers.greaterThanOrEqualTo(20));
        resp.then().assertThat().body("pageable.sort.unsorted", Matchers.equalTo(true));
        resp.then().assertThat().body("content[0].projectId", Matchers.equalTo("NH_PROJ_406"));
    }
}
