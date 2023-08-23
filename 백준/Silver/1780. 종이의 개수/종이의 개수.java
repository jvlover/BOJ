import java.io.*;
import java.util.*;
public class Main {
    static int[][] map;
    static int cntA, cntB, cntC;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; ++j) map[i][j] = Integer.parseInt(st.nextToken());
        }
        cntA = cntB = cntC = 0;
        dnc(0, 0, N);
        sb.append(cntA).append('\n').append(cntB).append('\n').append(cntC);
        System.out.print(sb);
    }
    static void dnc(int r, int c, int size) {
        if (isSame(r, c, size)) {
            if (map[r][c] == -1) ++cntA;
            else if (map[r][c] == 0) ++cntB;
            else ++cntC;
            return;
        }
        int newSize = size/3;
        for (int i = r; i <= r+2*newSize; i += newSize)
            for (int j = c; j <= c+2*newSize; j += newSize)
                dnc(i, j, newSize);
    }
    static boolean isSame(int r, int c, int size) {
        int start = map[r][c];
        for (int i = r; i < r+size; ++i)
            for (int j = c; j < c+size; ++j)
                if (map[i][j] != start) return false;
        return true;
    }
}