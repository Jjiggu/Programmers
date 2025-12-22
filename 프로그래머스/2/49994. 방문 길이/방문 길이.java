import java.util.*;

class Solution {
    
    static int[] dx = {0, 0, -1, 1};  // 상, 하, 좌, 우
    static int[] dy = {1, -1, 0, 0};
    
    public int solution(String dirs) {
        int answer = bfs(dirs);
        
        return answer;
    }
    
    private int bfs(String dirs) {        
        int dist = 0;
        boolean[][][] visited = new boolean[11][11][4];
        int x = 5;
        int y = 5;
        
        for (char c : dirs.toCharArray()) {            
            int dir = convertDir(c);
            
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            
            if (nx < 0 || ny < 0 || nx >= 11 || ny >= 11) continue;

            if (!visited[x][y][dir]) {
                visited[x][y][dir] = true;
                visited[nx][ny][reverseDir(dir)] = true;
                dist++;
            }
            
            x = nx;
            y = ny;
        }
        
        return dist;
    }
    
    private int convertDir(char dir) {
        switch (dir) {
            case 'U': return 0;
            case 'D': return 1;
            case 'L': return 2;
            case 'R': return 3;
        }
        
        return -1;
    }
    
    private int reverseDir(int dir) {
        switch (dir) {
            case 0: return 1;
            case 1: return 0;
            case 2: return 3;
            case 3: return 2;
        }
        
        return -1;
    }
}