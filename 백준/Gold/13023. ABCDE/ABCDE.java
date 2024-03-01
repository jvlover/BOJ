import java.io.*;
import java.util.*;
public class Main {
    static int ans;
    static boolean[] visit;
    static List<Integer>[] graph;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N];
        for (int i = 0; i < N; ++i) graph[i] = new ArrayList<>();
        while (M-->0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }
        visit = new boolean[N];
        for (int i = 0; i < N; ++i)
            if (ans == 0) dfs(i, 1);
        System.out.print(ans);
    }
    static void dfs(int idx, int depth) {
        if (depth == 5) {
            ans = 1;
            return;
        }
        for (int next : graph[idx]) {
            if (visit[next]) continue;
            visit[idx] = true;
            dfs(next, depth+1);
            visit[idx] = false;
        }
    }
}