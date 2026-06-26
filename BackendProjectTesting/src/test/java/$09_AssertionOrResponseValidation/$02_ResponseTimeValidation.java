package $09_AssertionOrResponseValidation;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;
public class $02_ResponseTimeValidation {
    @Test
    public void timeValidation() {
    	Response resp = given().get("http://49.249.29.4:8091/projects");
    	resp.then().log().all();

    	long timeTaken = resp.time();
    	long timeTakenSec = resp.timeIn(TimeUnit.SECONDS);
    	long timeTaken1 = resp.getTime();
    	long timeTakenSec2 = resp.getTimeIn(TimeUnit.SECONDS);
    	System.out.println(timeTaken);
    	System.out.println(timeTakenSec);
    	System.out.println(timeTaken1);
    	System.out.println(timeTakenSec2);
    	
    	
    	resp.then().assertThat().time(Matchers.lessThan(900l));
    	resp.then().assertThat().time(Matchers.greaterThan(300l));
    	
    	resp.then().assertThat().time(Matchers.both(Matchers.lessThan(900l)).and(Matchers.greaterThan(300l)));
    }
}
