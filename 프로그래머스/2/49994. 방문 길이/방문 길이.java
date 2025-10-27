import java.util.*;

class Solution {
    
    static int[] dx = {-1, 1, 0, 0};  // 좌, 우, 하, 상
    static int[] dy = {0, 0, -1, 1};
    static int[][] map;
    
    public int solution(String dirs) {
        map = new int[11][11];
        
        return bfs(new int[]{5, 5}, map, dirs);
    }
    
    private int bfs(int[] start, int[][] map, String dirs) {
        boolean[][][] visited = new boolean[11][11][4];
        
        int dist = 0;
        int x = start[0];
        int y = start[1];
        
        for (char dir : dirs.toCharArray()) {
            int d = getDirIndex(dir);
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx < 0 || nx > 10 || ny < 0 || ny > 10) continue;

            if (!visited[x][y][d]) {
                visited[x][y][d] = true;
                visited[nx][ny][reverseDir(d)] = true;
                dist++;
            }
            
            x = nx;
            y = ny;
        }
        
        return dist;
    }
    
    private int getDirIndex(char dir) {
        switch (dir) {
            case 'L': return 0;
            case 'R': return 1;
            case 'D': return 2;
            case 'U': return 3;
        }
        return -1; 
    }
    
     private int reverseDir(int d) {
        if (d == 0) return 1; // L <-> R
        if (d == 1) return 0;
        if (d == 2) return 3; // D <-> U
        return 2;
    }
}