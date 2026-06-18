package $19_UsingGenericUtility;

import static io.restassured.RestAssured.given;
import static org.mockito.ArgumentMatchers.contains;

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
import PojoUtility.PojoProjectForPostRequestType;
import baseApiClass.BaseClassForApi;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class $01_ProjectCreation extends BaseClassForApi{
//	JavaUtility ju = new JavaUtility();
	PojoProjectForPostRequestType pojoPro;
//	FileUtility fu = new FileUtility();
//	DbUtility dbu = new DbUtility();
//	
//	@BeforeSuite
//	public void configBS() throws IOException {
//		dbu.connectToDbL();
//	}
//	
//	@AfterSuite
//	public void configAS() throws SQLException {
//		dbu.closeDb();
//	}
	
	@Test
	public void addProject() throws IOException, SQLException {
        
        String expmsg = "Successfully Added";
        String projectName = "Red_"+ju.getRandomNum();
		pojoPro = new PojoProjectForPostRequestType("Blank", "Created", 0,projectName);
        
	  Response resp =	given()
		  .contentType(ContentType.JSON)
		  .body(pojoPro)
		.when()
		  .post(""+fu.getDataFromPropertiesFile("BASE_URI")+IEndpoints.AddProj);
	  
		resp.then()
		  .assertThat().statusCode(201)
		  .assertThat().time(Matchers.lessThan(3000l))
		  .assertThat().contentType(ContentType.JSON)
		  .log().all();
		
		String actMsg = resp.jsonPath().get("msg");
		Assert.assertEquals(expmsg, actMsg);
		
	//	//verify the projectName in db layer
//		boolean flag = dbu.executeQueryVerifyAndGetData("select * form project", 4, projectName);
//		Assert.assertTrue(flag,"Project in db is not verified");

	}
}
