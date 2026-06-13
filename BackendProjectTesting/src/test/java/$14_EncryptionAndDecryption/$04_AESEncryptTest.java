package $14_EncryptionAndDecryption;

import org.testng.annotations.Test;

public class $04_AESEncryptTest {
    
    @Test
    public void aesTest() throws Exception {
    	String privateKey = "RedXhsd!@#$3k3k3";
    	String Data = "Ren";
    	
    	$03_EncryptAndDecryptUtility encr = new $03_EncryptAndDecryptUtility();
    	System.out.println(encr.encrypt(Data, privateKey));
    	
    	 
    	System.out.println(encr.decrypt("/8vsmQF8mJDlIr+XjjsbmQ==", privateKey));
    	
    }
}
