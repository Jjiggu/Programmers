import java.util.*;

class Solution {
    
    static int[] dx = {-1, 0, 1, 0}; 
    static int[] dy = {0, 1, 0, -1};
    int n;
    int m;
    List<Integer> answer = new ArrayList<>();
    boolean[][][] visited; 
    
    public int[] solution(String[] grid) {
        // 시작점에서 4방향으로 dfs 진행 -> 시작 지점으로 돌아오는 경우 사이클 
        n = grid.length;
        m = grid[0].length();
        visited = new boolean[n][m][4];  // 이때 들어오는 방향을 체크하기위해 3차원 배열 사용
        
        // 사이클 탐색 
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int d = 0; d < 4; d++) {
                    if (!visited[i][j][d]) {
                        int len = findCycle(i, j, d, grid);   
                        answer.add(len);
                    }
                }
            }
        }
        
        // 정답 오름차순 정렬
        Collections.sort(answer);
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
    
    private int findCycle(int x, int y, int dir, String[] grid) {    
        
        int len = 0;
        int sx = x;
        int sy = y;
        int sDir = dir;
        
        while (!visited[x][y][dir]) {
            visited[x][y][dir] = true;
            len++;
            
            char c = grid[x].charAt(y);
            
            if (c == 'L') dir = (dir + 3) % 4;
            else if (c == 'R') dir = (dir + 1) % 4;

            // 범위 밖으로 나가는 경우 좌표 보정
            x = (x + dx[dir] + n) % n;
            y = (y + dy[dir] + m) % m;
            
            if (x == sx && y == sy && dir == sDir) break;
        }
        
       return len;
    }
}