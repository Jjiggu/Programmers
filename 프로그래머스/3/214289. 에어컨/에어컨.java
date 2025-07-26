import java.util.*;

class Solution {
    public int solution(int temperature, int t1, int t2, int a, int b, int[] onboard) {
        
        final int MIN_TEMP = -10;
        final int MAX_TEMP = 40;
        final int RANGE = MAX_TEMP - MIN_TEMP;
        int n = onboard.length;
        
        int outdoor = temperature - MIN_TEMP;
        int low = t1 - MIN_TEMP;
        int high = t2 - MIN_TEMP;
        
        final int INF = 1_000_001;
        int[][] dp = new int[n][RANGE + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], INF);
        }
        dp[0][outdoor] = 0;
        
        for (int t = 0; t < n - 1; t++) {
            for (int temp = 0; temp <= RANGE; temp++) {
                int cost = dp[t][temp];
                if (cost == INF) continue;
                if (onboard[t] == 1 && (temp < low || temp > high)) continue;
                
                int next = temp;
                if (temp < outdoor) next = temp + 1;
                if (temp > outdoor) next = temp - 1;
                dp[t + 1][next] = Math.min(dp[t + 1][next], cost);
                
                if (temp < RANGE) {
                    dp[t + 1][temp + 1] = Math.min(dp[t + 1][temp + 1], cost + a);
                }
                if (temp > 0) {
                    dp[t + 1][temp - 1] = Math.min(dp[t + 1][temp - 1], cost + a);
                }
                dp[t + 1][temp] = Math.min(dp[t + 1][temp], cost + b);
            }
        }
        
        int answer = INF;
        for (int temp = 0; temp <= RANGE; temp++) {
            if (onboard[n-1] == 1 && (temp < low || temp > high)) continue;
            answer = Math.min(answer, dp[n - 1][temp]);
        }
        
        return answer;
    }
}