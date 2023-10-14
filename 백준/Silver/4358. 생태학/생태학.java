import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        HashMap<String, Integer> hm = new HashMap<>();
        int cnt = 0;
        String str;
        while ((str = br.readLine()) != null) {
            ++cnt;
            hm.put(str, hm.getOrDefault(str, 0)+1);
        }
        PriorityQueue<String> pq = new PriorityQueue<>();
        for (String word : hm.keySet()) pq.offer(word);
        while (!pq.isEmpty()) {
            String word = pq.poll();
            sb.append(word).append(' ').append(String.format("%.4f", (double)(hm.get(word))/cnt*100)).append('\n');
        }
        System.out.print(sb);
    }
}