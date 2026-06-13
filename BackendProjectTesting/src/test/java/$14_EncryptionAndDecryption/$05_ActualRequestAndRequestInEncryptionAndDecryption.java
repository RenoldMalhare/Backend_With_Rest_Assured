package $14_EncryptionAndDecryption;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class $05_ActualRequestAndRequestInEncryptionAndDecryption {
    @Test
    public void test() throws Exception {
    	String jBody = "{ \"employee\": { \"empId\":\"NH_00009\", \"designation\": \"Softwareemgineer\", \"dob\": \"12/06/2004\", \"email\": \"cshwetha@gmail.com\", \"empName\": \"User_1228\", \"experience\": 8, \"mobileNo\": \"8657948201\", \"project\": \"JIO_4099\", \"role\": \"admin\", \"username\": \"User_1228\" }, \"basicPlusVda\": 5200, \"hra\": 5000, \"insurance\": 5000, \"lta\": 0, \"lwf\": 0, \"netPay\": 0, \"payroll_id\": 1, \"pf\": 0, \"pt\": 0, \"stat_bonus\": 0, \"status\": \"Active\" }";
      
    	$03_EncryptAndDecryptUtility ed = new $03_EncryptAndDecryptUtility();
    	
    	String jReqBody = ed.encrypt(jBody, "Ac03tEam@j!tu_#1");
    	
    	System.out.println(jReqBody);    
    	Response res = given()
    			         .contentType(ContentType.JSON)
    			         .body(jReqBody)
    			       .when()
    			         .put("http://49.249.29.4:8091/payroll");
    			 res.then()
    			      .log().all();
//    			 System.out.println(res.getBody().asString());
        String respBody = ed.decrypt(res.getBody().asString(), "Ac03tEam@j!tu_#1");
        System.out.println(respBody);
    			
    }
}
