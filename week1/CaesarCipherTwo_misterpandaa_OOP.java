public class CaesarCipherTwo_misterpandaa_OOP {
    private String alphabet;
    private String shiftedAlphabet1;
    private String shiftedAlphabet2;
    private int key1;
    private int key2;
    
    public CaesarCipherTwo_misterpandaa_OOP(int key1, int key2) {
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAlphabet1 = alphabet.substring(key1) + alphabet.substring(0, key1);
        shiftedAlphabet2 = alphabet.substring(key2) + alphabet.substring(0, key2);
        this.key1 = key1;
        this.key2 = key2;
    }
    
    public String encrypt(String input) {
        StringBuilder encryptedMessage = new StringBuilder();
        
        for (int i = 0; i < input.length(); i++) {
            char currentCharacter = input.charAt(i);
            int index = alphabet.toLowerCase().indexOf(Character.toLowerCase(currentCharacter));
            
            if (index != -1) {
                String shiftedAlphabet;
                
                if (i % 2 == 0) {
                    shiftedAlphabet = shiftedAlphabet1;
                } else {
                    shiftedAlphabet = shiftedAlphabet2;
                }
                
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
        CaesarCipherTwo_misterpandaa_OOP cc = new CaesarCipherTwo_misterpandaa_OOP(26 - key1, 26 - key2);
        return cc.encrypt(input);
    }
}