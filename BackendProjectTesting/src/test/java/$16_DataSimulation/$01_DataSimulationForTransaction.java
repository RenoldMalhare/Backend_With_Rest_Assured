package $16_DataSimulation;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;

import ExcelUtility.ReadDataFromExcel;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class $01_DataSimulationForTransaction {
	public static String path;
    public static void main(String[] args) throws EncryptedDocumentException, IOException {
    	//to get the path in runtime use System.out.println(args[0]); and put value in the run cofiguration
//   	 System.out.println(args[0]);
//    	path ="C:\\Users\\renol\\OneDrive\\Desktop\\TekPyramid\\bank.xlsx";
    	path= args[0];
        ExcelUtility exlLib = new ExcelUtility();
    	int rowCount = exlLib.getRowCount("trxn");
//    	System.out.println(rowCount);
    	String TRANSACTION_ID_VAR ;
    	String TRANSACTION_DATE_VAR;
    	String TRANSACTION_AMOUNT_VAR;
    	String PAYER_PSP_VAR;
    	String PAYEE_PSP_VAR;
    	for(int i=1; i<=rowCount; i++) {
    		TRANSACTION_ID_VAR= "HDFC00060"+ new Random().nextInt(100000);
    		TRANSACTION_DATE_VAR=new SimpleDateFormat("dd-MM-yy").format(new Date());
    		TRANSACTION_AMOUNT_VAR=exlLib.getDataFromExcel("trxn", i, 02);
    		PAYER_PSP_VAR=exlLib.getDataFromExcel("trxn", i, 03);
    		PAYEE_PSP_VAR=exlLib.getDataFromExcel("trxn", i, 04);
    		
    		exlLib.setDataInExcel("trxn", i, 0, TRANSACTION_ID_VAR);
    		exlLib.setDataInExcel("trxn", i, 1, TRANSACTION_DATE_VAR);
    		
//        	System.out.println(TRANSACTION_ID_VAR);
//        	System.out.println(TRANSACTION_DATE_VAR);
//        	System.out.println(TRANSACTION_AMOUNT_VAR);
//        	System.out.println(PAYER_PSP_VAR);
//        	System.out.println(PAYEE_PSP_VAR);
    	
    	    String reqBody = "{\"Transaction_ID\":\""+TRANSACTION_ID_VAR+"\",\"Transaction_Mode\":\"ONLINE\","
    	    	+ "\"Transaction_Date\":\""+TRANSACTION_DATE_VAR+"\",\"Transaction_Time\":\"11:01:28:930 \","
    	    	+ "\"Transaction_Amount\":\""+TRANSACTION_AMOUNT_VAR+"\",\"Transaction_Type\":\"Transfer\",\"Description\":\"Payer to Payee transaction via online mode\",\"Currency\":\"INR\",\"Location\":\"Mumbai Maharastra\",\"Authorization_Code\":\"C123\",\"Merchant_Information\":\"Merchant Dharavi Mumbai\",\"Batch_Number\":\"06545678\",\"Recurring_Indicator\":\"yes\",\"Tax_Information\":\"GS34567S\",\"Risk_Assessment_Score\":\"199\",\"Promotion_Coupon_Code\":\"CH123\",\"Exchange_Rate\":\"67\",\"Transaction_Code\":\"TR12\",\"Notes\":\"This is a merchant transaction.\",\"Reference_Number\":\"REF991\",\"Device_Information\":\"xiomi Note11\",\"MCC\":\"M123\",\"CVM\":\"OTP\",\"Regulatory_Compliance_Information\":\"KYC\",\"Payer_Details\":{"
    	    	+ "\"Payer_PSP\":\""+PAYER_PSP_VAR+"\",\"Payer_Name\":\"Payer\",\"Bank_Account\":\"HDFC\",\"Account_Type\":\"Savings\",\"IFSC\":\"HDF01\",\"Mobile_Number\":\"9887776676\",\"Address\":\"payer_address@123\",\"Ip_Address\":\"1235@fghj\",\"Mail_Id\":\"mohoan@gmail.com\",\"Balance\":\"690000.90\"},\"Payee_Details\":{"
    	    	+ "\"Payee_PSP\":\""+PAYEE_PSP_VAR+"\",\"Payee_Name\":\"Payee\",\"Bank_Account\":\"ICICI\",\"Account_Type\":\"Savings\",\"IFSC\":\"ICIC01\",\"Mobile_Number\":\"9886662222\",\"Address\":\"payee_address@123\",\"Mail_Id\":\"deepak.h@gmail.com\"},\"Transaction_Status\":\"Completed\",\"isUPITransaction\":true,\"Sender_Source\":\"Remitter\",\"Recipient_Destination\":\"Benificiary\"}";
    	    
    	    
    	    given()
    	      .contentType(ContentType.JSON)
    	      .body(reqBody)
    	    .when()
    	      .post("http://49.249.29.5:8091/add-transaction")
    	    .then()
    	      .log().all();
    	}
	}
}
