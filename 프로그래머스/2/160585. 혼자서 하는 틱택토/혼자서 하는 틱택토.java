class Solution {
    
    static int oCnt = 0;
    static int xCnt = 0;
    
    public int solution(String[] board) {
        findCnt(board);
        if (xCnt > oCnt) return 0;
        if (oCnt > xCnt + 1) return 0;
        
        boolean oWin = isWin(board, 'O');
        boolean xWin = isWin(board, 'X');
        if (oWin && xWin) return 0;
        if (oWin && oCnt != xCnt + 1) return 0;
        if (xWin && oCnt != xCnt) return 0;
        
        return 1;
    }
    
    public void findCnt(String[] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                char c = board[i].charAt(j);
                if (c == 'O') oCnt++;
                else if (c == 'X') xCnt++;
            }
        }
    }
    
    public boolean isWin(String[] board, char mark) {
        
        for (int i = 0; i < 3; i++) {
            if (board[i].charAt(0) == mark && board[i].charAt(1) == mark && board[i].charAt(2) == mark) return true;
            
            if (board[0].charAt(i) == mark && board[1].charAt(i) == mark && board[2].charAt(i) == mark) return true;
        }
        
        if (board[0].charAt(0) == mark && board[1].charAt(1) == mark && board[2].charAt(2) == mark) return true;
        if (board[0].charAt(2) == mark && board[1].charAt(1) == mark && board[2].charAt(0) == mark) return true;
        
        return false;
    }
}