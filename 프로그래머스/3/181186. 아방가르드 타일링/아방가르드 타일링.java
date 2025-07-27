class Solution {
    public int solution(int n) {
        final int MOD = 1_000_000_007;

        long[] dp = new long[n + 1];
        long[] sum = new long[n + 1];
        
        dp[0] = 1;
        if (n >= 1) dp[1] = 1;
        if (n >= 2) dp[2] = 3;
        sum[0] = dp[0];
        if (n >= 1) sum[1] = dp[1];
        if (n >= 2) sum[2] = dp[2];
        
        for (int i = 3; i <= n; i++) {
            long c0 = sum[i - 3];
            long c1 = (i - 4 >= 0 ? sum[i - 4] : 0);
            long c2 = (i - 5 >= 0 ? sum[i - 5] : 0);
            
            dp[i] = (dp[i - 1] + dp[i - 2] * 2 + dp[i - 3] + c0 * 4 + c1 * 2 + c2 * 2) % MOD;
            
            sum[i] = (dp[i] + sum[i - 3]) % MOD;
        }
        
        return (int)dp[n];
    }
}
