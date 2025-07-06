import java.util.*;

class Solution {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public int solution(String[] storage, String[] requests) {
        int n = storage.length;
        int m = storage[0].length();
        int[][] map = setOutline(n, m);
        
        for (String request : requests) {
            char c = request.charAt(0);
            if (request.length() == 1) {
                Deque<int[]> q = new ArrayDeque<>();
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        if (storage[i].charAt(j) == c && bfs(i + 1, j + 1, c, map)) {
                            q.add(new int[]{i + 1, j + 1});
                        }
                    }
                }
                while(!q.isEmpty()) {
                    int[] cur = q.poll();
                    map[cur[0]][cur[1]] = -1;
                }
            } else {
                map = removeContainer(c, map, storage);
            }
        }
        return findAnswer(map);
    }
    
    public boolean bfs(int startX, int startY, char c, int[][] map) {
        Deque<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[map.length][map[0].length];
        q.add(new int[]{startX, startY});
        visited[startX][startY] = true;
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            if (map[x][y] == -2) return true;
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (visited[nx][ny]) continue;
                if (map[nx][ny] == 0) continue;
                q.add(new int[]{nx, ny});
                visited[nx][ny] = true;
            }
        }
        
        return false;
    }
    
    public int[][] removeContainer(char c, int[][] map, String[] storage) {
        for (int i = 1; i < map.length - 1; i++) {
            for (int j = 1; j < map[0].length - 1; j++) {
                if (storage[i - 1].charAt(j - 1) == c) map[i][j] = -1;
            }
        }
        return map;
    }
    
    public int findAnswer(int[][] map) {
        int cnt = 0;
        
        for (int i = 1; i < map.length - 1; i++) {
            for (int j = 1; j < map[0].length - 1; j++) {
                if (map[i][j] == 0) cnt++;
            }
        }
        
        return cnt;
    }
    
    public int[][] setOutline(int n, int m) {
        int[][] map = new int[n + 2][m + 2];
        
        for (int i = 0; i < n + 2; i++) {
            for (int j = 0; j < m + 2; j++) {
                if (i == 0) map[i][j] = -2;
                if (j == 0) map[i][j] = -2;
                if (i == n + 1) map[i][j] = -2;
                if (j == m + 1) map[i][j] = -2;
            }
        }
        return map;
    }
}