import java.util.*;

class Solution {
    public int[] solution(int target) {
        Set<Integer> scores = new HashSet<>();
        for (int i = 1; i <= 20; i++) {
            scores.add(i);
            scores.add(i * 2);
            scores.add(i * 3);
        }
        scores.add(50);
        
        Set<Integer> singleBull = new HashSet<>();
        for (int i = 1; i <= 20; i++) singleBull.add(i);
        singleBull.add(50);
        
        
        int dp[][] = new int[target + 1][2];
        for (int i = 1; i <= target; i++) dp[i][0] = Integer.MAX_VALUE;
        
        for (int i = 1; i <= target; i++) {
            for (int dart : scores) {
                if (i - dart < 0) continue;
                int prevDarts = dp[i - dart][0] + 1;
                int prevSingleBull = dp[i - dart][1] + (singleBull.contains(dart) ? 1 : 0);
                
                if (prevDarts < dp[i][0]) {
                    dp[i][0] = prevDarts;
                    dp[i][1] = prevSingleBull;
                } else if (prevDarts == dp[i][0]){
                    dp[i][1] = Math.max(dp[i][1], prevSingleBull);
                }
                
            }
        }
        
        return dp[target];
    }
}