import java.util.*;

class Solution {
    public int[] solution(int target) {
        // 1. 만들 수 있는 모든 점수 집합
        Set<Integer> darts = new HashSet<>();
        for (int i = 1; i <= 20; i++) {
            darts.add(i);        // 싱글
            darts.add(i * 2);    // 더블
            darts.add(i * 3);    // 트리플
        }
        darts.add(50); // 불

        // 2. 싱글/불만 따로 집합(마지막 한 발 체크용)
        Set<Integer> singleBull = new HashSet<>();
        for (int i = 1; i <= 20; i++) singleBull.add(i);
        singleBull.add(50);

        // 3. DP 테이블 [0: 최소 다트 개수, 1: 싱글/불 사용 개수]
        int[][] dp = new int[target + 1][2];
        for (int i = 1; i <= target; i++) dp[i][0] = Integer.MAX_VALUE;
        // dp[0] = {0, 0}

        // 4. DP 진행
        for (int i = 1; i <= target; i++) {
            for (int d : darts) {
                if (i - d < 0) continue;
                int prevDarts = dp[i - d][0] + 1;
                int prevSingleBull = dp[i - d][1] + (singleBull.contains(d) ? 1 : 0);

                // 최소 다트 개수 우선, 같으면 싱글/불 최대 우선
                if (prevDarts < dp[i][0]) {
                    dp[i][0] = prevDarts;
                    dp[i][1] = prevSingleBull;
                } else if (prevDarts == dp[i][0]) {
                    dp[i][1] = Math.max(dp[i][1], prevSingleBull);
                }
            }
        }

        return dp[target];
    }
}
