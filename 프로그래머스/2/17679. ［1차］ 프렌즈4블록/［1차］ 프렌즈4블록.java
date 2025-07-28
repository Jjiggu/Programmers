class Solution {
    public int solution(int m, int n, String[] board) {
        
        char[][] b = new char[m][n];
        for (int i = 0; i < m; i++) {
            b[i] = board[i].toCharArray();
        }
        
        int answer = 0;
        while(true) {
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
            
            int removed = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (mark[i][j]) {
                        b[i][j] = '.';
                        removed++;
                    }
                }
            }
            if (removed == 0) break;
            
            answer += removed;
            
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
        
        return answer;
    }
}