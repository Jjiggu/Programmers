import java.util.*;

public class Solution {
    
    class Component {
        int size;
        int compId;
        
        public Component(int size, int compId) {
            this.size = size;
            this.compId = compId;
        }
    }
    
    int answer = 0;
    int n, m;
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    
    public int solution(int[][] land) {
        this.n = land.length;
        this.m = land[0].length;
        boolean[][] visited = new boolean[n][m];
        int compId = 2;  // 식별자 
        int[] sizeArr = new int[n * m + 2];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {            
                if (!visited[j][i] && land[j][i] == 1) {
                    Component component = bfs(j, i, land, visited, compId);
                    sizeArr[component.compId] = component.size;
                    compId++;
                }
            }
        }
        
        for (int i = 0; i < m; i++) {
            int total = 0;
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < n; j++) {            
                int id = land[j][i];
                if (id > 1 && set.add(id)) total += sizeArr[id];
            }
            
            answer = Math.max(answer, total);
        }
        
        return answer;
    }
    
    private Component bfs(int startX, int startY, int[][] land, boolean[][] visited, int compId) {
        
        Deque<int[]> q = new ArrayDeque<>();
        visited[startX][startY] = true;
        land[startX][startY] = compId;
        q.offer(new int[]{startX, startY});
        int cnt = 1;
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (!visited[nx][ny] && land[nx][ny] == 1) {
                        cnt++;
                        visited[nx][ny] = true;
                        land[nx][ny] = compId;
                        q.offer(new int[]{nx, ny});
                    }
                }
            }
        }
        
        return new Component(cnt, compId);
    }
}
