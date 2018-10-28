import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the isValid function below.
    static String isValid(String s) {
        Map<Character, Integer> map = new HashMap();
        String output = "NO";
        for(char ch : s.toCharArray()){
            Integer val = map.get(ch);
            if(val==null){
                val = 0;
            }
            val = val + 1;
            map.put(ch,val);
        }        
        Iterator<Integer> iter = map.values().iterator();
        Map<Integer,Integer> countMap = new HashMap();
        while(iter.hasNext()){
            Integer freq = iter.next();
            Integer noOfChars = countMap.get(freq);
            if(noOfChars==null){
                noOfChars = 0;
            }            
            noOfChars++;
            countMap.put(freq, noOfChars);
        }
        if(countMap.size()==1){
            output = "YES";
        }
        else if(countMap.size()>2){
            output = "NO";
        }
        else{
            Iterator<Integer> iter1 = countMap.keySet().iterator();
            int freq1 = iter1.next();
            int freq2 = iter1.next();
            int val1 = countMap.get(freq1);
            int val2 = countMap.get(freq2);
            
            if(freq1==1 && val1==1){
                output = "YES";
            }
            if(val2==1 && (freq2-freq1)==1){
                output = "YES";
            }
        }
        return output;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = isValid(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
