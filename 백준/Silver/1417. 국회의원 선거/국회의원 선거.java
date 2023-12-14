import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int num = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        while (N-->1) pq.offer(Integer.parseInt(br.readLine()));
        int cnt = 0;
        while (!pq.isEmpty() && pq.peek() >= num) {
            pq.offer(pq.poll()-1);
            ++num;
            ++cnt;
        }
        System.out.print(cnt);
    }
}