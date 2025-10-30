import java.util.*;

class Solution {
    int solution(int[][] land) {
        int n = land.length;
        
        int[][] dp = new int[n][4];
        
        dp[0] = land[0];
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    if (j == k) continue;
                    dp[i][j] = Math.max(dp[i][j], land[i][j] + dp[i - 1][k]);
                }
            }
        }
        
        return findMax(dp);
    }
    
    private int findMax(int[][] dp) {
        int answer = 0;
        
        for (int i = 0; i < 4; i++) {
            answer = Math.max(answer, dp[dp.length - 1][i]);
        }
        
        return answer;
    }
}