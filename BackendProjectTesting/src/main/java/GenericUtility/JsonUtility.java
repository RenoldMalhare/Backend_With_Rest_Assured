package GenericUtility;

import java.io.IOException;
import java.util.List;

import com.jayway.jsonpath.JsonPath;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class JsonUtility {
	FileUtility fb = new FileUtility();
	
    public String getDataOnJsonPath(Response resp, String jsonXpath) {
    	List<Object> list = JsonPath.read(resp.asString(), jsonXpath);
    	return list.get(0).toString();
    }
    
    //create get th xml data from based on xml complex xpath
    
    public String getDataOnXpath(Response resp, String xmlXpath) {
    	return resp.xmlPath().get(xmlXpath);
    }
    
    public boolean verifyDataOnJsonPath(Response resp, String jsonXpath, String expectedData) {
    	List<String> list = JsonPath.read(resp.asString(), jsonXpath);
    	boolean flag = false;
    	for(String s : list) {
    		if(s.equals(expectedData)) {
    			flag= true;
    		}
    	}
    	return flag;
    }
    
    public String getAcessToken() throws IOException {
    	Response resp = given()
    			          .formParam("client_id", fb.getDataFromPropertiesFile("Client_ID"))
    			          .formParam("client_secret", fb.getDataFromPropertiesFile(""))
                          .formParam("grant_type", "client_credentials")
                        .when()
                          .post("http://49.249.29.4:8180/auth/realms/ninza/protocol/openid-connect/token");
                 resp.then()
                       .log().all();
                 
        String token = resp.jsonPath().get("access_token");
        return token;
    }
}
