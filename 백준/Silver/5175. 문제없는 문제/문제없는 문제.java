import java.io.*;
import java.util.*;
public class Main {
    static int N, M;
    static boolean isAns;
    static boolean[] visit;
    static TreeSet<String> ts;
    static ArrayList<Integer>[] graph;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; ++t) {
            sb.append("Data Set ").append(t).append(": ");
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            visit = new boolean[M];
            graph = new ArrayList[M];
            for (int i = 0; i < M; ++i) graph[i] = new ArrayList<>();
            for (int i = 0; i < M; ++i) {
                st = new StringTokenizer(br.readLine());
                while (st.hasMoreTokens()) graph[i].add(Integer.parseInt(st.nextToken()));
            }
            ts = new TreeSet<>();
            for (int i = 1; i <= M; ++i) {
                isAns = false;
                combination(0, 0, i);
                if (isAns) break;
            }
            sb.append(ts.first());
            sb.append('\n').append('\n');
        }
        System.out.print(sb);
    }
    static void combination(int idx, int cnt, int pick) {
        if (cnt == pick) {
            List<Character> chars = new ArrayList<>();
            boolean[] isSelected = new boolean[N+1];
            for (int i = 0; i < M; ++i) {
                if (!visit[i]) continue;
                chars.add((char)(i+'A'));
                for (int num : graph[i]) isSelected[num] = true;
            }
            boolean flag = true;
            for (int i = 1; i <= N; ++i) {
                if (!isSelected[i]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                isAns = true;
                StringBuilder temp = new StringBuilder();
                for (char c : chars) temp.append(c).append(' ');
                ts.add(temp.toString());
            }
            return;
        }
        if (idx == M) return;
        visit[idx] = true;
        combination(idx+1, cnt+1, pick);
        visit[idx] = false;
        combination(idx+1, cnt, pick);
    }
}