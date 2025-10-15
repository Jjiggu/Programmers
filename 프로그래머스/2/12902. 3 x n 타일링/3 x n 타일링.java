class Solution {
    private static final int MOD = 1_000_000_007;

    public int solution(int n) {
        if (n % 2 == 1) return 0;     
        
        long[] dp = new long[n + 1];
        long[] edge = new long[n + 1];
        
        dp[0] = 1;
        edge[0] = 1;
        
        if (n >= 2) {
            dp[2] = 3;
            edge[2] = (edge[0] + dp[2]) % MOD;
        }
        
        for (int i = 4; i <= n; i += 2) {
            dp[i] = (dp[i - 2] * 3 + 2 * edge[i - 4]) % MOD;
            edge[i] = (edge[i - 2] + dp[i]) % MOD;
        }
        
        return (int)dp[n];
    }
}
