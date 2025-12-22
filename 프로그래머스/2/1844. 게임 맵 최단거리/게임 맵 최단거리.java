import java.util.*;

class Solution {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    int n, m;
    
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        
        int answer = bfs(0, 0, maps);
        
        return answer;
    }
    
    private int bfs(int startX, int startY, int[][] maps) {
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{startX, startY});
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            
            if (x == n - 1 && y == m - 1) return maps[x][y];
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (maps[nx][ny] == 1) {
                    maps[nx][ny] += maps[x][y];
                    q.add(new int[]{nx, ny});   
                }
            }
        }
        
        return -1;
    }
}