import java.io.*;
import java.util.*;
public class Main {
    static int N, M;
    static int[] guitarCnt;
    static boolean[] visit;
    static boolean[][] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new boolean[N][M];
        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            String str = st.nextToken();
            for (int j = 0; j < M; ++j) arr[i][j] = str.charAt(j) == 'Y';
        }
        guitarCnt = new int[M+1];
        visit = new boolean[N];
        powerSet(0, 0);
        int ans = -1;
        for (int i = M; i > 0; --i) {
            if (guitarCnt[i] > 0) {
                ans = guitarCnt[i];
                break;
            }
        }
        System.out.print(ans);
    }
    static void powerSet(int idx, int cnt) {
        if (idx == N) {
            boolean[] songs = new boolean[M];
            for (int i = 0; i < N; ++i) {
                if (!visit[i]) continue;
                for (int j = 0; j < M; ++j)
                    if (arr[i][j]) songs[j] = true;
            }
            int songCnt = 0;
            for (int i = 0; i < M; ++i)
                if (songs[i]) ++songCnt;
            guitarCnt[songCnt] = guitarCnt[songCnt] == 0 ? cnt : Math.min(guitarCnt[songCnt], cnt);
            return;
        }
        visit[idx] = true;
        powerSet(idx+1, cnt+1);
        visit[idx] = false;
        powerSet(idx+1, cnt);
    }
}