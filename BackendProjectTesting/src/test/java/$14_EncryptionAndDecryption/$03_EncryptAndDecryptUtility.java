package $14_EncryptionAndDecryption;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class $03_EncryptAndDecryptUtility {

//	    private static final String SECRET_KEY = "1234567890123456"; // 16 characters
//
//	    public static void main(String[] args) throws Exception {
//
//	        String originalText = "Hello Java";
//
//	        // Encrypt
//	        String encryptedText = encrypt(originalText);
//	        System.out.println("Encrypted: " + encryptedText);
//
//	        // Decrypt
//	        String decryptedText = decrypt(encryptedText);
//	        System.out.println("Decrypted: " + decryptedText);
//	    }

	public static String encrypt(String data, String SECRET_KEY) throws Exception {

		SecretKeySpec key = new SecretKeySpec(SECRET_KEY.getBytes(), "AES");
        IvParameterSpec ivParaSpec = new IvParameterSpec("4234567890123456".getBytes());

		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		cipher.init(Cipher.ENCRYPT_MODE, key, ivParaSpec);

		byte[] encryptedBytes = cipher.doFinal(data.getBytes());

		return Base64.getEncoder().encodeToString(encryptedBytes);
	}

	public static String decrypt(String encryptedData, String SECRET_KEY) throws Exception {

		SecretKeySpec key = new SecretKeySpec(SECRET_KEY.getBytes(), "AES");
        IvParameterSpec ivParaSpec = new IvParameterSpec("4234567890123456".getBytes());
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		cipher.init(Cipher.DECRYPT_MODE, key,ivParaSpec);

		byte[] decodedBytes = Base64.getDecoder().decode(encryptedData);

		byte[] decryptedBytes = cipher.doFinal(decodedBytes);

		return new String(decryptedBytes);
	}

}
