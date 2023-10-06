import java.io.*;
import java.util.*;
public class Main {
    static class Jewel implements Comparable<Jewel> {
        int weight, price;
        Jewel(int weight, int price) {
            this.weight = weight;
            this.price = price;
        }
        @Override
        public int compareTo(Jewel o) {
            if (this.weight == o.weight) return Integer.compare(o.price, this.price);
            return Integer.compare(this.weight, o.weight);
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Jewel[] jewels = new Jewel[N];
        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine());
            jewels[i] = new Jewel(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(jewels);
        int[] bags = new int[K];
        for (int i = 0; i < K; ++i) bags[i] = Integer.parseInt(br.readLine());
        Arrays.sort(bags);
        int idx = 0;
        long ans = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < K; ++i) {
            while (idx < N && jewels[idx].weight <= bags[i]) pq.offer(jewels[idx++].price);
            if (!pq.isEmpty()) ans += pq.poll();
        }
        System.out.print(ans);
    }
}