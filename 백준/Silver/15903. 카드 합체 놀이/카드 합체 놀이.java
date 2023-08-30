import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        PriorityQueue<Long> pq = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        while (N-->0) pq.offer(Long.parseLong(st.nextToken()));
        while (M-->0) {
            long temp = pq.poll()+pq.poll();
            pq.offer(temp);
            pq.offer(temp);
        }
        long sum = 0;
        while (!pq.isEmpty()) sum += pq.poll();
        System.out.print(sum);
    }
}