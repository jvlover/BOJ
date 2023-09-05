import java.io.*;
import java.util.*;
public class Main {
    static int N, K, time;
    static Queue<Node> q;
    static boolean[] visit;
    static int[] parent;
    static StringBuilder sb = new StringBuilder();
    static class Node {
        int pos, time;
        Node(int pos, int time) {
            this.pos = pos;
            this.time = time;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        time = -1;
        parent = new int[100001];
        bfs();
        sb.append(time).append('\n');
        route(K);
        System.out.print(sb);
    }
    static void bfs() {
        q = new LinkedList<>();
        visit = new boolean[100001];
        visit[N] = true;
        q.offer(new Node(N, 0));
        while (!q.isEmpty()) {
            Node cur = q.poll();
            if (cur.pos == K) {
                time = cur.time;
                return;
            }
            offer(cur.pos, cur.pos-1, cur.time+1);
            offer(cur.pos, cur.pos+1, cur.time+1);
            offer(cur.pos, cur.pos<<1, cur.time+1);
        }
    }
    static void offer(int cur, int next, int time) {
        if (next < 0 || next > 100000 || visit[next]) return;
        parent[next] = cur;
        visit[next] = true;
        q.offer(new Node(next, time));
    }
    static void route(int cur) {
        if (cur != N) route(parent[cur]);
        sb.append(cur).append(' ');
    }
}