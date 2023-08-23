import java.io.*;
import java.util.*;
public class Main {
    static int cnt = 0;
    static boolean[] visit;
    static List<Integer>[] graph;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine()), M = Integer.parseInt(br.readLine());
        graph = new ArrayList[N+1];
        for (int i = 1; i <= N; ++i) graph[i] = new ArrayList<>();
        while (M-->0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }
        visit = new boolean[N+1];
        dfs(1);
        System.out.print(cnt);
    }
    static void dfs(int idx) {
        visit[idx] = true;
        for (int next : graph[idx]) {
            if (visit[next]) continue;
            dfs(next);
            ++cnt;
        }
    }
}