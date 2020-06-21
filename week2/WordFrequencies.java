import java.util.*;
import edu.duke.*;

public class WordFrequencies {
    
    private ArrayList<String> myWords;
    private ArrayList<Integer> myFreqs;
    
    public WordFrequencies() {
        myWords = new ArrayList<String>();
        myFreqs = new ArrayList<Integer>();
    }
    
    public void findUnique() {
        myWords.clear();
        myFreqs.clear();
        FileResource resource = new FileResource();
        
        for(String s:resource.words()) {
            s = s.toLowerCase();
            int index = myWords.indexOf(s);
            if(index == -1) {
                myWords.add(s);
                myFreqs.add(1);
            }
            else {
                int value = myFreqs.get(index);
                myFreqs.set(index, value+1);
            }
        }
    }
    
    public void tester() {
        
        findUnique();
        System.out.println("#Unique words = " + myWords.size());
        int count = 0;
            
        for(int i=0; i<myWords.size(); i++) {
            System.out.println("Word: " + myWords.get(i) + " // Freqs: " + myFreqs.get(i));
            if(myFreqs.get(i) > count) {
                count = myFreqs.get(i);
            }
        }
        
        System.out.println("The word that occurs most often and its count are: " + myWords.get(myFreqs.indexOf(count)) + " - " + count + " times.");
    }
    
}
