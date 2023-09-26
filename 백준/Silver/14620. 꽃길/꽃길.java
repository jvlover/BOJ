import java.io.*;
import java.util.*;
public class Main {
    static int[][] map;
    static boolean[][] visit;
    static int N, min = Integer.MAX_VALUE;
    static int[][] delta = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; ++j) map[i][j] = Integer.parseInt(st.nextToken());
        }
        visit = new boolean[N][N];
        dfs(0, 0);
        System.out.print(min);
    }
    static void dfs(int cnt, int sum) {
        if (cnt == 3) {
            min = Math.min(min, sum);
            return;
        }
        for (int i = 1; i < N-1; ++i) {
            for (int j = 1; j < N-1; ++j) {
                if (!check(i, j)) continue;
                int temp = map[i][j];
                visit[i][j] = true;
                for (int k = 0; k < 4; ++k) {
                    int nr = i + delta[k][0];
                    int nc = j + delta[k][1];
                    temp += map[nr][nc];
                    visit[nr][nc] = true;
                }
                dfs(cnt+1, sum+temp);
                visit[i][j] = false;
                for (int k = 0; k < 4; ++k) {
                    int nr = i + delta[k][0];
                    int nc = j + delta[k][1];
                    visit[nr][nc] = false;
                }
            }
        }
    }
    static boolean check(int r, int c) {
        if (visit[r][c]) return false;
        for (int i = 0; i < 4; ++i) {
            int nr = r + delta[i][0];
            int nc = c + delta[i][1];
            if (visit[nr][nc]) return false;
        }
        return true;
    }
}