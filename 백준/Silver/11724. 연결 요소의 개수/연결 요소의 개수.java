import java.io.*;
import java.util.*;
public class Main {
    static int N, M;
    static boolean[] visit;
    static ArrayList<Integer>[] graph;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N+1];
        for (int i = 1; i <= N; ++i) graph[i] = new ArrayList<>();
        while (M-->0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }
        int cnt = 0;
        visit = new boolean[N+1];
        for (int i = 1; i <= N; ++i) {
            if (visit[i]) continue;
            ++cnt;
            dfs(i);
        }
        System.out.print(cnt);
    }
    static void dfs(int idx) {
        visit[idx] = true;
        for (int next : graph[idx])
            if (!visit[next]) dfs(next);
    }
}