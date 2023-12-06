package symmetricencryption;


public class SymmetricEncryption {

    
    public static void main(String[] args) {
        final String hiddenkey = "917319391631693";
       String project = " Cryptography Information";
       
       
       String encrypted = AES.encryption(project , hiddenkey);
       String decrypted = AES.decryption(project, hiddenkey);
       
       System.out.println("project:" + project);
       System.out.println(encrypted);
       System.out.println(hiddenkey);
    }
    
}
