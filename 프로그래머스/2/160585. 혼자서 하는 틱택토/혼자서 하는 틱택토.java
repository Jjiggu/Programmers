class Solution {
    public int solution(String[] board) {
        int xCnt = 0;
        int oCnt = 0;
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i].charAt(j) == 'O') oCnt++;
                else if (board[i].charAt(j) == 'X') xCnt++;
            }
        }
        
        if (oCnt == xCnt + 1) {
            // 개수가 하나 차이나는 경우 -> O가 이겨야 함 
            boolean oWin = isBingo(board, 'O');
            boolean xWin = isBingo(board, 'X');
            
            if (oWin && !xWin) return 1;
            if (!oWin && !xWin) return 1;
        }
        
        // 개수가 같은 경우 -> X가 이기고 O는 빙고이면 안 됨
        if (oCnt == xCnt) {
            if (oCnt < 3 && xCnt < 3) return 1;
            
            boolean oWin = isBingo(board, 'O');
            boolean xWin = isBingo(board, 'X');
            
            if (!oWin && xWin) return 1;
            if (!oWin && !xWin) return 1;
        }
        
        return 0;  // 개수가 맞지 않는 경우 
    }
    
    private boolean isBingo(String[] board, Character target) {
        // 가로 
        for (int i = 0; i < 3; i++) {
            if (board[i].charAt(0) == target && board[i].charAt(1) == target && board[i].charAt(2) == target) return true;
        }
        
        // 세로 
        for (int i = 0; i < 3; i++) {
            if (board[0].charAt(i) == target && board[1].charAt(i) == target && board[2].charAt(i) == target) return true;
        }
        
        // 대각선 
        if (board[0].charAt(0) == target && board[1].charAt(1) == target && board[2].charAt(2) == target) return true;
        if (board[0].charAt(2) == target && board[1].charAt(1) == target && board[2].charAt(0) == target) return true;
        
        return false;
    }
}