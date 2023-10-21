import java.io.*;
import java.util.*;
public class Main {
    static int cnt;
    static int[] arr;
    static boolean[] visit, team;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        while (T-->0) {
            int N = Integer.parseInt(br.readLine());
            cnt = 0;
            arr = new int[N+1];
            visit = new boolean[N+1];
            team = new boolean[N+1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; ++i)
                arr[i] = Integer.parseInt(st.nextToken());
            for (int i = 1; i <= N; ++i)
                if (!team[i]) dfs(i);
            sb.append(N-cnt).append('\n');
        }
        System.out.print(sb);
    }
    static void dfs(int idx) {
        if (visit[idx]) {
            ++cnt;
            team[idx] = true;
        } else visit[idx] = true;
        if (!team[arr[idx]]) dfs(arr[idx]);
        team[idx] = true;
        visit[idx] = false;
    }
}