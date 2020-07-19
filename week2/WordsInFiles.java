import java.util.*;
import edu.duke.*;
import java.io.*;

public class WordsInFiles {
    
    private HashMap <String, ArrayList<String>> map;
    
    public WordsInFiles() {
        map = new HashMap<String, ArrayList<String>>();
    }
    
    private void addWordsFromFile(File f) {
        FileResource fr = new FileResource(f);
        for(String words : fr.words()) {
            if(!map.containsKey(words)) {
                map.put(words, new ArrayList<String>());
                map.get(words).add(f.getName());
            }
            else {
                if(!map.get(words).contains(f.getName())) {
                    map.get(words).add(f.getName());
                }
            }
        }
        System.out.println(map);
    }
    
    void testAddWordsFromFile() {
        DirectoryResource dr = new DirectoryResource();
        for(File f : dr.selectedFiles()) {
        addWordsFromFile(f);
    }
        System.out.println(maxNumber());
    }
    
    private void buildWordFileMap() {
        map.clear();
        DirectoryResource dr = new DirectoryResource();
        for(File f : dr.selectedFiles()) {
        addWordsFromFile(f);
    }
    }
    
    public Integer maxNumber() {
        int occurencies = 0;
        for(String i : map.keySet()) {
            if(map.get(i).size() > occurencies) {
                occurencies = map.get(i).size();
            }
        }
        return occurencies;
    }
    
    public ArrayList<String> wordsInNumFiles(int number) {
        ArrayList<String> list = new ArrayList<String>();
        for(String i : map.keySet()) {
            if(map.get(i).size() == number) {
                list.add(i);
            }
        }
        return list;
    }
    
    public void testWordsInNumFiles() {
        testAddWordsFromFile();
        System.out.println(wordsInNumFiles(3));
    }
    
    public void printFilesIn(String word) {
        int index = 0;
        for(String i : map.get(word)) {
            System.out.println(map.get(word).get(index));
            index++;
        }
    }
    
    public void testPrintFilesIn() {
        testAddWordsFromFile();
        printFilesIn("cats");
    }
    
    public void tester() {
        
    }
}