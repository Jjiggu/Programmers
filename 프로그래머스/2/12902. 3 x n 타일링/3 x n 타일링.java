class Solution {
    
    static final int MOD = 1_000_000_007;
    
    public int solution(int n) {
        long[] dp = new long[n + 1];
        
        dp[0] = 1;
        dp[2] = 3;
        
        long sum = dp[0];
        
        for (int i = 4; i <= n; i+=2) {
            dp[i] = (3 * dp[i - 2] + 2 * sum) % MOD;
            sum = (sum + dp[i - 2]) % MOD;
        }
        
        return (int)dp[n];
    }
}