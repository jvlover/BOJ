import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr1 = new int[122];
        int[] arr2 = new int[122];
        arr1[1] = 1;
        arr2[1] = 1;
        for (int i = 2; i < 122; ++i) {
            arr1[i] = arr1[i-1] + i;
            arr2[i] = arr1[i] + arr2[i-1];
        }
        int[] dp = new int[N+1];
        Arrays.fill(dp, 333333);
        for (int i = 1; i <= N; ++i) {
            for (int j : arr2) {
                if (i == j) {
                    dp[i] = 1;
                    break;
                }
                else if (i < j) break;
                dp[i] = Math.min(dp[i], dp[i-j]+1);
            }
        }
        System.out.print(dp[N]);
    }
}