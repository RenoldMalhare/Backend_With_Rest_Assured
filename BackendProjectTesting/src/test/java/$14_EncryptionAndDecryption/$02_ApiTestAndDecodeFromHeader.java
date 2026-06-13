package $14_EncryptionAndDecryption;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import java.util.Base64;
public class $02_ApiTestAndDecodeFromHeader {
     @Test
     public void test() {
    	 given()
    	    .auth().preemptive().basic("rmgyantra", "rmgy@9999")
    	    .log().all()
    	 .when()
    	    .get("http://49.249.29.4:8091")
    	 .then()
    	    .log().all();
     }
     @Test
     public void testEncodeToDecode() {
    	 // header encoded value from previous test  
     	 String decode = new String(Base64.getDecoder().decode("cm1neWFudHJhOnJtZ3lAOTk5OQ==".getBytes()));
    	 System.out.println(decode);
     }
}
