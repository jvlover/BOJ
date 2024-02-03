import java.io.*;
import java.util.*;
public class Main {
    static int N;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-->0) {
            N = Integer.parseInt(br.readLine());
            dfs(1, 1, true, "1", 0);
            sb.append('\n');
        }
        System.out.print(sb);
    }
    static void dfs(int idx, int num, boolean flag, String str, int sum) {
        if (idx == N) {
            if (flag) sum += num;
            else sum -= num;
            if (sum == 0) sb.append(str).append('\n');
            return;
        }
        int next = flag ? sum+num : sum-num;
        dfs(idx+1, 10*num+idx+1, flag, str+" "+(idx+1), sum);
        dfs(idx+1, idx+1, true, str+"+"+(idx+1), next);
        dfs(idx+1, idx+1, false, str+"-"+(idx+1), next);
    }
}