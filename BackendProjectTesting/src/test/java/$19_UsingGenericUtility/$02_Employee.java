package $19_UsingGenericUtility;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.sql.SQLException;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Endpoints.IEndpoints;
import GenericUtility.DbUtility;
import GenericUtility.FileUtility;
import GenericUtility.JavaUtility;
import PojoUtility.EmployeePojo;
import PojoUtility.PojoProjectForPostRequestType;
import baseApiClass.BaseClassForApi;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class $02_Employee extends BaseClassForApi{
//    JavaUtility jb = new JavaUtility();
    PojoProjectForPostRequestType pojoPro;
//    FileUtility fu;
//    DbUtility dbu = new DbUtility();
//    
//    @BeforeSuite
//	public void configBS() throws IOException {
//		dbu.connectToDbL();
//	}
//	
//	@AfterSuite
//	public void configAS() throws SQLException {
//		dbu.closeDb();
//	} 
	
	@Test
    public void addEmployeeTest() throws IOException, SQLException {
    	String projectName = "RedM_"+ju.getRandomNum();
    	String userName = "user"+ju.getRandomNum();
        
    	pojoPro = new PojoProjectForPostRequestType("Blank", "Created", 0,projectName);
        fu = new FileUtility();
  	  Response resp =	given()
  		  .contentType(ContentType.JSON)
  		  .body(pojoPro)
  		.when()
  		  .post(""+fu.getDataFromPropertiesFile("BASE_URI")+IEndpoints.AddProj);
  	  
  		resp.then()
  		  .log().all()
  		  .assertThat().statusCode(201);
  		
  		EmployeePojo empObj = new EmployeePojo("Architect", "13/04/1993", "red1@gmail.com", userName, 8, "9877337383", projectName, "hae", userName);
  		
  		given()
  		  .contentType(ContentType.JSON)
  		  .body(empObj)
  		.when()
  		  .post(fu.getDataFromPropertiesFile("BASE_URI")+IEndpoints.AddEmp)
  	    .then()
  	      .log().all()
  	      .assertThat().statusCode(201)
  	      .assertThat().contentType(ContentType.JSON)
  	      .and()
  	      .assertThat().time(Matchers.lessThan(3000l));  
  		
  		//verify the employee creation
  		
//  		boolean flag = dbu.executeQueryVerifyAndGetData("select * form project", 4, userName);
//		Assert.assertTrue(flag,"Project in db is not verified");
	}
}
