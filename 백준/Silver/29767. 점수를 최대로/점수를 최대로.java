import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
        long[] arr = new long[N];
        PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
        st = new StringTokenizer(br.readLine());
        pq.offer(arr[0] = Long.parseLong(st.nextToken()));
        for (int i = 1; i < N; ++i)
            pq.offer(arr[i] = Long.parseLong(st.nextToken()) + arr[i-1]);
        long ans = 0;
        while (K-->0) ans += pq.poll();
        System.out.print(ans);
    }
}