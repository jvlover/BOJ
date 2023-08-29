import java.io.*;
import java.util.*;
public class Main {
    static int N, ans;
    static int[] areas;
    static Stack<Integer> area1;
    static ArrayList<Integer>[] graph;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        areas = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; ++i) areas[i] = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N+1];
        for (int i = 1; i <= N; ++i) graph[i] = new ArrayList<>();
        for (int i = 1; i <= N; ++i) {
            st = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(st.nextToken());
            while (T-->0) graph[i].add(Integer.parseInt(st.nextToken()));
        }
        ans = Integer.MAX_VALUE;
        area1 = new Stack<>();
        for (int i = 1; i <= N/2; ++i) combination(1, 0, i);
        System.out.print(ans==Integer.MAX_VALUE?-1:ans);
    }
    static void combination(int idx, int cnt, int pick) {
        if (cnt == pick) {
            gerrymandering();
            return;
        }
        for (int i = idx; i <= N; ++i) {
            area1.push(i);
            combination(i+1, cnt+1, pick);
            area1.pop();
        }
    }
    static void gerrymandering() {
        if (!check(area1)) return;
        Stack<Integer> area2 = new Stack<>();
        for (int i = 1; i <= N; ++i)
            if (!area1.contains(i)) area2.push(i);
        if (!check(area2)) return;
        int sumA = 0, sumB = 0;
        for (int num : area1) sumA += areas[num];
        for (int num : area2) sumB += areas[num];
        ans = Math.min(ans, Math.abs(sumA-sumB));
    }
    static boolean check(Stack<Integer> stack) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visit = new boolean[N+1];
        visit[stack.peek()] = true;
        q.offer(stack.peek());
        int cnt = 1;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int next : graph[cur]) {
                if (visit[next] || !stack.contains(next)) continue;
                ++cnt;
                visit[next] = true;
                q.offer(next);
            }
        }
        return cnt == stack.size();
    }
}