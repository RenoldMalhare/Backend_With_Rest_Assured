package baseApiClass;

import java.io.IOException;
import java.sql.SQLException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import GenericUtility.DbUtility;
import GenericUtility.FileUtility;
import GenericUtility.JavaUtility;
import PojoUtility.PojoProjectForPostRequestType;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.*;
import tools.jackson.databind.introspect.TypeResolutionContext.Basic;

public class BaseClassForApi {
	public JavaUtility ju = new JavaUtility();
	public FileUtility fu = new FileUtility();
	public DbUtility dbu = new DbUtility();
    public static RequestSpecification specobj;
    public static ResponseSpecification resobj;
	@BeforeSuite
	public void configBS() throws IOException {
		dbu.connectToDbL();
		
		RequestSpecBuilder builder = new RequestSpecBuilder();
		builder.setContentType(ContentType.JSON);
//		builder.setAuth(basic("username","password"));
//		builder.addHeader("","");
		builder.setBaseUri(fu.getDataFromPropertiesFile("BASE_URI"));
		specobj = builder.build();
		
		ResponseSpecBuilder resBuilder = new ResponseSpecBuilder();
		resBuilder.expectContentType(ContentType.JSON);
		resobj = resBuilder.build();
	}
	
	@AfterSuite
	public void configAS() throws SQLException {
		dbu.closeDb();
	}
}
