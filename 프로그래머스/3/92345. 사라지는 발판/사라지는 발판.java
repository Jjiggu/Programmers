class Solution {
    
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    int n, m;
    
    public int solution(int[][] board, int[] aloc, int[] bloc) {
        n = board.length;
        m = board[0].length;
        
        int[] result = dfs(aloc[0], aloc[1], bloc[0], bloc[1], board);
        
        return result[1];
    }
    
    private int[] dfs(int x, int y, int ox, int oy, int[][] board) {
        if (board[x][y] == 0) return new int[]{0, 0};
        
        boolean canWin = false;
        boolean moved = false;
        int minWin = Integer.MAX_VALUE;
        int maxLose = 0;
        
        board[x][y] = 0;
        
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
            if (board[nx][ny] == 0) continue;
            
            moved = true;
            
            int[] res = dfs(ox, oy, nx, ny, board);
            
            if (res[0] == 0) {
                canWin = true;
                minWin = Math.min(minWin, res[1]);
            } else {
                maxLose = Math.max(maxLose, res[1]);
            }
        }
        
        board[x][y] = 1;
            
        if (!moved) return new int[]{0, 0};

        if (canWin) return new int[]{1, minWin + 1};
        else return new int[]{0, maxLose + 1};
    }
}