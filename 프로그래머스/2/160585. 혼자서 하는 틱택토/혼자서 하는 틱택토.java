class Solution {
    
    int oCnt = 0;
    int xCnt = 0;
    
    public int solution(String[] board) {
        // 매 호출마다 초기화
        oCnt = 0;
        xCnt = 0;
        count(board);
        
        // 1. 말 개수 기본 규칙
        if (xCnt > oCnt) return 0;
        if (oCnt - xCnt > 1) return 0;
        
        boolean oWin = isWin(board, 'O');
        boolean xWin = isWin(board, 'X');
        
        // 2. 둘 다 이긴 경우는 불가능
        if (oWin && xWin) return 0;
        
        // 3. O가 이긴 경우: O는 항상 X보다 한 수 더 많이 둔 상태여야 함
        if (oWin && oCnt != xCnt + 1) return 0;
        
        // 4. X가 이긴 경우: X는 항상 O와 같은 수를 둔 상태여야 함
        if (xWin && oCnt != xCnt) return 0;
        
        // 5. 그 외는 모두 가능한 상태
        return 1;
    }
    
    private boolean isWin(String[] board, char target) {
        // 가로 3줄
        for (int i = 0; i < 3; i++) {
            if (board[i].charAt(0) == target &&
                board[i].charAt(1) == target &&
                board[i].charAt(2) == target) {
                return true;
            }
        }

        // 세로 3줄
        for (int j = 0; j < 3; j++) {
            if (board[0].charAt(j) == target &&
                board[1].charAt(j) == target &&
                board[2].charAt(j) == target) {
                return true;
            }
        }

        // 대각선 2줄
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
    
    private void count(String[] board) {
        for (int i = 0; i < 3; i++) {
            String row = board[i];
            for (int j = 0; j < 3; j++) {
                char c = row.charAt(j);
                if (c == 'O') oCnt++;
                else if (c == 'X') xCnt++;
            }
        }
    }
}
