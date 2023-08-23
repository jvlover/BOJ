import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        while (N-->0) pq.add(Integer.parseInt(br.readLine()));
        int sum = 0;
        while (pq.size()>1) {
            int temp = pq.poll()+pq.poll();
            sum += temp;
            pq.offer(temp);
        }
        System.out.print(sum);
    }
}