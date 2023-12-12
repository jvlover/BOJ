import java.io.*;
import java.util.*;
public class Main {
    static int N, start, end;
    static int[] bridges;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        bridges = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; ++i) bridges[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        System.out.print(bfs());
    }
    static int bfs() {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visit = new boolean[N+1];
        visit[start] = true;
        q.offer(start);
        int cnt = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-->0) {
                int now = q.poll();
                if (now == end) return cnt;
                int idx = 1;
                while (now+idx*bridges[now]<=N) {
                    int right = now+idx++*bridges[now];
                    if (visit[right]) continue;
                    visit[right] = true;
                    q.offer(right);
                }
                idx = 1;
                while (now-idx*bridges[now]>=1) {
                    int left = now-idx++*bridges[now];
                    if (visit[left]) continue;
                    visit[left] = true;
                    q.offer(left);
                }
            }
            ++cnt;
        }
        return -1;
    }
}