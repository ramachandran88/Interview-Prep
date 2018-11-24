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
        int maxDays = 0;
        Stack<Integer> stack = new Stack();
        Stack<Integer> days = new Stack();        
        int i=p.length-1;
        int tempDays = 0;
        while(i>=0){
            if(!stack.empty() &&  p[i]<p[stack.peek()]) {                
                tempDays = Math.max(tempDays + 1, days.pop());
                stack.pop();
            } else {                
                stack.push(i);
                days.push(tempDays);
                if(tempDays>maxDays){
                    maxDays = tempDays;
                }
                i--;
                tempDays = 0;
            }
        }
        
        return maxDays;
        
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
