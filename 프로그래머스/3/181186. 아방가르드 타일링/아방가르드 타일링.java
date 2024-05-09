class Solution {
    public long solution(int n) {
        int mod = 1000000007;
        long[] dp1 = new long[100001];
        long[] dp2 = new long[100001];
        dp1[0] = 1;
        dp1[1] = 1;
        dp1[2] = 3;
        dp1[3] = 10;
        dp1[4] = 23;
        dp1[5] = 62;
        dp1[6] = 170;
        dp2[0] = 1;
        dp2[1] = 1;
        dp2[2] = 3;
        dp2[3] = 11;
        dp2[4] = 24;
        dp2[5] = 65;
        dp2[6] = 181;
        
        for (int i = 7; i <= n; ++i) {
            dp1[i] = (dp1[i-1] + 2*dp1[i-2] + 5*dp1[i-3] + 2*dp2[i-4] + 2*dp2[i-5] + 4*dp2[i-6]) % mod;
            dp2[i] = (dp1[i] + dp2[i-3]) % mod;
        }
        return dp1[n];
    }
}