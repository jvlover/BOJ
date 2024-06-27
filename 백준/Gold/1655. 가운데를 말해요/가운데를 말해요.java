import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> minPq = new PriorityQueue<>();
        PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());
        while (N-->0) {
            int num = Integer.parseInt(br.readLine());
            if (minPq.size() == maxPq.size()) maxPq.offer(num);
            else minPq.offer(num);
            if (!(minPq.isEmpty() || maxPq.isEmpty()) && minPq.peek() < maxPq.peek()) {
                maxPq.offer(minPq.poll());
                minPq.offer(maxPq.poll());
            }
            sb.append(maxPq.peek()).append('\n');
        }
        System.out.print(sb);
    }
}