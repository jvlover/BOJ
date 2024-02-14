import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        while (T-->0) {
            int N = Integer.parseInt(br.readLine());
            int[] p = new int[N+1];
            for (int i = 1; i < N; ++i) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
                p[b] = a;
            }
            boolean[] isP = new boolean[N+1];
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
            while (a != 0) {
                isP[a] = true;
                a = p[a];
            }
            while (!isP[b]) b = p[b];
            sb.append(b).append('\n');
        }
        System.out.print(sb);
    }
}