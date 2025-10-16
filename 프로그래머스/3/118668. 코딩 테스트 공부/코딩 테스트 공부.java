import java.util.*;

class Solution {
    public int solution(int alp, int cop, int[][] problems) {
        int targetAlp = 0;
        int targetCop = 0;
        
        for (int[] problem : problems) {
            targetAlp = Math.max(problem[0], targetAlp);
            targetCop = Math.max(problem[1], targetCop);
        }
        
        alp = Math.min(alp, targetAlp);
        cop = Math.min(cop, targetCop);
        
        int[][] dp = new int[targetAlp + 2][targetCop + 2];
        for (int i = 0; i <= targetAlp + 1; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        
        dp[alp][cop] = 0; 
        
        for (int i = alp; i <= targetAlp; i++) {
            for (int j = cop; j <= targetCop; j++) {
                dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j] + 1);
                dp[i][j + 1] = Math.min(dp[i][j + 1], dp[i][j] + 1);
                
                for (int[] problem : problems) {
                    if (i >= problem[0] && j >= problem[1]) {
                        int nextI = Math.min(targetAlp, i + problem[2]);
                        int nextJ = Math.min(targetCop, j + problem[3]);
                        dp[nextI][nextJ] = Math.min(dp[nextI][nextJ], dp[i][j] + problem[4]);
                    }
                }
            }
        }
        
        return dp[targetAlp][targetCop];
    }
}
