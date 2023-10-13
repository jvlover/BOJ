import java.io.*;
import java.util.*;
public class Main {
    static int N, max;
    static int[] health, joy;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        health = new int[N];
        for (int i = 0; i < N; ++i) health[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        joy = new int[N];
        for (int i = 0; i < N; ++i) joy[i] = Integer.parseInt(st.nextToken());
        max = 0;
        solve(0, 100, 0);
        System.out.print(max);
    }
    static void solve(int idx, int hp, int jp) {
        if (hp <= 0) return;
        if (idx == N) {
            max = Math.max(max, jp);
            return;
        }
        solve(idx+1, hp, jp);
        solve(idx+1, hp-health[idx], jp+joy[idx]);
    }
}