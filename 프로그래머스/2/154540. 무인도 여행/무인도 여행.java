import java.util.*;

class Solution {
    
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    int n, m;
        
    public int[] solution(String[] maps) {
        this.n = maps.length;
        this.m = maps[0].length();
        String[][] land = new String[n][m];
        boolean[][] visited = new boolean[n][m];
        int idx = 0;
        List<Integer> answer = new ArrayList<>();
        
        for (String map : maps) {
            land[idx] = map.split("");
            idx++;
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!land[i][j].equals("X") && !visited[i][j]) {
                    visited[i][j] = true;
                    int dist = bfs(land, visited, i, j);
                    answer.add(dist);
                }
            }
        }
        
        if (answer.size() == 0) {
            return new int[]{-1};
        } else {
            Collections.sort(answer);
            return answer.stream().mapToInt(Integer::intValue).toArray();
        }
    }
    
    private int bfs(String[][] land, boolean[][] visited, int startX, int startY) {
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{startX, startY});
        int dist = Integer.parseInt(land[startX][startY]);
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx < n && ny < m && nx >= 0 && ny >= 0) {
                    if (!land[nx][ny].equals("X") && !visited[nx][ny]) {
                        dist += Integer.parseInt(land[nx][ny]);
                        q.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        
        return dist;
    }
}