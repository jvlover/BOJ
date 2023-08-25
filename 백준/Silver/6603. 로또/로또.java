import java.io.*;
import java.util.*;
public class Main {
    static int N;
    static int[] arr;
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String str;
        while (!(str = br.readLine()).equals("0")) {
            st = new StringTokenizer(str);
            N = Integer.parseInt(st.nextToken());
            arr = new int[N];
            for (int i = 0; i < N; ++i) arr[i] = Integer.parseInt(st.nextToken());
            visit = new boolean[N];
            combination(0, 0);
            sb.append('\n');
        }
        System.out.print(sb);
    }
    static void combination(int idx, int cnt) {
        if (cnt == 6) {
            for (int i = 0; i < N; ++i) if (visit[i]) sb.append(arr[i]).append(' ');
            sb.append('\n');
            return;
        }
        for (int i = idx; i < N; ++i) {
            visit[i] = true;
            combination(i+1, cnt+1);
            visit[i] = false;
        }
    }
}