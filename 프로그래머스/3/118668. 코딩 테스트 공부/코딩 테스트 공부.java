import java.util.*;

class Solution {
    public int solution(int alp, int cop, int[][] problems) {
        int maxAlp = 0;
        int maxCop = 0;
        
        for (int[] problem : problems) {
            maxAlp = Math.max(problem[0], maxAlp);
            maxCop = Math.max(problem[1], maxCop);
        }

        alp = Math.min(alp, maxAlp);
        cop = Math.min(cop, maxCop);
        
        int[][] dp = new int[maxAlp + 2][maxCop + 2];
        for (int i = 0; i <= maxAlp + 1; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        
        dp[alp][cop] = 0; 

        for (int i = alp; i <= maxAlp; i++) {
            for (int j = cop; j <= maxCop; j++) {
                if (dp[i][j] == Integer.MAX_VALUE) continue;

                // 1. 알고리즘 공부
                dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j] + 1);

                // 2. 코딩 공부
                dp[i][j + 1] = Math.min(dp[i][j + 1], dp[i][j] + 1);

                // 3. 문제 풀이
                for (int[] problem : problems) {
                    int reqAlp = problem[0], reqCop = problem[1];
                    int rwdAlp = problem[2], rwdCop = problem[3], cost = problem[4];

                    if (i >= reqAlp && j >= reqCop) {
                        int nextAlp = Math.min(i + rwdAlp, maxAlp);
                        int nextCop = Math.min(j + rwdCop, maxCop);
                        dp[nextAlp][nextCop] = Math.min(dp[nextAlp][nextCop], dp[i][j] + cost);
                    }
                 }
            }
        }

        return dp[maxAlp][maxCop];
    }
}
