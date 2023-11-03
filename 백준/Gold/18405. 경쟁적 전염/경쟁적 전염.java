import java.io.*;
import java.util.*;
public class Main {
    static class Virus implements Comparable<Virus> {
        int r, c, time, number;
        Virus(int r, int c, int time, int number) {
            this.r = r;
            this.c = c;
            this.time = time;
            this.number = number;
        }
        @Override
        public int compareTo(Virus o) {
            if (this.time == o.time) return Integer.compare(this.number, o.number);
            return Integer.compare(this.time, o.time);
        }
    }
    static int N, S, X, Y;
    static int[][] map;
    static PriorityQueue<Virus> pq;
    static int[][] delta = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        pq = new PriorityQueue<>();
        map = new int[N+1][N+1];
        for (int i = 1; i <= N; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; ++j) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] != 0) pq.offer(new Virus(i, j, 0, map[i][j]));
            }
        }
        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        System.out.print(bfs());
    }
    static int bfs() {
        while (!pq.isEmpty()) {
            Virus now = pq.poll();
            if (now.time == S) return map[X][Y];
            for (int i = 0; i < 4; ++i) {
                int nr = now.r + delta[i][0];
                int nc = now.c + delta[i][1];
                if (nr < 1 || nc < 1 || nr > N || nc > N || map[nr][nc] != 0) continue;
                pq.offer(new Virus(nr, nc, now.time+1, map[nr][nc] = map[now.r][now.c]));
            }
        }
        return map[X][Y];
    }
}