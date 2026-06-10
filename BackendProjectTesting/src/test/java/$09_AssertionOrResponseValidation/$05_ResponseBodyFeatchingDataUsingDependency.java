package $09_AssertionOrResponseValidation;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.jayway.jsonpath.JsonPath;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;
public class $05_ResponseBodyFeatchingDataUsingDependency {
    @Test
    public void responseBodyValidatiton() {
        Response resp = given().get("http://49.249.29.4:8091/projects-paginated");
        
        resp.then().log().all();

        List<String> list = JsonPath.read(resp.asString(), ".content[*].projectName");
        
        for(String s : list) {
        	System.out.println(s);
        }
        
    }
}
