
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.security.MessageDigest;


public class CryptoUtils {

    private static final String ALGORITHM = "AES";

    // derive AES key from master password
    public static SecretKey getKeyFromPassword(String password) throws Exception {
        byte[] key = password.getBytes("UTF-8");
        MessageDigest sha = MessageDigest.getInstance("SHA-256");
        key = sha.digest(key);
        return new SecretKeySpec(key, ALGORITHM);
    }


    public static String encrypt(String data, String password) throws Exception {
        SecretKey key = getKeyFromPassword(password);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encVal = cipher.doFinal(data.getBytes());
        return Base64.getEncoder().encodeToString(encVal);
    }


    public static String decrypt(String encryptedData, String password) throws Exception {
        SecretKey key = getKeyFromPassword(password);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decodedValue = Base64.getDecoder().decode(encryptedData);
        byte[] decValue = cipher.doFinal(decodedValue);
        return new String(decValue);       
    }

}
