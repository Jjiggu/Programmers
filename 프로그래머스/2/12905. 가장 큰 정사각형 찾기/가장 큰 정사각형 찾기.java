class Solution {
    public int solution(int[][] board) {
        int n = board.length;
        int m = board[0].length;
        
        int[][] dp = new int[n][m];
        
        for (int i = 0; i < m; i ++) {
            if (board[0][i] == 1) dp[0][i] = 1;
        }
        for (int i = 0; i < n; i ++) {
            if (board[i][0] == 1) dp[i][0] = 1;
        }
        
        
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (board[i][j] == 1) {
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        
        int answer = findMax(dp);
        return (int)Math.pow(answer, 2);
    }
    
    public int findMax(int[][] dp) {
        int maxNum = 0;
        
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (dp[i][j] > maxNum) maxNum = dp[i][j];
            }
        }
        return maxNum;
    }
}