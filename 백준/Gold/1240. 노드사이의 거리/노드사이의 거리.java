import java.io.*;
import java.util.*;
public class Main {
    static class Node {
        int idx, cost;
        Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }
    static StringBuilder sb;
    static ArrayList<Node>[] graph;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N+1];
        for (int i = 1; i <= N; ++i) graph[i] = new ArrayList<>();
        for (int i = 0; i < N-1; ++i) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[a].add(new Node(b, cost));
            graph[b].add(new Node(a, cost));
        }
        while (M-->0) {
            st = new StringTokenizer(br.readLine());
            dfs(Integer.parseInt(st.nextToken()), -1, Integer.parseInt(st.nextToken()), 0);
        }
        System.out.print(sb);
    }
    static void dfs(int now, int prev, int target, int cost) {
        if (now == target) {
            sb.append(cost).append('\n');
            return;
        }
        for (Node next : graph[now]) {
            if (prev == next.idx) continue;
            dfs(next.idx, now, target, cost+next.cost);
        }
    }
}