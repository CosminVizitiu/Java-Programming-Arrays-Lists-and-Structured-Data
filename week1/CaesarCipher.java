import java.lang.*;
import edu.duke.*;
public class CaesarCipher {
    public String encrypt(String input, int key) {
    //Make a StringBuilder with message (encrypted) 
    StringBuilder encrypted = new StringBuilder(input);
    //Write down the alphabet
    String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    //Compute the shifted alphabet
    String shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0, key);
    //Count from 0 tp < length of encrypted, (call ot i)
    for(int i=0; i<encrypted.length(); i++) {
        //Look at the ith character of encrypted (call it currChar
        char currChar = encrypted.charAt(i);
        //Find the index of currChar in the alphabet(call it idx)
        int idx = alphabet.indexOf(currChar);
        if(idx == -1) {
            if(testLowerCase(currChar) == true) { 
                // test if index cannot be found because is lower case, if true -> encrypt with lower case
                idx = alphabet.indexOf(Character.toUpperCase(currChar));
                char newChar = shiftedAlphabet.charAt(idx);
                newChar = Character.toLowerCase(newChar);
                encrypted.setCharAt(i, newChar);  
                idx = -1;
            }
        }
        //If currChar is in the alphabet
        if(idx != -1){
         //Get the idxth character of shiftedAlphabet 
         char newChar = shiftedAlphabet.charAt(idx);
         //Replace the ith character of encrypted with newChar
         encrypted.setCharAt(i, newChar);
        }
        
        //Otherwise: do nothing
    }
    //Your answer is the String inside of encrypted
    return encrypted.toString();
}

public boolean testLowerCase(char ch) { //test if character is LowerCase of alphabet
    String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    if(alphabet.indexOf(Character.toUpperCase(ch)) != -1)
    return true;
    else
    return false;
}

public void testTestLowerCase() {
    char c = 'a';
    System.out.println(testLowerCase(c));
    c = 'b';
    System.out.println(testLowerCase(c));
    c='Z';
    System.out.println(testLowerCase(c));
    c='?';
    System.out.println(testLowerCase(c));
}

public void testCaesar() {
    int key = 23;
    FileResource fr = new FileResource();
    String message = fr.asString();
    String encrypted = encrypt(message, key);
    System.out.println(encrypted);
    
    //String decrypted = encrypt(encrypted, 26-key);
    //System.out.println(decrypted);
}

public String encryptTwoKeys(String input, int key1, int key2) {
    String result1 = encrypt(input, key1);
    String result2 = encrypt(input, key2);
    StringBuilder sb = new StringBuilder(result1);
    StringBuilder sb2 = new StringBuilder(result2);
    for(int i=0; i<input.length(); i++)
    if(i%2!=0)
    sb.setCharAt(i,sb2.charAt(i));
    return sb.toString();
}

public void testEncryptTwoKeys() {
    int key1 = 8;
    int key2 = 21;
    FileResource fr = new FileResource();
    String message = fr.asString();
    System.out.println(encryptTwoKeys(message,key1,key2));
}
}