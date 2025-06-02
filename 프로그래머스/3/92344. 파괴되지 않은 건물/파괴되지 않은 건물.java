class Solution {
    public int solution(int[][] board, int[][] skill) {
        int[][] prefix = new int[board.length + 1][board[0].length + 1];
        
        for (int[] s : skill) {
            int type = s[0];
            int r1 = s[1];
            int c1 = s[2];
            int r2 = s[3];
            int c2 = s[4];
            int degree = s[5];
            
            if (type == 1) degree = -degree;
    
            prefix[r1][c1] += degree;
            prefix[r1][c2 + 1] -= degree;
            prefix[r2 + 1][c1] -= degree;
            prefix[r2 + 1][c2 + 1] += degree;
        }
        
        for (int r = 0; r < prefix.length; r++) {
            for (int c = 1; c < prefix[0].length; c++) {
                prefix[r][c] += prefix[r][c - 1];
            }
        }
        
        for (int c = 0; c < prefix[0].length; c++) {
            for (int r = 1; r < prefix.length; r++) {
                prefix[r][c] += prefix[r - 1][c];
            }
        }
        
        int answer = 0;
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (board[r][c] + prefix[r][c] > 0) answer++; 
            }
        }
        
        return answer;
    }
}
