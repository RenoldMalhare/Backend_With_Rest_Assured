 package $11_RequestChainingMicroWebService;

import static io.restassured.RestAssured.*;

import java.time.Duration;
import java.util.LinkedHashMap;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class $01_CreateOrderWithPaymentNimbbl {
    public static void main(String[] args) {
    	//Set base URI
		baseURI = "https://api.nimbbl.tech/";
		
		//Authorization Post request to generate token
		//Required Body
		 String access_key = "access_key_pKx7rWVgVpbXQvq2";
		 String access_secret="access_secret_DX3w55VKAkXbx7aB";
         String authrizReqBody = "{\"access_key\": \""+access_key+"\", \"access_secret\": \""+access_secret+"\"}";
         
         Response authoRespBody = given()
        		           .body(authrizReqBody)
        		           .contentType(ContentType.JSON)
        		         .when()
        		           .post("api/v3/generate-token");
                authoRespBody.then().log().all();
         
         String BearerToken = authoRespBody.jsonPath().get("token");
         System.out.println(BearerToken);
         
         //Create an order Post Request
         String invoiceId = "inv_"+new Random().nextInt();
         //check this value once object:
         String createReqBody = "{\"amount_before_tax\": 2100,\"tax\": 105,\"total_amount\": 2205,\"user\": {\"email\": \"wonderwoman@themyscira.gov\",\"first_name\": \"Diana\",\"last_name\": \"Prince\",\"country_code\": \"+91\",\"mobile_number\": \"9876543210\"},\"shipping_address\": {\"address_1\": \"1080 Beach Mansion\",\"street\": \"Magic Beach Drive\",\"landmark\": \"Opposite Magic Mountain\",\"area\": \"Elyria\",\"city\": \"Atlantis\",\"state\": \"Castalia\",\"pincode\": \"100389\",\"address_type\": \"Beach House\"},\"currency\": \"INR\",\"invoice_id\": \""+invoiceId +"\",\"custom_attributes\": {\"name\": \"Diana\",\"place\": \"Themyscira\",\"animal\": \"Jumpa\",\"thing\": \"Tiara\"}}";
         Response createOrderResp = given()
        		                      .header("Authorization","Bearer "+BearerToken)
        		                      .body(createReqBody)
        		                      .contentType(ContentType.JSON)
        		                      .post("");
               createOrderResp.then().log().all();
               
               String orderId = createOrderResp.jsonPath().get("order_id");
               String userToken = createOrderResp.jsonPath().get("user.token");
               System.out.println(orderId);
               System.out.println(userToken);
         
         //initialte Payment post request
         LinkedHashMap<String, String> initiatePaymetHeader = new LinkedHashMap<String, String>();
         initiatePaymetHeader.put("Authorization","Bearer " +	 BearerToken);
         initiatePaymetHeader.put("x-nimbbl-user-token", userToken);
         String initPaymentReqBody = "{}"; //copy form nimbbl websiteand put orderid from previous response
         
         Response resBody = given()
        		              .headers(initiatePaymetHeader)
        		              .body(initPaymentReqBody)
        		              .contentType(ContentType.JSON)
        		              .post("apu/v3/initiate-payment");
         resBody.then().log().all();
         String redirectUrl = resBody.jsonPath().get("next[0].url");
         String transactionId = resBody.jsonPath().get("transaction_id");
         System.out.println(transactionId);
         System.out.println(redirectUrl);
           
         //webhook Payment conformation;
         
//         WebDriverManager.chromedriver().setup();
         WebDriver driver = new ChromeDriver();
         driver.manage().window().maximize();
         driver.get(redirectUrl);
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20l));
         driver.findElement(By.id("username")).sendKeys("payu");
         driver.findElement(By.id("password")).sendKeys("payu");
         driver.findElement(By.xpath("//input[@type='submit']")).click();//click on submit button
         driver.findElement(By.xpath("//input[@type='submit']")).click();//click on success response
         
        //transaction enquiry post Request
         LinkedHashMap<String, String> transacEnquiryHead = new LinkedHashMap<String, String>();
         transacEnquiryHead.put("Authorization", "Bearer "+BearerToken);
         transacEnquiryHead.put("x-nimbbl-user-token", userToken);
         //get the request body form nimbbl website and add transction id
         String transEnquiryReqbody = "{}";
         Response transEnqResponBody = given()
        		                        .headers(transacEnquiryHead)
        		                        .body(transEnquiryReqbody)
        		                        .contentType(ContentType.JSON)
        		                        .log().all()
        		                        .when()
        		                        .post("api/v3/transaction-enquiry");
                   transEnqResponBody.then().log().all();
         String orderStatus = transEnqResponBody.jsonPath().get("order.status");
         System.out.println(orderStatus);
    }
}
