import java.util.*;

class Solution {
    int solution(int[][] land) {
        int answer = 0;
        int n = land.length;
        int m = land[0].length;
        int[][] dp = new int[n][m];
        
        dp[0] = land[0];
        
        for (int col = 1; col < n; col++) {
            for (int row = 0; row < m; row++) {
                int maxPrev = 0;
                for (int k = 0; k < m; k++) {
                    if (k == row) continue;
                    maxPrev = Math.max(maxPrev, dp[col - 1][k]);
                }
                dp[col][row] = maxPrev + land[col][row];
            }
        }
        
        return findMax(dp);
    }
    
    private int findMax(int[][] dp) {
        int maxNum = -1;
        int len = dp.length - 1;
        
        for (int i = 0; i < dp[0].length; i++) maxNum = Math.max(maxNum, dp[len][i]);
        
        return maxNum;
    }
}