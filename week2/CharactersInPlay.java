import java.util.*;
import edu.duke.*;

public class CharactersInPlay {

    private ArrayList<String> myNames;
    private ArrayList<Integer> myFreqs;
    
    public CharactersInPlay() {
        myNames = new ArrayList<String>();
        myFreqs = new ArrayList<Integer>();
    }
    
    public void update(String person) {
        int index = myNames.indexOf(person);
        if(index == -1) {
            myNames.add(person);
            myFreqs.add(1);
        }
        else {
            int value = myFreqs.get(index);
            myFreqs.set(index, value+1);
            //System.out.println("TEST: " + myNames.get(index) + " " + myFreqs.get(index));
        }
    }
    
    public void findAllCharacters() {
        myNames.clear();
        myFreqs.clear();
        FileResource resource = new FileResource();
        
        for(String s:resource.lines()) {
            int index = s.indexOf(".");
            if( index != -1) { 

                String str = s.substring(0, index+1);
                update(str);
            }
        }
    }
    
    public void tester() {
        findAllCharacters();
        for(int i=0; i<myNames.size(); i++) {
            if(myFreqs.get(i) > 1) {
                System.out.println("Character: " + myNames.get(i) + " - Freq: " + myFreqs.get(i));
            }
        }
    }
    
    public void charactersWithNumParts(int num1, int num2) {
        findAllCharacters();
        for(int i=0; i<myNames.size(); i++) {
            if(myFreqs.get(i) >= num1 && myFreqs.get(i) <= num2) {
                System.out.println("Character: " + myNames.get(i) + " - Freq: " + myFreqs.get(i));
            }
        }
    }
}
