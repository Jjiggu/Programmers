class Solution {
    public int solution(int[][] triangle) {
        int n = triangle.length;
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                dp[n - 1 - i][j] = triangle[i][j];
            }
        }
        
        
        for (int r = 1; r < n; r++) {
            for (int c = 0; c < n - r; c++) {
                dp[r][c] += Math.max(dp[r - 1][c], dp[r - 1][c + 1]);
            }
        }

        return dp[n - 1][0];
    }
}