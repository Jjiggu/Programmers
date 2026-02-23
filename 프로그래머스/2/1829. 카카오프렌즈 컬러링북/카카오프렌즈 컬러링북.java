import java.util.*;

class Solution {
    
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    int maxSizeOfOneArea = 0;
    
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int[] answer = new int[2];

        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] != 0) {
                    bfs(i, j, m, n, picture[i][j], picture);
                    picture[i][j] = 0;
                    numberOfArea++;
                }
            }
        }
        
        return new int[]{numberOfArea, maxSizeOfOneArea};
    }
    
    private int bfs(int startX, int startY, int m, int n, int target, int[][] picture) {
        boolean[][] visited = new boolean[m][n];
        Deque<int[]> q = new ArrayDeque<>();
        int cnt = 1;
        
        q.add(new int[]{startX, startY});
        visited[startX][startY] = true;
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx < 0 || ny < 0 || nx >= m || ny >= n) continue;
                if (visited[nx][ny] || picture[nx][ny] != target) continue;
                
                picture[nx][ny] = 0;
                q.add(new int[]{nx, ny});
                visited[nx][ny] = true;
                cnt++;
            }
        }
        
        maxSizeOfOneArea = Math.max(maxSizeOfOneArea, cnt);
        
        return cnt;
    }
}