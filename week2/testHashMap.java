import java.util.*;
import edu.duke.*;
 public class testHashMap{
     
     private HashMap<String, Integer> codonCounts;
     
     public testHashMap(){
         codonCounts = new HashMap<String, Integer>();
        }
     
        void buildCodonMap(int start, String dna) {
            codonCounts.clear();
            for(int i= start; i<dna.length()-2; i+=3) {
                String codon = dna.substring(i,i+3);
                if(codonCounts.containsKey(codon)) {
                    codonCounts.put(codon, codonCounts.get(codon)+1);
                }
                else {
                    codonCounts.put(codon,1);
                }
            }
        }
        
        String getMostCommonCodon() {
            int min = Integer.MIN_VALUE;
            String index = "NO VALUES";
            for(String i : codonCounts.keySet()) {
                if(codonCounts.get(i) >= min) {
                    min = codonCounts.get(i);
                    index = i;
                }
            }
            return index;
        }
        
        void printCodonCounts(int start, int end) {
            for(String i : codonCounts.keySet()) {
                if(codonCounts.get(i) >= start && codonCounts.get(i) <=  end) {
                    System.out.println("Codon: " + i + " / Counts: " + codonCounts.get(i));
                }
            }
        }
        
        void testBuildCodonMap() {
            String dna = "CGTTCAAGTTCAA";
            dna = dna.trim();
            int start = 1;
            buildCodonMap(start,dna);
            System.out.println(codonCounts);
        }
        
        void testGetMostCommonCodon() {
            String dna = "CGTTCAAGTTCAA";
            int start = 0;
            buildCodonMap(start,dna);
            System.out.println(getMostCommonCodon());
            printCodonCounts(1,5);
        }
    }