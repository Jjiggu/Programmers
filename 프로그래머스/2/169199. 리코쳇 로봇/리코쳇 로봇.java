import java.util.*;

class Solution {
    
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    int n, m;
    
    public int solution(String[] board) {
        int answer = -1;
        this.n = board.length;
        this.m = board[0].length();
        String[][] map = new String[n][m];
        
        for (int i = 0; i < n; i++) map[i] = board[i].split("");
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j].equals("R")) {
                    answer = bfs(i, j, map);
                    return answer;
                }
            }
        }
        
        return -1;
    }
    
    private int bfs(int startX, int startY, String[][] map) {
        boolean[][] visited = new boolean[n][m];
        Deque<int[]> q = new ArrayDeque<>();
        
        q.add(new int[]{startX, startY, 0});
        visited[startX][startY] = true;
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int moveCnt = cur[2];
            
            if (map[x][y].equals("G")) return moveCnt;
            
            for (int i = 0; i < 4; i++) {
                int[] next = slide(x, y, i, map);
                int nx = next[0];
                int ny = next[1];
                
                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny, moveCnt + 1});
                }
            }
        }
        
        return -1;
    }
    
    private int[] slide(int x, int y, int dir, String[][] map) {
        int nx = x;
        int ny = y;

        while (true) {
            int tx = nx + dx[dir];
            int ty = ny + dy[dir];

            if (tx < 0 || ty < 0 || tx >= n || ty >= m) break;
            if (map[tx][ty].equals("D")) break;

            nx = tx;
            ny = ty;
        }

        return new int[]{nx, ny};
    }
}