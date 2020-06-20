public class CaesarCipher_misterpandaa_OOP {
    private String alphabet;
    private String shiftedAlphabet;
    private int key;
    
    public CaesarCipher_misterpandaa_OOP(int key) {
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0, key);
        this.key = key;
    }
    
    public String encrypt(String input) {
        StringBuilder encryptedMessage = new StringBuilder();
        
        for (int i = 0; i < input.length(); i++) {
            char currentCharacter = input.charAt(i);
            int index = alphabet.toLowerCase().indexOf(Character.toLowerCase(currentCharacter));
            
            if (index != -1) {
                if (Character.isLowerCase(currentCharacter)) {
                    encryptedMessage.append(Character.toLowerCase(shiftedAlphabet.charAt(index)));                
                } else {
                    encryptedMessage.append(shiftedAlphabet.charAt(index));
                }
            } else {
                encryptedMessage.append(currentCharacter);
            }
        }
        
        return encryptedMessage.toString();
    }
    
    public String decrypt(String input) {
        CaesarCipher_misterpandaa_OOP cc = new CaesarCipher_misterpandaa_OOP(26 - key);
        return cc.encrypt(input);
    }
}