import java.util.*;

class Solution {
    
    static int[] dx = {-1, 1, 0, 0};  // 좌, 우, 하, 상
    static int[] dy = {0, 0, -1, 1};
    
    public int solution(String dirs) {
        
        return findDirection(dirs);
    }
    
    private int findDirection(String dirs) {
        int dist = 0;
        boolean[][][] visited = new boolean[11][11][4];
        
        int x = 5;
        int y = 5;
        
        for (char dir : dirs.toCharArray()) {
            int d = getDirIdx(dir);
            
            int nx = x + dx[d];
            int ny = y + dy[d];
            
            if (nx < 0 || ny < 0 || nx >= 11 || ny >= 11) continue;
            
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
    
    private int getDirIdx(char dir) {
        switch(dir) {
            case 'L' : return 0;
            case 'R' : return 1;
            case 'D' : return 2;
            case 'U' : return 3;
        }
        
        return -1;
    }
    
    private int reverseDir(int d) {
        switch(d) {
            case 0 : return 1;
            case 1 : return 0;
            case 2 : return 3;
            case 3 : return 2;
        }
        
        return -1;
    }
}