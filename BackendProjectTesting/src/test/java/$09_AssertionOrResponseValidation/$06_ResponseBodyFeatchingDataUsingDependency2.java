package $09_AssertionOrResponseValidation;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.jsonpath.JsonPath;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;
public class $06_ResponseBodyFeatchingDataUsingDependency2 {
    @Test
    public void responseBodyValidatiton() {
        Response resp = given().get("http://49.249.29.4:8091/projects-paginated");
        
        resp.then().log().all();

        List<String> list = JsonPath.read(resp.asString(), ".content[*].[?(@.projectName == 'Airtel4178')].projectId");
//        for(String data: list) {
//        	System.out.println(data);
//        }
        String data = list.get(0);
        System.out.println(data);
        Assert.assertEquals(data, "NH_PROJ_005");
        
    }
}
