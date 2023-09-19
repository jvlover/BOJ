import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] dp = new long[36];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= N; ++i)
            for (int j = 0; j < i; ++j)
                dp[i] += dp[j] * dp[i-1-j];
        System.out.print(dp[N]);
    }
}