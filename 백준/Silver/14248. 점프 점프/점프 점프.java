import java.io.*;
import java.util.*;
public class Main {
    static int N;
    static int[] arr;
    static boolean[] visit;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N+1];
        for (int i = 1; i <= N; ++i) arr[i] = Integer.parseInt(st.nextToken());
        visit = new boolean[N+1];
        dfs(Integer.parseInt(br.readLine()));
        int cnt = 0;
        for (int i = 1; i <= N; ++i)
            if (visit[i]) ++cnt;
        System.out.print(cnt);
    }
    static void dfs(int idx) {
        visit[idx] = true;
        if (idx-arr[idx] > 0 && !visit[idx-arr[idx]]) dfs(idx-arr[idx]);
        if (idx+arr[idx] <= N && !visit[idx+arr[idx]]) dfs(idx+arr[idx]);
    }
}