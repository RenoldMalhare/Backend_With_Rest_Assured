package $14_EncryptionAndDecryption;

import java.util.Base64;

import org.testng.annotations.Test;

public class $01_EncodeAndDecodeTest {
   @Test
   public void test() {
	   
	   String encodeData = new String(Base64.getEncoder().encode("Ren".getBytes()));
	   System.out.println(encodeData);
	   
	   String decodeData = new String(Base64.getDecoder().decode(encodeData.getBytes()));
	   System.out.println(decodeData);
   }
}
