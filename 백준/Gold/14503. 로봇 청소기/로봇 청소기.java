import java.io.*;
import java.util.*;
public class Main {
    static int N, M, ans = 1;
    static int[][] map, delta = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken()), c = Integer.parseInt(st.nextToken()), dir = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; ++j) map[i][j] = Integer.parseInt(st.nextToken());
        }
        dfs(r, c, dir);
        System.out.print(ans);
    }
    static void dfs(int r, int c, int dir) {
        map[r][c] = 2;
        for (int i = 0; i < 4; ++i) {
            dir = (dir+3)%4;
            int nr = r + delta[dir][0];
            int nc = c + delta[dir][1];
            if (isInRange(nr, nc) && map[nr][nc] == 0) {
                ++ans;
                dfs(nr, nc, dir);
                return;
            }
        }
        int backDir = (dir+2)%4;
        int nr = r + delta[backDir][0];
        int nc = c + delta[backDir][1];
        if (isInRange(nr, nc) && map[nr][nc] != 1) dfs(nr, nc, dir);
    }
    static boolean isInRange(int r, int c) {
        return r >= 0 && c >= 0 && r < N && c < M;
    }
}