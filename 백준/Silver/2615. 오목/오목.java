import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[][] delta = {{0, 1}, {1, 0}, {1, 1}, {-1, 1}};
        int[][] map = new int[19][19];
        for (int i = 0; i < 19; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 19; ++j) map[i][j] = Integer.parseInt(st.nextToken());
        }
        for (int c = 0; c < 19; ++c) {
            for (int r = 0; r < 19; ++r) {
                if (map[r][c] == 1 || map[r][c] == 2) {
                    for (int i = 0; i < 4; ++i) {
                        int nr = r, nc = c, cnt = 1;
                        while (true) {
                            nr += delta[i][0];
                            nc += delta[i][1];
                            if (nr < 0 || nc < 0 || nr >= 19 || nc >= 19 || map[r][c] != map[nr][nc]) break;
                            ++cnt;
                        }
                        nr = r;
                        nc = c;
                        while (true) {
                            nr -= delta[i][0];
                            nc -= delta[i][1];
                            if (nr < 0 || nc < 0 || nr >= 19 || nc >= 19 || map[r][c] != map[nr][nc]) break;
                            ++cnt;
                        }
                        if (cnt == 5) {
                            System.out.print(map[r][c] + "\n" + (r+1) + " " + (c+1));
                            System.exit(0);
                        }
                    }
                }
            }
        }
        System.out.print(0);
    }
}