class Solution {
    char[][] b;
    
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        createArray(m, n, board);
    
        while (true) {
            boolean[][] mark = findRemove(m, n);
            int removed = removeBlock(m, n, mark);
            
            if (removed == 0) break;
            
            answer += removed;
            
            gravity(m, n);
        }
        
        return answer;
    }
    
    private int removeBlock(int m, int n, boolean[][] mark) {
        int cnt = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mark[i][j]) {
                    b[i][j] = '.';
                    cnt++;
                }
            }
        }
        
        return cnt;
    }
    
    private boolean[][] findRemove(int m, int n) {
        boolean[][] mark = new boolean[m][n];
        
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                char c = b[i][j];
                if (c == '.') continue;
                if (b[i][j + 1] == c && b[i + 1][j] == c && b[i + 1][j + 1] == c) {
                    mark[i][j] = mark[i][j+1] = mark[i+1][j] = mark[i+1][j+1] = true;
                }
            }
        }
        
        return mark;
    }
    
    private void gravity(int m, int n) {
        for (int j = 0; j < n; j++) {
            int write = m - 1;
            for (int i = m - 1; i >= 0; i--) {
                if (b[i][j] != '.') {
                    b[write--][j] = b[i][j];
                }
            }
            for (int i = write; i >= 0; i--) {
                b[i][j] = '.';
            }
        }
    }
    
    private void createArray(int m, int n, String[] board) {
        b = new char[m][n];
        
        for (int i = 0; i < m; i++) b[i] = board[i].toCharArray();
    }
}