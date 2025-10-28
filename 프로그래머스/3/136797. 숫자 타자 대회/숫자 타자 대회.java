import java.util.*;

class Solution {    
    int[][] weight = new int[][] {
        {1, 7, 6, 7, 5, 4, 5, 3, 2, 3}, 
        {7, 1, 2, 4, 2, 3, 5, 4, 5, 6}, 
        {6, 2, 1, 2, 3, 2, 3, 5, 4, 5},
        {7, 4, 2, 1, 5, 3, 2, 6, 5, 4}, 
        {5, 2, 3, 5, 1, 2, 4, 2, 3, 5}, 
        {4, 3, 2, 3, 2, 1, 2, 3, 2, 3},
        {5, 5, 3, 2, 4, 2, 1, 5, 3, 2}, 
        {3, 4, 5, 6, 2, 3, 5, 1, 2, 4}, 
        {2, 5, 4, 5, 3, 2, 3, 2, 1, 2},
        {3, 6, 5, 4, 5, 3, 2, 4, 2, 1}
    };

    int[][][] dp;  // dp[idx][left][right] = 최소 비용
    int len;
    char[] arr;
    static final int INF = 1_000_000_000;

    public int solution(String numbers) {    
        len = numbers.length();
        arr = numbers.toCharArray();
        dp = new int[len + 1][10][10];

        for (int i = 0; i <= len; i++) {
            for (int j = 0; j < 10; j++) {
                Arrays.fill(dp[i][j], -1); // 미계산 표시
            }
        }

        // 시작 손가락: 왼손 4, 오른손 6
        return getMoveCnt(0, 4, 6);
    }
    
    private int getMoveCnt(int idx, int left, int right) {
        if (idx == len) return 0;

        if (dp[idx][left][right] != -1) return dp[idx][left][right];

        int target = arr[idx] - '0';
        int best = INF;

        // 왼손으로 누르기 (두 손가락이 같은 키 금지)
        if (target != right) {
            int cost = weight[left][target] + getMoveCnt(idx + 1, target, right);
            best = Math.min(best, cost);
        }

        // 오른손으로 누르기
        if (target != left) {
            int cost = weight[right][target] + getMoveCnt(idx + 1, left, target);
            best = Math.min(best, cost);
        }

        return dp[idx][left][right] = best;
    }
}
