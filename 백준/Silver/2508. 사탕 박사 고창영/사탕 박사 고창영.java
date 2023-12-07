import java.io.*;
import java.util.*;
public class Main {
    static int N, M;
    static char[][] map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        while (T-->0) {
            br.readLine();
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            map = new char[N][M];
            for (int i = 0; i < N; ++i) map[i] = br.readLine().toCharArray();
            int cnt = 0;
            for (int i = 0; i < N; ++i)
                for (int j = 0; j < M; ++j)
                    if (isHorizontalCandy(i, j) || isVerticalCandy(i, j)) ++cnt;
            sb.append(cnt).append('\n');
        }
        System.out.print(sb);
    }
    static boolean isHorizontalCandy(int r, int c) {
        return c <= M-3 && map[r][c] == '>' && map[r][c+1] == 'o' && map[r][c+2] == '<';
    }
    static boolean isVerticalCandy(int r, int c) {
        return r <= N-3 && map[r][c] == 'v' && map[r+1][c] == 'o' && map[r+2][c] == '^';
    }
}