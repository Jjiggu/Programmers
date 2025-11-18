import java.util.*;

class Solution {
    
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};
    int R, C;
    
    public int[] solution(String[] grid) {
        R = grid.length;
        C = grid[0].length();
        
        boolean[][][] visited = new boolean[R][C][4];
        List<Integer> answer = new ArrayList<>();
        
        for (int x = 0; x < R; x++) {
            for (int y = 0; y < C; y++) {
                for (int dir = 0; dir < 4; dir++) {
                    if (!visited[x][y][dir]) {
                        int len = trace(grid, visited, x, y, dir);
                        answer.add(len);
                    }
                }
            }
        }
        
        Collections.sort(answer);
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
    
    private int trace(String[] grid, boolean[][][] visited, int sx, int sy, int sd) {
        int x = sx;
        int y = sy;
        int dir = sd;
        int cnt = 0;
        
        while (!visited[x][y][dir]) {
            visited[x][y][dir] = true;
            cnt++;
            
            char c = grid[x].charAt(y);
            
            if (c == 'L') {
                if (dir == 0) dir = 3;
                else if (dir == 1) dir = 2;
                else if (dir == 2) dir = 0;
                else if (dir == 3) dir = 1;
            } else if (c == 'R') {
                if (dir == 0) dir = 2;
                else if (dir == 1) dir = 3;
                else if (dir == 2) dir = 1;
                else if (dir == 3) dir = 0;
            }
            
            x = (x + dx[dir] + R) % R;
            y = (y + dy[dir] + C) % C;
            
            if (x == sx && y == sy && dir == sd) break;
        }
        
        return cnt;
    }
}