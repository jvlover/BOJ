import java.io.*;
import java.util.*;
public class Main {
    static int[][] map;
    static boolean[] visit;
    static int N, team, ans;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visit = new boolean[N];
        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; ++j) map[i][j] = Integer.parseInt(st.nextToken());
        }
        team = N/2;
        ans = Integer.MAX_VALUE;
        dfs(0, 0);
        System.out.print(ans);
    }
    static void dfs(int cnt, int idx) {
        if (cnt == team) {
            int a = 0, b = 0;
            for (int i = 0; i < N; ++i)
                for (int j = 0; j < N; ++j)
                    if (visit[i] && visit[j]) a += map[i][j];
                    else if (!visit[i] && !visit[j]) b += map[i][j];
            ans = Math.min(ans, Math.abs(a-b));
            return;
        }
        if (idx == N) return;
        visit[idx] = true;
        dfs(cnt+1, idx+1);
        visit[idx] = false;
        dfs(cnt, idx+1);
    }
}