import java.io.*;
import java.util.*;
public class Main {
    static int N, cnt;
    static boolean[] visit;
    static List<Integer>[] graph;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        boolean[] isChild = new boolean[N];
        graph = new ArrayList[N];
        for (int i = 0; i < N; ++i) graph[i] = new ArrayList<>();
        while (M-->0) {
            st = new StringTokenizer(br.readLine());
            int p = st.nextToken().charAt(0)-'A';
            int c = st.nextToken().charAt(0)-'A';
            graph[p].add(c);
            isChild[c] = true;
        }
        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        visit = new boolean[N];
        while (T-->0) {
            int target = st.nextToken().charAt(0)-'A';
            graph[target].clear();
            for (List<Integer> node : graph) node.remove((Integer)target);
        }
        for (int i = 0; i < N; ++i) if (!isChild[i]) dfs(i);
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