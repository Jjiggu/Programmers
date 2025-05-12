class Solution {
    public int solution(int[][] triangle) {
        int[][] dp = new int[502][502];
        int n = triangle.length;
        
        for (int i = 0; i < triangle[n - 1].length; i++) {
            dp[n - 1][i] = triangle[n - 1][i];
        }
        
        
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < triangle[i].length; j++) {
                dp[i][j] = triangle[i][j] + Math.max(dp[i + 1][j], dp[i + 1][j + 1]);
            }
        }
        
        return dp[0][0];
    }
}