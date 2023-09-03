import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] map = new char[N][M];
        for (int i = 0; i < N; ++i) map[i] = br.readLine().toCharArray();
        int ans = 0;
        boolean flag = false;
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                if (map[i][j] == '/' || map[i][j] == '\\') {
                    if (!flag) flag = true;
                    else {
                        flag = false;
                        ++ans;
                    }
                } else if (flag) ++ans;
            }
        }
        System.out.print(ans);
    }
}