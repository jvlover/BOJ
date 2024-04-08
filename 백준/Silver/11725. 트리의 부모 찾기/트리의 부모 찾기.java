import java.io.*;
import java.util.*;
public class Main {
    static int[] parent;
    static boolean[] visit;
    static ArrayList<Integer>[] graph;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        parent = new int[N+1];
        visit = new boolean[N+1];
        graph = new ArrayList[N+1];
        for (int i = 1; i <= N; ++i) graph[i] = new ArrayList<>();
        for (int i = 1; i < N; ++i) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }
        for (int i = 1; i <= N; ++i)
            if (!visit[i]) dfs(i);
        for (int i = 2; i <= N; ++i)
            sb.append(parent[i]).append('\n');
        System.out.print(sb);
    }
    static void dfs(int now) {
        if (visit[now]) return;
        visit[now] = true;
        for (int next : graph[now]) {
            if (visit[next]) continue;
            parent[next] = now;
            dfs(next);
        }
    }
}