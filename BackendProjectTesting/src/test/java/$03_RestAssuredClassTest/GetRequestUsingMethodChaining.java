package $03_RestAssuredClassTest;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class GetRequestUsingMethodChaining {
    @Test
    public void getRequestTest() {
    	get("https://fakestoreapi.com/products").then().log().all();
    }
}
