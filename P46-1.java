import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the poisonousPlants function below.
    static int poisonousPlants(int[] p) {
        int days = 0;
        ArrayList<Integer> list = new ArrayList();
        ArrayList<Integer> tempList = new ArrayList();        

        for (int i : p) {
            list.add(Integer.valueOf(i));
        }
        
        boolean flag = true;
        
        while(flag){
            tempList.clear();
            
            for(int i=0;i<list.size();i++){                
                if(i==0 || list.get(i-1)>=list.get(i)){
                    tempList.add(list.get(i));
                } 
            }
            if(list.size()==tempList.size()){
                flag = false;
            }
            else{
                days++;
            }
            
            list = new ArrayList<Integer>(tempList);
            
        }
        
        return days;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] p = new int[n];

        String[] pItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int pItem = Integer.parseInt(pItems[i]);
            p[i] = pItem;
        }

        int result = poisonousPlants(p);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
