
/**
 * Write a description of class LogAnalyzer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;
import edu.duke.*;

public class LogAnalyzer
{
     private ArrayList<LogEntry> records;
     
     public LogAnalyzer() {
         records = new ArrayList<LogEntry>();
     }
        
     public void readFile(String filename) {
         FileResource fr = new FileResource(filename);
         for(String line : fr.lines()) {
             LogEntry le = WebLogParser.parseEntry(line);
             records.add(le);
            }
    }
    
    public void printAll() {
         for (LogEntry le : records) {
             System.out.println(le);
         }
     }
     
    public HashMap<String, Integer> countVisitsPerIP () {
        HashMap<String, Integer> ipCounts = new HashMap<String, Integer>();
        for (LogEntry le : records) {
            if(! ipCounts.containsKey(le.getIpAddress())) {
            ipCounts.put(le.getIpAddress(), 1);    
            }
            else {
                ipCounts.put(le.getIpAddress(), ipCounts.get(le.getIpAddress())+1);
            }
        }
        return ipCounts;
    }
    
    public int mostNumberVisitsByIP(HashMap<String, Integer> ipCounts) {
        int maxNumb = Integer.MIN_VALUE;
        for(String key : ipCounts.keySet()) {
            if(ipCounts.get(key) > maxNumb) {
                maxNumb = ipCounts.get(key);
            }
        }
        return maxNumb;
    }
    
    public ArrayList<String> iPsMostVisits(HashMap<String, Integer> ipCounts) {
        int maxNumb = mostNumberVisitsByIP(ipCounts);
        ArrayList<String> MostVisits = new ArrayList<String>();
        for(String key : ipCounts.keySet()) {
            if(ipCounts.get(key) == maxNumb) {
                MostVisits.add(key);
            }
        }
        return MostVisits;
    }
    
    public HashMap<String, ArrayList<String>> iPsForDays() {
        HashMap<String, ArrayList<String>> ipsPerDay = new HashMap<String, ArrayList<String>>();
        for(LogEntry le : records) {
            String accessTime = le.getAccessTime().toString();
            String day = accessTime.substring(4,10);
            String currIp = le.getIpAddress();
            ArrayList<String> ipList;
            if(!ipsPerDay.containsKey(day)) {
                ipList = new ArrayList<String>();
            }
            else {
                ipList = ipsPerDay.get(day);
            }
            ipList.add(currIp);
            ipsPerDay.put(day, ipList);
        }
        return ipsPerDay;
    }
    
    public String dayWithMostiIPVisits(HashMap<String, ArrayList<String>> ipsForDays) {
        int maxNumVisits = Integer.MIN_VALUE;
        String day = "";
        ArrayList<String> maxList = new ArrayList<String>();
        for(ArrayList<String> list : ipsForDays.values()) {
            if(list.size() >= maxNumVisits) {
                maxNumVisits = list.size();
                maxList = list;
            }
        }
        
        for(String key : ipsForDays.keySet()) {
            if(ipsForDays.get(key) == maxList) {
                day = key;
            }
        }
    
        return day;
    }
    
    public ArrayList<String> iPsWithMostVisitsOnDay(HashMap<String, ArrayList<String>> inputHM, String inputday) {
        ArrayList<String> result = new ArrayList<String>();
        HashMap<String, Integer> processingResult = new HashMap<String, Integer>();
        
        for(String IPs : inputHM.get(inputday)) {
            if(!processingResult.containsKey(IPs)) {
                processingResult.put(IPs, 1);
            }
            else {
                processingResult.put(IPs, processingResult.get(IPs)+1);
            }
        }
        int maxNumbVisits = mostNumberVisitsByIP(processingResult);
        for(String key : processingResult.keySet()) {
            if(maxNumbVisits == processingResult.get(key)) {
                result.add(key);
            }
        }
        return result;
    }
    
}
