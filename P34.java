import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the minTime function below.
    static long minTime(long[] machines, long goal) {
        Arrays.sort(machines);
        long low = 1l;
        long high = machines[0] * goal;
        long result = 0;
        while(low<=high){
            long mid = (low + high)/2l;
            long totalItems = findTotalItemsByDay(machines,mid);
            if(goal <= totalItems){
                result = mid;
                high = mid -1l;
            }
            else{
                low = mid+1l;
            }
        }
        
        return result;
        
    }
    
    public static long findTotalItemsByDay(long[]machines, long day){
        long temp = 0l;
        for(int i=0;i<machines.length;i++){
            temp = temp + day/machines[i];
        }
        return temp;
    }
    
  

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nGoal = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nGoal[0]);

        long goal = Long.parseLong(nGoal[1]);

        long[] machines = new long[n];

        String[] machinesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            long machinesItem = Long.parseLong(machinesItems[i]);
            machines[i] = machinesItem;
        }

        long ans = minTime(machines, goal);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
