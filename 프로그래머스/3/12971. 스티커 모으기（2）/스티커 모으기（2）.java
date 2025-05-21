class Solution {
    public int solution(int sticker[]) {
        int n = sticker.length;
        int[] dp = new int[n + 1];
        
        if (sticker.length == 1) {
            return sticker[0];
        }
        
        dp[0] = sticker[0];
        dp[1] = dp[0];
        
        for (int i = 2; i < n - 1; i++) {
            dp[i] = Math.max(sticker[i] + dp[i - 2], dp[i - 1]);
        }
        
        int answer = dp[n - 2];
        
        
        dp[0] = 0;
        dp[1] = sticker[1];
        
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(sticker[i] + dp[i - 2], dp[i - 1]);
        }
        
        return Math.max(answer, dp[n - 1]);
    }
}