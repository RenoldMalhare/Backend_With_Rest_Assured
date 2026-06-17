package $18_BackendApiTestCaseAutomation;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import PojoUtility.PojoProjectForPostRequestType;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import oracle.jdbc.driver.OracleDriver;

import static io.restassured.RestAssured.*;

public class $01_VerifyTheProjectWithCreateTest {
	String projectName;
	PojoProjectForPostRequestType pObj;
     @Test
     public void addSingleProjectWithCreatedTest() throws SQLException {
    	 Random random = new Random();
    	 int ranNum = random.nextInt(50000);
    	 
    	 String exptedMsg = "Successfully Added";
    	  projectName = "ABB_"+ranNum;
    	 
    	  pObj = new PojoProjectForPostRequestType("Red", "Created",0, projectName );
    	 
    	 Response resp = given()
    			           .contentType(ContentType.JSON)
                           .body(pObj)
                         .when()
                           .post("http://49.249.29.4:8091/addProject");
    	 resp.then()
    	   .assertThat().statusCode(201)
    	   .assertThat().time(Matchers.lessThan(3000l))
    	   .assertThat().contentType(ContentType.JSON)
    	   .log().all();
    	 
    	 String actMsg = resp.jsonPath().get("msg");
    	 Assert.assertEquals(exptedMsg, actMsg);
    	 
//    	 //Verify the project Name in the db layer
//    	 boolean flag = false;
//         
//    	    //Step1: load/register the database driver
// 		Driver driverRef = new OracleDriver();
// 		DriverManager.registerDriver(driverRef);
// 		//Step2: connect to database
// 		Connection conn= DriverManager.getConnection("jdbc:oracle:thin:@ :1521:orcl", "scott", "tiger");
// 		System.out.println("++++++Done++++++");
//     	    //Step3: create sql statement
// 		Statement stat = conn.createStatement();
// 		//Step4: Execute select Query and get result;
// 		ResultSet resultset = stat.executeQuery("SELECT * FROM EMP");
// 		while(resultset.next()) {
// 			if(resultset.getString(4).equals(projectName)) {
//                  flag = true;
//                  break;
// 			}
// 		}
// 		//Step4: close the connection
// 		conn.close();
//        Assert.assertEquals(flag, "Project in DB is not verified");
     }
     
     @Test(dependsOnMethods = "addSingleProjectWithCreatedTest")
     public void createDuplicateProjectTest() {
    	 given()
    	   .contentType(ContentType.JSON)
    	   .body(pObj)
    	 .when()
    	   .post("http://49.249.29.4:8091/addProject")
    	 .then()
    	   .assertThat().statusCode(409)
    	   .log().all();
     }
}
