import java.util.*;

class Solution {
    
    int n, m;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public int solution(int[][] land) {
        int answer = 0;
        n = land.length;
        m = land[0].length;
        int groupId = 2;
        int[] groupSize = new int[250002];
        boolean[][] visited = new boolean[n][m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && land[i][j] == 1) {
                    land[i][j] = groupId;
                    int size = bfs(i, j, groupId, visited, land);
                    groupSize[groupId++] = size;
                }
            }
        }
        
        for (int row = 0; row < m; row++) {
            Set<Integer> set = new HashSet<>();
            for (int col = 0; col < n; col++) {
                if (land[col][row] != 0)
                set.add(land[col][row]);
            }
            answer = Math.max(answer, calcSet(set, groupSize));
        }
        
        return answer;
    }
    
    private int bfs(int startX, int startY, int groupId, boolean[][] visited, int[][] land) {
        land[startX][startY] = groupId;;
        visited[startX][startY] = true;
        int size = 1;
        
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{startX, startY});
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (!visited[nx][ny] && land[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    land[nx][ny] = groupId;
                    q.add(new int[]{nx, ny});
                    size++;
                }
            }
        }
        
        return size;
    }
    
    private int calcSet(Set<Integer> set, int[] groupSize) {
        int oilCnt = 0;
        
        for (int groupId : set) {
            oilCnt += groupSize[groupId];
        }
        
        return oilCnt;
    }
}