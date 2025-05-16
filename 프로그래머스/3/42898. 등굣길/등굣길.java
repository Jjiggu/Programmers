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
        
        dp[1][1] = 1;
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (dp[i][j] == -1) {
                    dp[i][j] = 0; 
                    continue;
                }
                
                dp[i][j] = (dp[i][j] + dp[i - 1][j]) % MOD;
                dp[i][j] = (dp[i][j] + dp[i][j - 1]) % MOD;
            }
        }
        
        return dp[m][n];
    }    
}