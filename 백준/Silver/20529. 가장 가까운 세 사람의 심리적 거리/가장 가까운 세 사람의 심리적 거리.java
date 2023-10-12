import java.io.*;
import java.util.*;
public class Main {
    static int N, min;
    static String[] arr, choice;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        while (T-->0) {
            N = Integer.parseInt(br.readLine());
            arr = new String[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; ++i) arr[i] = st.nextToken();
            min = 12;
            choice = new String[3];
            combination(0, 0);
            sb.append(min).append('\n');
        }
        System.out.print(sb);
    }
    static void combination(int cnt, int idx) {
        if (min == 0) return;
        if (cnt == 3) {
            int dist = 0;
            for (int i = 0; i < 4; ++i)
                dist += (choice[0].charAt(i) == choice[1].charAt(i) ? 0 : 1) + (choice[1].charAt(i) == choice[2].charAt(i) ? 0 : 1) + (choice[0].charAt(i) == choice[2].charAt(i) ? 0 : 1);
            min = Math.min(min, dist);
            return;
        }
        for (int i = idx; i < N; ++i) {
            choice[cnt] = arr[i];
            combination(cnt+1, i+1);
        }
    }
}