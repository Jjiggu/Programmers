class Solution {
    public int solution(String[] board) {
        int OCnt = 0;
        int XCnt = 0;
        
        for (String s : board) {
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == 'O') OCnt++;
                if (s.charAt(i) == 'X') XCnt++;
            }
        }
        
        // 기본 규칙
        if (XCnt > OCnt) return 0;
        if (OCnt - XCnt > 1) return 0;
        
        boolean OWin = isWin(board, 'O');
        boolean XWin = isWin(board, 'X');
        
        // 2. 둘 다 이긴 경우는 불가능
        if (OWin && XWin) return 0;
        
        // 3. O가 이긴 경우: O는 항상 X보다 한 수 더 많이 둔 상태
        if (OWin && OCnt != XCnt + 1) return 0;
        
        // 4. X가 이긴 경우: X는 항상 O와 같은 수를 둔 상태
        if (XWin && OCnt != XCnt) return 0;
        
        return 1;
    }
    
    private boolean isWin(String[] board, char target) {
        for (int i = 0; i < 3; i++) {
            if (board[i].charAt(0) == target &&
                board[i].charAt(1) == target &&
                board[i].charAt(2) == target) {
                return true;
            }
        }
        
        for (int j = 0; j < 3; j++) {
            if (board[0].charAt(j) == target &&
                board[1].charAt(j) == target &&
                board[2].charAt(j) == target) {
                return true;
            }
        }
        
        if (board[0].charAt(0) == target &&
            board[1].charAt(1) == target &&
            board[2].charAt(2) == target) {
            return true;
        }

        if (board[0].charAt(2) == target &&
            board[1].charAt(1) == target &&
            board[2].charAt(0) == target) {
            return true;
        }
        
        return false;
    }
}
