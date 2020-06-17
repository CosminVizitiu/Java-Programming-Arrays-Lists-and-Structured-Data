import java.lang.*;
import edu.duke.*;

public class WordPlay {

    public boolean isVowel(char ch) {
        
        StringBuilder sbLowerCase = new StringBuilder("aeiou");
        StringBuilder sbUpperCase = new StringBuilder("AEIOU");
        
        int verifier = 0;
        int index = 0;
        
        while(index < sbLowerCase.length()) {
            if(ch == sbLowerCase.charAt(index))
            verifier = 1;
            index++;
        }
        
        index = 0;
        
                while(index < sbLowerCase.length()) {
            if(ch == sbUpperCase.charAt(index))
            verifier = 1;
            index++;
        }
        
        if(verifier == 0)
        return false;
        else
        return true;
    }
    
    public void testIsVowel() {
        char ch = 'e';
        System.out.println(isVowel(ch));
        
    }
    
    public String replaceVowels(String phrase, char ch) {
        StringBuilder sb = new StringBuilder(phrase); // creeaza un sb cu stringul phrase iar programul inlocuieste in sb caracterele
        for(int i=0; i<sb.length(); i++)
        if(isVowel(sb.charAt(i)))
        sb.setCharAt(i, ch);
        return sb.toString();
    }
    
    public void testReplaceVowels() {
        String phrase = "Hello world!";
        char ch = '*';
        System.out.println(replaceVowels(phrase,ch));
    }
    
    public String emphasize(String phrase, char ch) {
        StringBuilder sb = new StringBuilder(phrase);
        for(int i=0; i<sb.length(); i++)
        if(i%2==0 && (sb.charAt(i) == Character.toLowerCase(ch) || sb.charAt(i) == Character.toUpperCase(ch)))  // programul verifica daca indexul este par sau impar si daca este mic sau mare
        sb.setCharAt(i, '*');
        else
        if(i%2!=0 && (sb.charAt(i) == Character.toLowerCase(ch) || sb.charAt(i) == Character.toUpperCase(ch)))
        sb.setCharAt(i, '+');
        return sb.toString();
    }
    
    public void testEmphasize() {
        String phrase = "dna ctgaaactga";
        char ch = 'a';
        System.out.println(emphasize(phrase,ch));
    }
}
