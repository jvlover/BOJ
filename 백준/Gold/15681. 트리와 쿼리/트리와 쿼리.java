import java.io.*;
import java.util.*;
public class Main {
    static int[] cnt;
    static ArrayList<Integer>[] graph;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), R = Integer.parseInt(st.nextToken()), Q = Integer.parseInt(st.nextToken());
        cnt = new int[N+1];
        graph = new ArrayList[N+1];
        for (int i = 1; i <= N; ++i) graph[i] = new ArrayList<>();
        for (int i = 1; i < N; ++i) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }
        dfs(R, -1);
        while (Q-->0) sb.append(cnt[Integer.parseInt(br.readLine())]).append('\n');
        System.out.print(sb);
    }
    static void dfs(int now, int parent) {
        cnt[now] = 1;
        for (int next : graph[now]) {
            if (next == parent) continue;
            dfs(next, now);
        }
        if (parent != -1) cnt[parent] += cnt[now];
    }
}