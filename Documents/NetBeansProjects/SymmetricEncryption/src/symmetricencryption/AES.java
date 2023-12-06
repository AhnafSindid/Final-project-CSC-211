package symmetricencryption;
import javax.crypto.spec.SecretKeySpec;
import java.security.NoSuchAlgorithmException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.Cipher;

public class AES {
    protected static SecretKeySpec hiddenkey;
    protected static byte[] key;
    
    public static void Key(String setKey){
        try{
          key = setKey.getBytes("UTF-8");
          MessageDigest userkey = MessageDigest.getInstance("SHA-256");
          key = userkey.digest(key);
          key = Arrays.copyOf(key, 16);
          hiddenkey = new SecretKeySpec(key, "AES");
        }
        catch (NoSuchAlgorithmException e){ }
        catch(UnsupportedEncodingException e){ }
    }
    
    public static String encryption(String Encrypt, String secret){
       try{
          Key(secret);
          Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
          cipher.init(Cipher.ENCRYPT_MODE, hiddenkey);
          return Base64.getEncoder().encodeToString(cipher.doFinal(Encrypt.getBytes("UTF-8")));
       } 
       catch (Exception e){
           
       }
       return null;
    }
    public static String decryption(String decrypt, String secret){
       try{
          Key(secret);
          Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
          cipher.init(Cipher.DECRYPT_MODE, hiddenkey);
          return new String(cipher.doFinal(Base64.getDecoder().decode(decrypt)));
       } 
       catch (Exception e){
           
       }
       return null;
    }
}
