import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken()), d = Integer.parseInt(st.nextToken()), N = Integer.parseInt(st.nextToken());
        int[] dp = new int[N+1];
        dp[0] = 1;
        for (int i = 1; i <= N; ++i) {
            if (i < a) dp[i] = dp[i-1];
            else if (i < b) dp[i] = (dp[i-1]+dp[i-a])%1000;
            else dp[i] = (dp[i-1]+dp[i-a]-dp[i-b]+1000)%1000;
        }
        System.out.print(d<=N ? (dp[N]-dp[N-d]+1000)%1000 : dp[N]%1000);
    }
}