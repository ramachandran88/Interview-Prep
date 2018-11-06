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
        MyPriority priority = new MyPriority();
        PriorityQueue<MyTime> timeQ = new PriorityQueue<MyTime>(machines.length, priority);
        for(int i=0;i<machines.length;i++){
            timeQ.add(new MyTime(machines[i], i));
        }
        
        long days = 0;
        while(goal>0){           
          goal = goal - 1;
          MyTime temp =  timeQ.poll();  
          days = temp.time;  
          timeQ.add(new MyTime(temp.time+machines[temp.index], temp.index));  
        }
        return days;
    }
    
    public static class MyTime{
        public long time;
        public int index;
        
        public MyTime(long time, int index){
            this.time = time;
            this.index = index;
        }
    }
    
    public static class MyPriority
    implements Comparator<Object>
{

    public int compare(Object o1, Object o2)
    {

        MyTime a1 = (MyTime)o1;
        MyTime a2 = (MyTime)o2;

        return Long.compare(a1.time, a2.time);
    }
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
