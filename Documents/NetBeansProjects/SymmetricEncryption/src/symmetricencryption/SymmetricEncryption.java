package symmetricencryption;


public class SymmetricEncryption {

    
    public static void main(String[] args) {
        final String hiddenkey = "Final Project";
       String project = " Cryptography Information";
       
       
       String encrypted = AES.encryption(project , hiddenkey);
       
       System.out.println("project:" + project);
       System.out.println(encrypted);
    }
    
}
