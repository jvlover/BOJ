import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        long now = 0;
        for (int i = 0; i < N; ++i) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (i < M) now += arr[i];
        }
        long max = now;
        for (int i = M; i < N; ++i) {
            now += arr[i]-arr[i-M];
            max = Math.max(max, now);
        }
        System.out.print(max);
    }
}