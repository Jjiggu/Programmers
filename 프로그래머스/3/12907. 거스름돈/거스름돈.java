class Solution {
    
    static final int MOD = 1_000_000_007;
    
    public int solution(int n, int[] money) {
        int[] dp = new int[100001];
        dp[0] = 1;
        
        for (int m : money) {
            for (int i = m; i <= n; i++) {
                dp[i] = (dp[i] + dp[i - m]) % MOD;
            }
        }
        
        return dp[n];
    }
}