import java.io.*;
import java.util.*;
public class Main {
    static int[] computers;
    static boolean[] visit;
    static List<Integer>[] graph;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N+1];
        for (int i = 1; i <= N; ++i) graph[i] = new ArrayList<>();
        while (M-->0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
        }
        computers = new int[N+1];
        for (int i = 1; i <= N; ++i) {
            visit = new boolean[N+1];
            dfs(i);
        }
        int max = -1;
        for (int i = 1; i <= N; ++i) max = Math.max(max, computers[i]);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; ++i)
            if (computers[i] == max) sb.append(i).append(' ');
        System.out.print(sb);
    }
    static void dfs(int idx) {
        visit[idx] = true;
        for (int next : graph[idx]) {
            if (visit[next]) continue;
            ++computers[next];
            dfs(next);
        }
    }
}