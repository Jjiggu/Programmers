import java.util.*;

class Solution {
    
    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};
    
    class Pos {
        int x;
        int y;
        
        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public int[] solution(int m, int n, int[][] picture) {
        int[] answer = new int[2];

        int maxArea = 0;
        int areaCnt = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] != 0) {
                    int area = bfs(i, j, m, n, picture[i][j], picture);
                    maxArea = Math.max(maxArea, area);
                    areaCnt++;
                }
            }
        }
        
        return new int[]{areaCnt, maxArea};
    }
    
    private int bfs(int startX, int startY, int m, int n, int target, int[][] picture) {
            
        Deque<Pos> q = new ArrayDeque<>();
        q.add(new Pos(startX, startY));
        picture[startX][startY] = 0;
        
        int area = 1;
        
        while (!q.isEmpty()) {
            Pos cur = q.poll();
            int x = cur.x;
            int y = cur.y;
            
            for (int i = 0; i < 4; i++) {        
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx < 0 || ny < 0 || nx >= m || ny >= n) continue;
                if (picture[nx][ny] != target) continue;
                
                picture[nx][ny] = 0;
                q.add(new Pos(nx, ny));
                area++;
            }
        }
        
        return area;
    }
}