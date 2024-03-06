import java.io.*;
import java.util.*;
public class Main {
    static int cnt;
    static boolean[][] visit, isCycle;
    static int[][] map, delta = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; ++i) {
            String s = br.readLine();
            for (int j = 0; j < M; ++j) {
                switch (s.charAt(j)) {
                    case 'U':
                        map[i][j] = 0;
                        break;
                    case 'D':
                        map[i][j] = 1;
                        break;
                    case 'L':
                        map[i][j] = 2;
                        break;
                    case 'R':
                        map[i][j] = 3;
                        break;
                }
            }
        }
        visit = new boolean[N][M];
        isCycle = new boolean[N][M];
        for (int i = 0; i < N; ++i)
            for (int j = 0; j < M; ++j)
                if (!visit[i][j]) dfs(i, j);
        System.out.print(cnt);
    }
    static void dfs(int r, int c) {
        visit[r][c] = true;
        int nr = r + delta[map[r][c]][0];
        int nc = c + delta[map[r][c]][1];
        if (!visit[nr][nc]) dfs(nr, nc);
        else if (!isCycle[nr][nc]) ++cnt;
        isCycle[r][c] = true;
    }
}