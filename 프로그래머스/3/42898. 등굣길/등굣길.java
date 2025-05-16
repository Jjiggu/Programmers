import java.util.*;

class Solution {
    static final int MOD = 1_000_000_007;
    
    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[m + 3][n + 3];
        
        for (int[] puddle : puddles) {
            int x = puddle[0];
            int y = puddle[1];
            dp[x][y] = -1;
        }
        
        for (int i = 0; i <= m + 2; i++) {
            for (int j = 0; j <= n + 2; j++) {
                if (i == 0 || i == m + 2 || j == 0 || j == n + 2) {
                    dp[i][j] = -1;
                }
             }
        }
        
        dp[1][1] = 1;
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1 && j == 1) continue;
                if (dp[i][j] == -1) continue;
                
                int fromTop = dp[i - 1][j] == -1 ? 0 : dp[i - 1][j];
                int fromLeft = dp[i][j - 1] == -1 ? 0 : dp[i][j - 1];
                dp[i][j] = (fromTop + fromLeft) % MOD;
            }
        }
        
        return dp[m][n];
    }    
}