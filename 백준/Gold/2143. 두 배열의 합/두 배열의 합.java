import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N+1];
        for (int i = 1; i <= N; ++i) arr[i] = arr[i-1] + Integer.parseInt(st.nextToken());
        Map<Integer, Integer> hm = new HashMap<>();
        for (int i = 1; i <= N; ++i) {
            for (int j = i; j <= N; ++j) {
                int sum = arr[j]-arr[i-1];
                hm.put(sum, hm.getOrDefault(sum, 0)+1);
            }
        }
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        arr = new int[M+1];
        for (int i = 1; i <= M; ++i) arr[i] = arr[i-1] + Integer.parseInt(st.nextToken());
        long cnt = 0;
        for (int i = 1; i <= M; ++i) {
            for (int j = i; j <= M; ++j) {
                int sum = arr[j]-arr[i-1];
                cnt += hm.getOrDefault(T-sum, 0);
            }
        }
        System.out.print(cnt);
    }
}