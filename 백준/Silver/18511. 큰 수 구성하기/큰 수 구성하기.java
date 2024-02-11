import java.io.*;
import java.util.*;
public class Main {
    static int N, K, ans = 0;
    static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[K];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; ++i) arr[i] = Integer.parseInt(st.nextToken());
        dfs(0);
        System.out.print(ans);
    }
    static void dfs(int num) {
        if (num > N) return;
        ans = Math.max(ans, num);
        for (int i = 0; i < K; ++i) dfs(num*10+arr[i]);
    }
}