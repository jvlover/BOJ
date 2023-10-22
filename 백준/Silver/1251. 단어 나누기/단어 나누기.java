import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int len = str.length();
        PriorityQueue<String> pq = new PriorityQueue<>();
        for (int i = 1; i < len; ++i)
            for (int j = i+1; j < len; ++j)
                pq.offer(new StringBuilder(str.substring(0, i)).reverse().toString() + new StringBuilder(str.substring(i, j)).reverse() + new StringBuilder(str.substring(j)).reverse());
        System.out.print(pq.poll());
    }
}