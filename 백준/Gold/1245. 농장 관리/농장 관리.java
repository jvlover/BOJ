import java.io.*;
import java.util.*;
public class Main {
    static class Node {
        int r, c;
        Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    static int N, M, ans;
    static int[][] map;
    static boolean[][] visit;
    static int[][] delta = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visit = new boolean[N][M];
        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; ++j) map[i][j] = Integer.parseInt(st.nextToken());
        }
        ans = 0;
        for (int i = 0; i < N; ++i)
            for (int j = 0; j < M; ++j)
                if (!visit[i][j]) bfs(i, j);
        System.out.print(ans);
    }
    private static void bfs(int r, int c) {
        boolean flag = true;
        Queue<Node> q = new LinkedList<>();
        visit[r][c] = true;
        q.offer(new Node(r, c));
        while (!q.isEmpty()) {
            Node cur = q.poll();
            for (int i = 0; i < 8; ++i) {
                int nr = cur.r + delta[i][0];
                int nc = cur.c + delta[i][1];
                if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
                if (map[r][c] < map[nr][nc]) flag = false;
                else if (!visit[nr][nc] && map[r][c] == map[nr][nc]) {
                    visit[nr][nc] = true;
                    q.offer(new Node(nr, nc));
                }
            }
        }
        if (flag) ++ans;
    }
}